package com.example.with_db.assertion;

import java.util.Map;

public record Row(Map<String, Object> values) {
    public Object valueOf(final String columnName) {
        if (!values.containsKey(columnName)) {
            throw new IllegalArgumentException("%s not found.".formatted(columnName));
        }

        return values.get(columnName);
    }
}
