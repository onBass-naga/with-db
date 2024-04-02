package com.example.with_db.assertion;

import java.util.List;
import java.util.function.Predicate;

public record Records(List<Row> rows) {
    public int count() {
        return rows.size();
    }

    public boolean notExist() {
        return rows.isEmpty();
    }

    public Records filter(final Predicate<? super Row> predicate) {
        return new Records(rows.stream().filter(predicate).toList());
    }
}
