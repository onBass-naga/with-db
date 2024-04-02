package com.example.with_db.assertion;

import com.example.with_db.database.Table;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;


public class DataSet {
    private final Map<Class<? extends Table>, Records> records;

    public DataSet(final Map<Class<? extends Table>, Records> records) {
        this.records = records;
    }

    public static DataSet load(final Connection connection, final Table... tables) {
        return load(connection, List.of(tables));
    }

    public static DataSet load(final Connection connection, final List<Table> tables) {

        final Map<Class<? extends Table>, Records> dataSet = new HashMap<>();

        for (final var table : tables) {
            final List<Map<String, Object>> records = new ArrayList<>();

            try {
                final var stmt = connection.createStatement();
                final var sql = "SELECT * FROM %s".formatted(table.tableName());
                final var resultSet = stmt.executeQuery(sql);

                while (resultSet.next()) {
                    final Map<String, Object> record = new HashMap<>();
                    final var columnMetas = table.columnMetas();
                    for (final var meta : columnMetas) {
                        final var columnName = meta.name();
                        final Object value = switch (meta.dataType()) {
                            case BIGINT -> resultSet.getLong(columnName);
                            case DATE -> resultSet.getDate(columnName);
                            case TIMESTAMP -> resultSet.getTimestamp(columnName);
                            default -> resultSet.getString(columnName);
                        };

                        record.put(columnName, value);
                    }

                    records.add(record);
                }

                dataSet.put(table.getClass(), new Records(records));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return new DataSet(dataSet);
    }

    public Records get(Table table) {
        return Optional.ofNullable(records.get(table.getClass()))
                .orElseThrow(() -> new IllegalArgumentException("%s not found.".formatted(table.getClass().getSimpleName())));
    }

//    public <T> Records<T> get(final Class<T> clazz) {
//        final var value = records.get(clazz);
//        //noinspection unchecked
//        return (Records<T>) value;
//    }
}
