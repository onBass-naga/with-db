package org.example.generated.assertion.records;

import com.example.with_db.database.ResultSetWrapper;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Short;
import java.lang.String;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
        String float4Column,
        Double float8Column,
        Double moneyColumn,
        String nameColumn,
        String textColumn,
        String varcharColumn,
        LocalDate dateColumn,
        LocalTime timeColumn,
        LocalTime timetzColumn,
        LocalDateTime timestampColumn,
        LocalDateTime timestamptzColumn,
        String xmlColumn
) {

    public static DataTypeEntity of(final ResultSetWrapper resultSet) {
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
                resultSet.getInteger("int4_column"),
                resultSet.getInteger("serial_column"),
                resultSet.getShort("int2_column"),
                resultSet.getShort("smallserial_column"),
                resultSet.getString("float4_column"),
                resultSet.getDouble("float8_column"),
                resultSet.getDouble("money_column"),
                resultSet.getString("name_column"),
                resultSet.getString("text_column"),
                resultSet.getString("varchar_column"),
                resultSet.getLocalDate("date_column"),
                resultSet.getLocalTime("time_column"),
                resultSet.getLocalTime("timetz_column"),
                resultSet.getLocalDateTime("timestamp_column"),
                resultSet.getLocalDateTime("timestamptz_column"),
                resultSet.getString("xml_column")
        );
    }
}
