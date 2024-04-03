package com.example.with_db.assertion.predicates;

import java.util.Objects;
import java.util.function.Predicate;

public class CommonPredicates {

    public static <T> Predicate<T> isNull() {
        return Objects::isNull;
    }

    public static <T> Predicate<T> nonNull() {
        return Objects::nonNull;
    }

    public static <T> Predicate<T> any() {
        return value -> true;
    }
}
