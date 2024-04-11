package com.example.with_db.operation;

import com.example.with_db.utils.ReflectionUtils;
import com.example.with_db.database.SetupModel;
import com.example.with_db.database.column.ColumnName;

import java.math.BigDecimal;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class InsertOperation {

    public static void execute(final Connection connection, final SetupModel... rows) {
        execute(connection, List.of(rows));
    }

    public static void execute(final Connection connection, final List<SetupModel> rows) {
        try {
            connection.setAutoCommit(false);
            rows.forEach(row -> execute(connection, row));
            connection.commit();

        } catch (final Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    private static void execute(final Connection connection, final SetupModel row) {

        final var tableMeta = row.tableMeta();
        final List<String> columnNames = new ArrayList<>();
        final List<Object> values = new ArrayList<>();
        final List<String> placeholders = new ArrayList<>();

        for (var field : row.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Optional.ofNullable(field.getAnnotation(ColumnName.class))
                    .filter(annotation -> {
                        // デフォルト値やID採番されるカラムにはnullを渡さないよう除外する
                        final var columnName = annotation.value();
                        final var columnMeta = tableMeta.columnMeta(columnName);
                        final var value = ReflectionUtils.getFieldValue(field, row);
                        return !(value == null && columnMeta.hasDefault());
                    })
                    .ifPresent(it -> {
                        columnNames.add(it.value());
                        values.add(ReflectionUtils.getFieldValue(field, row));
                        placeholders.add("?");
                    });
        }

        final var sql = "INSERT INTO " +
                tableMeta.tableName() +
                "(%s) ".formatted(String.join(", ", columnNames)) +
                "VALUES " +
                "(%s);".formatted(String.join(", ", placeholders));

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            for (int i = 0; i < values.size(); i++) {
                final var meta = tableMeta.columnMeta(columnNames.get(i));
                switch (meta.dataType()) {
                    case STRING -> ps.setString(i + 1, (String) values.get(i));
                    case SHORT -> ps.setShort(i + 1, (Short) values.get(i));
                    case INTEGER -> ps.setInt(i + 1, (Integer) values.get(i));
                    case LONG -> ps.setLong(i + 1, (Long) values.get(i));
                    case DOUBLE -> ps.setDouble(i + 1, (Double) values.get(i));
                    case FLOAT -> ps.setFloat(i + 1, (Float) values.get(i));
                    case BIG_DECIMAL -> ps.setBigDecimal(i + 1, (BigDecimal) values.get(i));
                    case BOOLEAN -> ps.setBoolean(i + 1, (Boolean) values.get(i));
                    case BYTE_ARRAY -> ps.setBytes(i + 1, (byte[]) values.get(i));
                    case DATE -> ps.setDate(i + 1, (Date) values.get(i));
                    case TIME -> ps.setTime(i + 1, (Time) values.get(i));
                    case TIMESTAMP -> ps.setTimestamp(i + 1, (Timestamp) values.get(i));
                }
            }

            ps.executeUpdate();
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
