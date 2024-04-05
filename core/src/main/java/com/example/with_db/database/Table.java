package com.example.with_db.database;

import com.example.with_db.database.column.ColumnMeta;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Table {
    String tableName();
    Map<String, ColumnMeta> columnMap();

    default ColumnMeta columnMeta(final String columnName) {
        return Optional.ofNullable(columnMap().get(columnName))
                .orElseThrow(() -> new IllegalArgumentException("%s does not exist in %s.".formatted(columnName, tableName())));
    }

    default List<ColumnMeta> columnMetas() {
        return columnMap().values().stream().toList();
    }
}
