package com.example.with_db.generator;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum DataType {
    STRING(String.class, "String", List.of(Types.VARCHAR, Types.NVARCHAR, Types.CHAR, Types.NCHAR, Types.LONGVARCHAR, Types.LONGNVARCHAR, Types.SQLXML)),
    SHORT(Short.class, "Short", List.of(Types.TINYINT)),
    INTEGER(Integer.class, "Integer", List.of(Types.INTEGER)),
    LONG(Long.class, "Long", List.of(Types.BIGINT)),
    DOUBLE(Double.class, "Double", List.of(Types.DOUBLE)),
    FLOAT(Float.class, "Float", List.of(Types.FLOAT)),
    BIG_DECIMAL(BigDecimal.class, "BigDecimal", List.of(Types.NUMERIC, Types.DECIMAL)),
    BOOLEAN(Boolean.class, "Boolean", List.of(Types.BIT, Types.BOOLEAN)),
    BYTE_ARRAY(null, "byte[]", List.of(Types.SMALLINT)),
    DATE(Date.class, "Date", List.of(Types.DATE)),
    TIME(Time.class, "Time", List.of(Types.TIME, Types.TIME_WITH_TIMEZONE)),
    TIMESTAMP(Timestamp.class, "Timestamp", List.of(Types.TIMESTAMP, Types.TIMESTAMP_WITH_TIMEZONE));

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
                .orElseThrow(() -> new IllegalArgumentException("%s is not defined.".formatted(sqlDataType)));
    }

    public Optional<String> getFullyQualifiedClassNameOpt() {
        return Optional.ofNullable(clazz).map(Class::getName);
    }

    public String getClassName() {
        return javaClassName;
    }
}
