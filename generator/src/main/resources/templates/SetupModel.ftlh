package ${packageName};

import com.example.with_db.database.column.ColumnName;
import com.example.with_db.database.SetupModel;
import org.example.generated.tables.Tables;

<#list importStatements as importStatement>
${importStatement}
</#list>

public record ${tableName.upperCamelCaseSingular()}(
        <#list columns as column>
        @ColumnName("${column.name().value()}") ${column.className()} ${column.name().lowerCamelCase()}<#if column_has_next>,</#if>
        </#list>
    ) implements SetupModel {

    @Override
    public Tables tableMeta() {
        return Tables.${tableName.upperCase()};
    }

    public static class Builder {
        <#list columns as column>
        private ${column.className()} ${column.name().lowerCamelCase()};
        </#list>

        public Builder(
                <#list columns as column>
                ${column.className()} ${column.name().lowerCamelCase()}<#if column_has_next>,</#if>
                </#list>
        ) {
            <#list columns as column>
            this.${column.name().lowerCamelCase()} = ${column.name().lowerCamelCase()};
            </#list>
        }

        <#list columns as column>
        public Builder ${column.name().lowerCamelCase()}(final ${column.className()} ${column.name().lowerCamelCase()}) {
            this.${column.name().lowerCamelCase()} = ${column.name().lowerCamelCase()};
            return this;
        }

        </#list>

        public ${tableName.upperCamelCaseSingular()} build() {
            return new ${tableName.upperCamelCaseSingular()}(
                <#list columns as column>
                this.${column.name().lowerCamelCase()}<#if column_has_next>,</#if>
                </#list>
            );
        }
    }

    public static Builder builder() {
        return new Builder(
            <#list columns as column>
            null<#if column_has_next>,</#if>
            </#list>
        );
    }

    public Builder editor() {
        return new Builder(
            <#list columns as column>
            this.${column.name().lowerCamelCase()}<#if column_has_next>,</#if>
            </#list>
        );
    }
}
