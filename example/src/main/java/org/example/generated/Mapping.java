package org.example.generated;


import com.example.with_db.database.column.ColumnMeta;
import com.example.with_db.database.column.DataType;

import java.util.Map;
import java.util.Optional;

public class Mapping {
    private static final Map<String, Map<String, ColumnMeta>> MAP = Map.ofEntries(
            Map.entry("members", Map.ofEntries(
                    Map.entry("id", new ColumnMeta(DataType.BIGINT, true)),
                    Map.entry("name", new ColumnMeta(DataType.VARCHAR, true)),
                    Map.entry("birthday", new ColumnMeta(DataType.DATE, false)),
                    Map.entry("created_at", new ColumnMeta(DataType.TIMESTAMP, true))
            ))
    );

    public static Map<String, ColumnMeta> getColumnMetaMapping(final String tableName) {
        return Optional.ofNullable(MAP.get(tableName))
                .orElseThrow(() -> new IllegalArgumentException("%s does not exist.".formatted(tableName)));
    }
}
