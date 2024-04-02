package com.example.with_db.assertion;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public record Records(List<Map<String, Object>> values) {
    public int count() {
        return values().size();
    }

    public boolean notExist() {
        return values().isEmpty();
    }

    public Records filter(final Predicate<? super Map<String, Object>> predicate) {
        return new Records(values.stream().filter(predicate).toList());
    }
}
