package com.example.with_db.operation;

import com.example.with_db.database.PreparedStatementWrapper;
import com.example.with_db.utils.ReflectionUtils;
import com.example.with_db.database.SetupModel;
import com.example.with_db.database.column.ColumnName;

import java.sql.*;
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
                        return !(value == null && !columnMeta.required());
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

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            final var ps = new PreparedStatementWrapper(preparedStatement);
            for (int i = 0; i < values.size(); i++) {
                ps.setValue(i, values.get(i));
            }

            ps.executeUpdate();

        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
