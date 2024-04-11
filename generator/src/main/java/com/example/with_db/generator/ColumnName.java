package com.example.with_db.generator;

import org.modeshape.common.text.Inflector;

public record ColumnName(String value) {

    public String upperCamelCase() {
        if (value == null) {
            return null;
        }

        final var inflector = Inflector.getInstance();
        return inflector.upperCamelCase(value.toLowerCase());
    }

    public String lowerCamelCase() {
        if (value == null) {
            return null;
        }

        final var inflector = Inflector.getInstance();
        return inflector.lowerCamelCase(value.toLowerCase());
    }
}
