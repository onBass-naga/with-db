package ${packageName};

import com.example.with_db.database.ResultSetWrapper;
<#list importStatements as importStatement>
${importStatement}
</#list>

public record ${table.upperCamelCaseSingularName()}Entity(
        <#list columns as column>
        ${column.className()} ${column.lowerCamelCaseName()}<#if column_has_next>,</#if>
        </#list>
) {

    public static ${table.upperCamelCaseSingularName()}Entity of(final ResultSetWrapper resultSet) {
        return new ${table.upperCamelCaseSingularName()}Entity(
                <#list columns as column>
                resultSet.${column.getter()}("${column.name()}")<#if column_has_next>,</#if>
                </#list>
        );
    }
}
