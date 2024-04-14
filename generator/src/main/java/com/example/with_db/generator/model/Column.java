package com.example.with_db.generator.model;

import com.example.with_db.generator.utils.Inflector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public record Column(
        String name,
        DataType dataType,
        String typeName,
        int decimalDigits,
        String columnDefault,
        boolean isAutoincrement,
        boolean isNullable
) {
    private static final List<String> YES_WORDS = List.of("YES", "Y");

    public static Column of(final ResultSet resultSet) {
        try {
            // https://learn.microsoft.com/ja-jp/sql/connect/jdbc/reference/getcolumns-method-sqlserverdatabasemetadata?view=sql-server-ver16
            return new Column(
                    resultSet.getString("COLUMN_NAME"),
                    DataType.of(resultSet.getInt("DATA_TYPE")),
                    resultSet.getString("TYPE_NAME"),
                    resultSet.getInt("DECIMAL_DIGITS"),
                    resultSet.getString("COLUMN_DEF"),
                    YES_WORDS.contains(resultSet.getString("IS_AUTOINCREMENT")),
                    YES_WORDS.contains(resultSet.getString("IS_NULLABLE"))
            );
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String upperCamelCaseName() {
        final var inflector = Inflector.getInstance();
        return inflector.upperCamelCase(name.toLowerCase());
    }

    public String lowerCamelCaseName() {
        final var inflector = Inflector.getInstance();
        return inflector.lowerCamelCase(name.toLowerCase());
    }

    public String className() {
        return dataType.getClassName();
    }

    public String getter() {
        return switch (dataType) {
            case DataType.BYTE_ARRAY -> "getBytes";
            case DataType.INTEGER -> "getInt";
            default -> "get%s".formatted(dataType.getClassName());
        };
    }

    public Optional<String> fullyQualifiedClassNameOpt() {
        return dataType.getFullyQualifiedClassNameOpt();
    }

    public boolean isRequired() {
        return !isNullable && Objects.isNull(columnDefault) && !isAutoincrement;
    }

    public String requiredText() {
        return String.valueOf(isRequired());
    }
}
