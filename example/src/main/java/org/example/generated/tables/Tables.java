package org.example.generated.tables;

import com.example.with_db.database.Table;
import com.example.with_db.database.column.ColumnMeta;
import com.example.with_db.database.column.ResultSetDataType;

import java.util.Map;

public enum Tables implements Table {
    MEMBERS("members", Map.ofEntries(
            Map.entry("id", new ColumnMeta("id", ResultSetDataType.LONG, true, true)),
            Map.entry("name", new ColumnMeta("name", ResultSetDataType.STRING, true, false)),
            Map.entry("birthday", new ColumnMeta("birthday", ResultSetDataType.DATE, false, false)),
            Map.entry("created_at", new ColumnMeta("created_at", ResultSetDataType.TIMESTAMP, true, true))
    )),
    DATA_TYPES("DATA_TYPES", Map.ofEntries(
            Map.entry("id", new ColumnMeta("id", ResultSetDataType.LONG, true, true)),
            Map.entry("name", new ColumnMeta("name", ResultSetDataType.STRING, true, false)),
            Map.entry("birthday", new ColumnMeta("birthday", ResultSetDataType.DATE, false, false)),
            Map.entry("created_at", new ColumnMeta("created_at", ResultSetDataType.TIMESTAMP, true, true))
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
