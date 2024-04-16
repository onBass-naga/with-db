package com.example.with_db.generator.model;

import java.math.BigDecimal;
import java.sql.Types;
import java.time.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum DataType {
    STRING(String.class, "String", List.of(Types.VARCHAR, Types.NVARCHAR, Types.CHAR, Types.NCHAR, Types.LONGVARCHAR, Types.LONGNVARCHAR, Types.SQLXML)),
    SHORT(Short.class, "Short", List.of(Types.TINYINT, Types.SMALLINT)),
    INTEGER(Integer.class, "Integer", List.of(Types.INTEGER)),
    LONG(Long.class, "Long", List.of(Types.BIGINT)),
    DOUBLE(Double.class, "Double", List.of(Types.DOUBLE)),
    FLOAT(Float.class, "Float", List.of(Types.FLOAT)),
    BIG_DECIMAL(BigDecimal.class, "BigDecimal", List.of(Types.NUMERIC, Types.DECIMAL)),
    BOOLEAN(Boolean.class, "Boolean", List.of(Types.BIT, Types.BOOLEAN)),
    BYTE_ARRAY(null, "byte[]", List.of(Types.BINARY)),
    DATE(LocalDate.class, "LocalDate", List.of(Types.DATE)),
    TIME(LocalTime.class, "LocalTime", List.of(Types.TIME)),
    TIMESTAMP(LocalDateTime.class, "LocalDateTime", List.of(Types.TIMESTAMP)),
    TIME_WITH_TIMEZONE(OffsetTime.class, "OffsetTime", List.of(Types.TIME_WITH_TIMEZONE)),
    TIMESTAMP_WITH_TIMEZONE(OffsetDateTime.class, "OffsetDateTime", List.of(Types.TIMESTAMP_WITH_TIMEZONE));

    private final Class<?> clazz;

    private final String javaClassName;
    private final List<Integer> sqlTypes;

    DataType(Class<?> clazz, String javaClassName, List<Integer> sqlTypes) {
        this.clazz = clazz;
        this.javaClassName = javaClassName;
        this.sqlTypes = sqlTypes;
    }

    public static DataType of(final int sqlDataType) {
        return Arrays.stream(values())
                .filter(dataType -> dataType.sqlTypes.contains(sqlDataType))
                .findAny()
                .orElse(DataType.STRING);
    }

    public Optional<String> getFullyQualifiedClassNameOpt() {
        return Optional.ofNullable(clazz).map(Class::getName);
    }

    public String getClassName() {
        return javaClassName;
    }
}
