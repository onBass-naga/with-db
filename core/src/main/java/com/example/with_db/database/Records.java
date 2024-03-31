package com.example.with_db.database;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public record Records<T> (List<T> values) {

    public Records<T> filter(final Predicate<T> predicate) {
        return filter(List.of(predicate));
    }

    public Records<T> filter(final Predicate<T>... predicates) {
        return filter(List.of(predicates));
    }

    public Records<T> filter(final List<Predicate<T>> predicates) {
        return this; //TODO
    }

    public int count() {
        return this.values.size(); // TODO
    }

    public List<T> list() {
        return this.values; // TODO
    }

    public T one() {
        return this.values.get(0); // TODO
    }

    public Optional<T> optional() {
        return Optional.ofNullable(this.values.get(0)); //TODO
    }

    public boolean exists() {
        return true; //TODO
    }

    public boolean notExist() {
        return true; //TODO
    }

}

