package com.example.with_db.database.column;

public record ColumnMeta(String name, DataType dataType, boolean nonNull, boolean hasDefault) {
}
