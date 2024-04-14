package org.example.generated.tables;

import com.example.with_db.database.Table;
import com.example.with_db.database.column.ColumnMeta;

import java.util.Map;

public enum Tables implements Table {

    DATA_TYPES("data_types", Map.ofEntries(
            Map.entry("bool_column", new ColumnMeta("bool_column", false)),
            Map.entry("bit_column", new ColumnMeta("bit_column", false)),
            Map.entry("int8_column", new ColumnMeta("int8_column", false)),
            Map.entry("bigserial_column", new ColumnMeta("bigserial_column", false)),
            Map.entry("oid_column", new ColumnMeta("oid_column", false)),
            Map.entry("bytea_column", new ColumnMeta("bytea_column", false)),
            Map.entry("char_column", new ColumnMeta("char_column", false)),
            Map.entry("bpchar_column", new ColumnMeta("bpchar_column", false)),
            Map.entry("numeric_column", new ColumnMeta("numeric_column", false)),
            Map.entry("int4_column", new ColumnMeta("int4_column", false)),
            Map.entry("serial_column", new ColumnMeta("serial_column", false)),
            Map.entry("int2_column", new ColumnMeta("int2_column", false)),
            Map.entry("smallserial_column", new ColumnMeta("smallserial_column", false)),
            Map.entry("float4_column", new ColumnMeta("float4_column", false)),
            Map.entry("float8_column", new ColumnMeta("float8_column", false)),
            Map.entry("money_column", new ColumnMeta("money_column", false)),
            Map.entry("name_column", new ColumnMeta("name_column", false)),
            Map.entry("text_column", new ColumnMeta("text_column", false)),
            Map.entry("varchar_column", new ColumnMeta("varchar_column", false)),
            Map.entry("date_column", new ColumnMeta("date_column", false)),
            Map.entry("time_column", new ColumnMeta("time_column", false)),
            Map.entry("timetz_column", new ColumnMeta("timetz_column", false)),
            Map.entry("timestamp_column", new ColumnMeta("timestamp_column", false)),
            Map.entry("timestamptz_column", new ColumnMeta("timestamptz_column", false)),
            Map.entry("xml_column", new ColumnMeta("xml_column", false))
    )),
    MEMBERS("members", Map.ofEntries(
            Map.entry("id", new ColumnMeta("id", true)),
            Map.entry("name", new ColumnMeta("name", true)),
            Map.entry("birthday", new ColumnMeta("birthday", false)),
            Map.entry("created_at", new ColumnMeta("created_at", false))
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
