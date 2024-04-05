package com.example.with_db.database;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public abstract class Records<E, R> {

    protected List<E> values;

    abstract protected Class<R> getRecordsClass();

    public R filter(final Predicate<E> predicate) {
        try {
            Constructor<R> constructor = getRecordsClass().getConstructor(List.class);
            return constructor.newInstance(values.stream().filter(predicate).toList());
        } catch (final InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public int count() {
        return this.values.size();
    }

    public List<E> list() {
        return this.values;
    }

    public E one() {
        if (values.size() != 1) {
            throw new IllegalStateException("values size: %s".formatted(values.size()));
        }
        return this.values.getFirst();
    }

    public Optional<E> optional() {
        if (values.size() > 1) {
            throw new IllegalStateException("values size: %s".formatted(values.size()));
        }

        return values.isEmpty() ? Optional.empty() : Optional.of(this.values.getFirst());
    }

    public boolean notExist() {
        return values.isEmpty();
    }

}

