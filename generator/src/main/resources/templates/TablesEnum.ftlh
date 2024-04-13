package ${packageName};

import com.example.with_db.database.Table;
import com.example.with_db.database.column.ColumnMeta;

import java.util.Map;

public enum Tables implements Table {

    <#list tables as table>
    ${table.upperCaseName()}("${table.name()}", Map.ofEntries(
            <#assign columns = table.columns()>
            <#list columns as column>
            Map.entry("${column.name()}", new ColumnMeta("${column.name()}", ${column.requiredText()}))<#if column_has_next>,</#if>
            </#list>
    ))<#if table_has_next>,<#else>;</#if>
    </#list>

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
