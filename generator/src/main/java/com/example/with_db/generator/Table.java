package com.example.with_db.generator;

import org.modeshape.common.text.Inflector;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public record Table(String name, List<Column> columns) {

    public String upperCamelCaseSingularName() {
        final var inflector = Inflector.getInstance();
        return inflector.singularize(inflector.upperCamelCase(name.toLowerCase()));
    }

    public String lowerCamelCaseSingularName() {
        final var inflector = Inflector.getInstance();
        return inflector.singularize(inflector.lowerCamelCase(name.toLowerCase()));
    }

    public String lowerCamelCaseName() {
        final var inflector = Inflector.getInstance();
        return inflector.lowerCamelCase(name.toLowerCase());
    }

    public String upperCaseName() {
        return name.toUpperCase();
    }

    public Object requiredColumns() {
        return columns.stream().filter(Column::isRequired).toList();
    }

    public Set<String> usingDataTypes() {
        final var importStatements = columns.stream()
                .map(Column::fullyQualifiedClassNameOpt)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toUnmodifiableSet());
        return new TreeSet<>(importStatements);
    }
}
