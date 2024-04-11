package com.example.with_db.utils;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;
import java.util.function.Supplier;

public class ResultSetUtils {
    public static String getString(final ResultSet resultSet, final String columnName) {
        try {
            return resultSet.getString(columnName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Boolean getBoolean(final ResultSet resultSet, final String columnName) {
        try {
            return resultSet.getBoolean(columnName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Long getLong(final ResultSet resultSet, final String columnName) {
        try {
            return resultSet.getLong(columnName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Integer getInt(final ResultSet resultSet, final String columnName) {
        try {
            return resultSet.getInt(columnName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Short getShort(final ResultSet resultSet, final String columnName) {
        try {
            return resultSet.getShort(columnName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static BigDecimal getBigDecimal(final ResultSet resultSet, final String columnName) {
        try {
            return resultSet.getBigDecimal(columnName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
