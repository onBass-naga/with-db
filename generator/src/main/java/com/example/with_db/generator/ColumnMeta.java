package com.example.with_db.generator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public record ColumnMeta(
        ColumnName name,
        DataType dataType,
        String typeName,
        int decimalDigits,
        String columnDefault,
        boolean isAutoincrement,
        boolean isNullable
) {
    private static final List<String> YES_WORDS = List.of("YES", "Y");

    public static ColumnMeta of(final ResultSet resultSet) {
        try {
            // https://learn.microsoft.com/ja-jp/sql/connect/jdbc/reference/getcolumns-method-sqlserverdatabasemetadata?view=sql-server-ver16
            return new ColumnMeta(
                    new ColumnName(resultSet.getString("COLUMN_NAME")),
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

    public String className() {
        return dataType.getClassName();
    }

    public Optional<String> fullyQualifiedClassNameOpt() {
        return dataType.getFullyQualifiedClassNameOpt();
    }

    public boolean isRequired() {
        return !isNullable && Objects.isNull(columnDefault) && !isAutoincrement;
    }
}
