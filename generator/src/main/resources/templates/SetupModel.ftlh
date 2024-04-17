package ${packageName};

import com.example.with_db.database.column.ColumnName;
import com.example.with_db.database.SetupModel;
import org.example.generated.tables.Tables;

<#list importStatements as importStatement>
${importStatement}
</#list>

public record ${table.upperCamelCaseSingularName()}(
        <#list columns as column>
        @ColumnName("${column.name()}") ${column.className()} ${column.lowerCamelCaseName()}<#if column_has_next>,</#if>
        </#list>
    ) implements SetupModel {

    @Override
    public Tables tableMeta() {
        return Tables.${table.upperCaseName()};
    }

    public static class Builder {
        <#list columns as column>
        private ${column.className()} ${column.lowerCamelCaseName()};
        </#list>

        public Builder(
                <#list columns as column>
                ${column.className()} ${column.lowerCamelCaseName()}<#if column_has_next>,</#if>
                </#list>
        ) {
            <#list columns as column>
            this.${column.lowerCamelCaseName()} = ${column.lowerCamelCaseName()};
            </#list>
        }

        <#list columns as column>
        public Builder ${column.lowerCamelCaseName()}(final ${column.className()} ${column.lowerCamelCaseName()}) {
            this.${column.lowerCamelCaseName()} = ${column.lowerCamelCaseName()};
            return this;
        }

        <#if !column.isRequired()>
        public Builder ${column.lowerCamelCaseName()}Null() {
            this.${column.lowerCamelCaseName()} = null;
            return this;
        }

        </#if>
        <#if column.isTimeModule()>
        public Builder ${column.lowerCamelCaseName()}(final String ${column.lowerCamelCaseName()}) {
            this.${column.lowerCamelCaseName()} = ${column.className()}.parse(${column.lowerCamelCaseName()});
            return this;
        }

        </#if>
        <#if column.className() == "Long">
        public Builder ${column.lowerCamelCaseName()}(final int ${column.lowerCamelCaseName()}) {
            this.${column.lowerCamelCaseName()} = (long) ${column.lowerCamelCaseName()};
            return this;
        }

        </#if>
        <#if column.className() == "Short">
        public Builder ${column.lowerCamelCaseName()}(final int ${column.lowerCamelCaseName()}) {
            if (${column.lowerCamelCaseName()} > Short.MAX_VALUE || ${column.lowerCamelCaseName()} < Short.MIN_VALUE) {
                throw new IllegalArgumentException("out of range: " + ${column.lowerCamelCaseName()});
            }
            this.${column.lowerCamelCaseName()} = (short) ${column.lowerCamelCaseName()};
            return this;
        }

        </#if>
        <#if column.className() == "BigDecimal">
        public Builder ${column.lowerCamelCaseName()}(final int ${column.lowerCamelCaseName()}) {
            this.${column.lowerCamelCaseName()} = BigDecimal.valueOf(${column.lowerCamelCaseName()});
            return this;
        }

        public Builder ${column.lowerCamelCaseName()}(final long ${column.lowerCamelCaseName()}) {
            this.${column.lowerCamelCaseName()} = BigDecimal.valueOf(${column.lowerCamelCaseName()});
            return this;
        }

        public Builder ${column.lowerCamelCaseName()}(final double ${column.lowerCamelCaseName()}) {
            this.${column.lowerCamelCaseName()} = BigDecimal.valueOf(${column.lowerCamelCaseName()});
            return this;
        }

        </#if>
        </#list>

        public ${table.upperCamelCaseSingularName()} build() {
            return new ${table.upperCamelCaseSingularName()}(
                <#list columns as column>
                this.${column.lowerCamelCaseName()}<#if column_has_next>,</#if>
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
            this.${column.lowerCamelCaseName()}<#if column_has_next>,</#if>
            </#list>
        );
    }
}
