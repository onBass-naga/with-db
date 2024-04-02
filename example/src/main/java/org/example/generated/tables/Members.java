package org.example.generated.tables;

import com.example.with_db.database.Table;
import com.example.with_db.database.column.ColumnMeta;
import com.example.with_db.database.column.DataType;

import java.util.Map;

public class Members implements Table {
    public static String TABLE_NAME = "members";
    public static Map<String, ColumnMeta> COLUMNS = Map.ofEntries(
            Map.entry("id", new ColumnMeta("id", DataType.BIGINT, true, true)),
            Map.entry("name", new ColumnMeta("name", DataType.VARCHAR, true, false)),
            Map.entry("birthday", new ColumnMeta("birthday", DataType.DATE, false, false)),
            Map.entry("created_at", new ColumnMeta("created_at", DataType.TIMESTAMP, true, true))
    );

    @Override
    public String tableName() {
        return TABLE_NAME;
    }

    @Override
    public Map<String, ColumnMeta> columnMetaMap() {
        return COLUMNS;
    }
}
