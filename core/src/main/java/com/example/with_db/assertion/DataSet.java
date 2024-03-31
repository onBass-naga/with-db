package com.example.with_db.assertion;

import com.example.with_db.database.Records;
import com.example.with_db.database.Table;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class DataSet {
    private final Map<Class<? extends Record>, Records<? extends Record>> records;

    public DataSet(final Map<Class<? extends Record>, Records<? extends Record>> records) {
        this.records = records;
    }

    public static DataSet load(final Connection connection, final List<Table> tables) {
//        return new DataSet(Map.of(tables.get(0).recordClass(), new Records(List.of())));
        return null;
    }

    public <T> Records<T> get(final Class<T> clazz) {
        final var value = records.get(clazz);
        //noinspection unchecked
        return (Records<T>) value;
    }
}
