package com.example.with_db.database.column;

public record ColumnMeta(String name, ResultSetDataType dataType, boolean nonNull, boolean hasDefault) {
}
