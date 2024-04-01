package com.example.with_db;

import java.lang.reflect.Field;

public class ReflectionUtils {
    public static Object getFieldValue(final Field field, final Object object) {
        try {
            return field.get(object);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
