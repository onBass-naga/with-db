package ${packageName};

import org.example.generated.assertion.records.${table.upperCamelCaseSingularName()}Entity;
import org.example.generated.setup.model.${table.upperCamelCaseSingularName()};

import java.util.Objects;
import java.util.function.Predicate;
<#list importStatements as importStatement>
${importStatement}
</#list>

public class ${table.upperCamelCaseSingularName()}Predicates {

    public static class Editor {
        <#list columns as column>
        private Predicate<${table.upperCamelCaseSingularName()}Entity> ${column.lowerCamelCaseName()};
        </#list>

        public Editor(final ${table.upperCamelCaseSingularName()} ${table.upperCamelCaseSingularName()}) {
            <#list columns as column>
            this.${column.lowerCamelCaseName()} = (entity) -> Objects.equals(entity.${column.lowerCamelCaseName()}(), ${table.upperCamelCaseSingularName()}.${column.lowerCamelCaseName()}());
            </#list>
        }

        <#list columns as column>
        public Editor ${column.lowerCamelCaseName()}(final Predicate<${column.className()}> predicate) {
            this.${column.lowerCamelCaseName()} = ${table.upperCamelCaseSingularName()}Predicates.${column.lowerCamelCaseName()}(predicate);
            return this;
        }

        </#list>

        public Predicate<${table.upperCamelCaseSingularName()}Entity> edit() {
            <#list columns as column>
            <#if column_index == 0>return ${column.lowerCamelCaseName()}<#else>    .and(${column.lowerCamelCaseName()})<#if column_has_next><#else>;</#if></#if>
            </#list>
        }
    }

    public static Editor editorOf(final ${table.upperCamelCaseSingularName()} ${table.upperCamelCaseSingularName()}) {
        return new Editor(${table.upperCamelCaseSingularName()});
    }

    public static Predicate<${table.upperCamelCaseSingularName()}Entity> of(final ${table.upperCamelCaseSingularName()} ${table.upperCamelCaseSingularName()}) {
        return new Editor(${table.upperCamelCaseSingularName()}).edit();
    }

    <#list columns as column>
    public static Predicate<${table.upperCamelCaseSingularName()}Entity> ${column.lowerCamelCaseName()}(final Predicate<${column.className()}> predicate) {
        return (entity) -> predicate.test(entity.${column.lowerCamelCaseName()}());
    }

    public static Predicate<${table.upperCamelCaseSingularName()}Entity> ${column.lowerCamelCaseName()}(final ${column.className()} ${column.lowerCamelCaseName()}) {
        return (entity) -> Objects.equals(entity.${column.lowerCamelCaseName()}(), ${column.lowerCamelCaseName()});
    }

    <#if column.isTimeModule()>
    public static Predicate<${table.upperCamelCaseSingularName()}Entity> ${column.lowerCamelCaseName()}(final String ${column.lowerCamelCaseName()}) {
        return (entity) -> Objects.equals(entity.${column.lowerCamelCaseName()}(), ${column.className()}.parse(${column.lowerCamelCaseName()}));
    }

    </#if>
    <#if column.className() == "Long">
    public static Predicate<${table.upperCamelCaseSingularName()}Entity> ${column.lowerCamelCaseName()}(final int ${column.lowerCamelCaseName()}) {
        return (entity) -> entity.${column.lowerCamelCaseName()}() == (long) ${column.lowerCamelCaseName()};
    }

    </#if>
    <#if column.className() == "Short">
    public static Predicate<${table.upperCamelCaseSingularName()}Entity> ${column.lowerCamelCaseName()}(final int ${column.lowerCamelCaseName()}) {
        if (${column.lowerCamelCaseName()} > Short.MAX_VALUE || ${column.lowerCamelCaseName()} < Short.MIN_VALUE) {
            throw new IllegalArgumentException("out of range: " + ${column.lowerCamelCaseName()});
        }
        return (entity) -> entity.${column.lowerCamelCaseName()}() == (short) ${column.lowerCamelCaseName()};
    }

    </#if>
    <#if column.className() == "BigDecimal">
    public static Predicate<${table.upperCamelCaseSingularName()}Entity> ${column.lowerCamelCaseName()}(final int ${column.lowerCamelCaseName()}) {
        return (entity) -> Objects.equals(entity.${column.lowerCamelCaseName()}(), BigDecimal.valueOf(${column.lowerCamelCaseName()}));
    }

    public static Predicate<${table.upperCamelCaseSingularName()}Entity> ${column.lowerCamelCaseName()}(final long ${column.lowerCamelCaseName()}) {
        return (entity) -> Objects.equals(entity.${column.lowerCamelCaseName()}(), BigDecimal.valueOf(${column.lowerCamelCaseName()}));
    }

    public static Predicate<${table.upperCamelCaseSingularName()}Entity> ${column.lowerCamelCaseName()}(final double ${column.lowerCamelCaseName()}) {
        return (entity) -> Objects.equals(entity.${column.lowerCamelCaseName()}(), BigDecimal.valueOf(${column.lowerCamelCaseName()}));
    }

    </#if>
    </#list>
}

