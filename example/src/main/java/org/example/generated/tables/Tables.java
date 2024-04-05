package org.example.generated.tables;

import com.example.with_db.database.Table;
import com.example.with_db.database.column.ColumnMeta;
import com.example.with_db.database.column.DataType;

import java.util.Map;

public enum Tables implements Table {
    MEMBERS("members", Map.ofEntries(
            Map.entry("id", new ColumnMeta("id", DataType.BIGINT, true, true)),
            Map.entry("name", new ColumnMeta("name", DataType.VARCHAR, true, false)),
            Map.entry("birthday", new ColumnMeta("birthday", DataType.DATE, false, false)),
            Map.entry("created_at", new ColumnMeta("created_at", DataType.TIMESTAMP, true, true))
    ));

    private final String tableName;
    private final Map<String, ColumnMeta> columnMap;

    Tables(String tableName, Map<String, ColumnMeta> columnMap) {
        this.tableName = tableName;
        this.columnMap = columnMap;
    }

    public String tableName() {
        return tableName;
    }

    public Map<String, ColumnMeta> columnMap() {
        return columnMap;
    }
}
