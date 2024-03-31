package com.example.with_db.database;

public interface Table {
    Class<? extends Record> recordClass();
}
