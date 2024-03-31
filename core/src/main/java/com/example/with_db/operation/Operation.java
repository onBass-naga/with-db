package com.example.with_db.operation;

import java.sql.Connection;
import java.util.List;

public class Operation {

    private final Connection connection;

    public Operation(final Connection connection) {
        this.connection = connection;
    }

    public void insert(final Record record) {
        insert(List.of(record));
    }

    public void insert(final Record... records) {
        insert(List.of(records));
    }

    public void insert(final List<Record> records) {
//        InsertOperation.execute(connection, records);
    }
}
