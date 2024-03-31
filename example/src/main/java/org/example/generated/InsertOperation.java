package org.example.generated;

import com.example.with_db.database.TableName;
import com.example.with_db.database.column.ColumnMeta;
import com.example.with_db.database.column.ColumnName;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class InsertOperation {
    public static void execute(final Connection connection, final List<Record> records) {
        try {
            connection.setAutoCommit(false);
            records.forEach(record -> execute(connection, record));
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

    private static void execute(final Connection connection, final Record record) {
        final List<String> columnNames = new ArrayList<>();
        final List<Object> values = new ArrayList<>();
        final List<String> placeholders = new ArrayList<>();

        for (var field : record.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Optional.ofNullable(field.getAnnotation(ColumnName.class))
                    .filter(it -> !Objects.equals(it.value(), "created_at")) // TODO: default値の取り扱い
                    .ifPresent(it -> {
                        columnNames.add(it.value());
                        try {
                            values.add(field.get(record));
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                        placeholders.add("?");
                    });
        }

        final var tableName = record.getClass().getAnnotation(TableName.class).value();

        final var sql = "INSERT INTO " +
                tableName +
                "(%s) ".formatted(String.join(", ", columnNames)) +
                "VALUES " +
                "(%s);".formatted(String.join(", ", placeholders));

        final Map<String, ColumnMeta> columnMetaMapping = Mapping.getColumnMetaMapping(tableName);
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            for (int i = 0; i < values.size(); i++) {
                final var meta = Optional.ofNullable(columnMetaMapping.get(columnNames.get(i)))
                        .orElseThrow(() -> new IllegalArgumentException("%s does not exist in %s.".formatted(columnNames, tableName)));

                switch (meta.dataType()) {
                    case BIGINT:
                        ps.setLong(i + 1, (Long) values.get(i));
                        break;
                    case DATE:
                        ps.setDate(i + 1, (Date) values.get(i));
                        break;
                    case TIMESTAMP:
                        ps.setTimestamp(i + 1, (Timestamp) values.get(i));
                        break;
                    default:
                        ps.setString(i + 1, (String) values.get(i));
                }
            }

            ps.executeUpdate();
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
