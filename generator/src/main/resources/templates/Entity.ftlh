package ${packageName};

import java.sql.ResultSet;
import java.sql.SQLException;
<#list importStatements as importStatement>
${importStatement}
</#list>

public record ${table.upperCamelCaseSingularName()}Entity(
        <#list columns as column>
        ${column.className()} ${column.lowerCamelCaseName()}<#if column_has_next>,</#if>
        </#list>
) {

    public static ${table.upperCamelCaseSingularName()}Entity of(final ResultSet resultSet) {
        try {
            return new ${table.upperCamelCaseSingularName()}Entity(
                    <#list columns as column>
                    resultSet.${column.getter()}("${column.name()}")<#if column_has_next>,</#if>
                    </#list>
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
