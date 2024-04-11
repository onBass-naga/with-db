package com.example.with_db.generator;

import org.modeshape.common.text.Inflector;

public record TableName(String value) {

    public String upperCamelCaseSingular() {
        final var inflector = Inflector.getInstance();
        return inflector.singularize(inflector.upperCamelCase(value.toLowerCase()));
    }

    public String upperCase() {
        return value.toUpperCase();
    }
}
