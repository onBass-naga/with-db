package ${packageName};

import com.example.with_db.database.ResultSetWrapper;
import com.example.with_db.database.Table;
<#list tables as table>
import org.example.generated.assertion.records.${table.upperCamelCaseSingularName()}Entity;
import org.example.generated.assertion.records.${table.upperCamelCaseSingularName()}Records;
</#list>

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class ${dataSetPrefix}DataSet {

    private enum TABLE_SETTERS {
        <#list tables as table>
        ${table.upperCaseName()}("${table.name()}",
                (dataSet, records) -> dataSet.${table.lowerCamelCaseSingularName()}List = records.stream().map(${table.upperCamelCaseSingularName()}Entity.class::cast).toList(),
                ${table.upperCamelCaseSingularName()}Entity::of)<#if table_has_next>,<#else>;</#if>
        </#list>

        private final String tableName;
        private final BiConsumer<${dataSetPrefix}DataSet, List<Object>> setter;
        private final Function<ResultSetWrapper, Object> converter;

        TABLE_SETTERS(final String tableName,
                      final BiConsumer<${dataSetPrefix}DataSet, List<Object>> setter,
                      final Function<ResultSetWrapper, Object> converter) {
            this.tableName = tableName;
            this.setter = setter;
            this.converter = converter;
        }
    }

    <#list tables as table>
    private List<${table.upperCamelCaseSingularName()}Entity> ${table.lowerCamelCaseSingularName()}List;
    public ${table.upperCamelCaseSingularName()}Records ${table.lowerCamelCaseName()}() {
        return Optional.ofNullable(${table.lowerCamelCaseSingularName()}List)
                .map(${table.upperCamelCaseSingularName()}Records::new)
                .orElseThrow(() -> new IllegalStateException("${table.name()} did not load"));
    }

    </#list>

    public static ${dataSetPrefix}DataSet load(final Connection connection, final Table... tables) {
        return load(connection, List.of(tables));
    }

    public static ${dataSetPrefix}DataSet load(final Connection connection, final List<Table> tables) {

        final var targetTableNames = tables.stream().map(Table::tableName).toList();
        final var dataSet = new ${dataSetPrefix}DataSet();

        for (final var tableSetter : TABLE_SETTERS.values()) {

            if (!targetTableNames.contains(tableSetter.tableName)) {
                continue;
            }

            try {
                final var stmt = connection.createStatement();
                final var sql = "SELECT * FROM %s".formatted(tableSetter.tableName);
                final var resultSet = new ResultSetWrapper(stmt.executeQuery(sql));

                final List<Object> records = new ArrayList<>();
                while (resultSet.next()) {
                    records.add(tableSetter.converter.apply(resultSet));
                }

                tableSetter.setter.accept(dataSet, records);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return dataSet;
    }
}
