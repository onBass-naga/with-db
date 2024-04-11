package org.example.generated.assertion.records;

import java.math.BigDecimal;
import java.sql.*;

public record DataTypeEntity(
        Boolean boolColumn,
        Boolean bitColumn,
        Long int8Column,
        Long bigserialColumn,
        Long oidColumn,
        byte[] byteaColumn,
        String charColumn,
        String bpcharColumn,
        BigDecimal numericColumn,
        Integer int4Column,
        Integer serialColumn,
        Short int2Column,
        Short smallserialColumn,
        Float float4Column,
        Double float8Column,
        Double moneyColumn,
        String nameColumn,
        String textColumn,
        String varcharColumn,
        Date dateColumn,
        Time timeColumn,
        Time timetzColumn,
        Timestamp timestampColumn,
        Timestamp timestamptzColumn,
        String xmlColumn) {
    public static DataTypeEntity of(final ResultSet resultSet) {
        try {
            return new DataTypeEntity(
                    resultSet.getBoolean("bool_column"),
                    resultSet.getBoolean("bit_column"),
                    resultSet.getLong("int8_column"),
                    resultSet.getLong("bigserial_column"),
                    resultSet.getLong("oid_column"),
                    resultSet.getBytes("bytea_column"),
                    resultSet.getString("char_column"),
                    resultSet.getString("bpchar_column"),
                    resultSet.getBigDecimal("numeric_column"),
                    resultSet.getInt("int4_column"),
                    resultSet.getInt("serial_column"),
                    resultSet.getShort("int2_column"),
                    resultSet.getShort("smallserial_column"),
                    resultSet.getFloat("float4_column"),
                    resultSet.getDouble("float8_column"),
                    resultSet.getDouble("money_column"),
                    resultSet.getString("name_column"),
                    resultSet.getString("text_column"),
                    resultSet.getString("varchar_column"),
                    resultSet.getDate("date_column"),
                    resultSet.getTime("time_column"),
                    resultSet.getTime("timetz_column"),
                    resultSet.getTimestamp("timestamp_column"),
                    resultSet.getTimestamp("timestamptz_column"),
                    resultSet.getString("xml_column")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

