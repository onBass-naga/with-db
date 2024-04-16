package org.example.generated.setup.model;

import com.example.with_db.database.column.ColumnName;
import com.example.with_db.database.SetupModel;
import org.example.generated.tables.Tables;

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

public record DataType(
        @ColumnName("bool_column") Boolean boolColumn,
        @ColumnName("bit_column") Boolean bitColumn,
        @ColumnName("int8_column") Long int8Column,
        @ColumnName("bigserial_column") Long bigserialColumn,
        @ColumnName("oid_column") Long oidColumn,
        @ColumnName("bytea_column") byte[] byteaColumn,
        @ColumnName("char_column") String charColumn,
        @ColumnName("bpchar_column") String bpcharColumn,
        @ColumnName("numeric_column") BigDecimal numericColumn,
        @ColumnName("int4_column") Integer int4Column,
        @ColumnName("serial_column") Integer serialColumn,
        @ColumnName("int2_column") Short int2Column,
        @ColumnName("smallserial_column") Short smallserialColumn,
        @ColumnName("float4_column") String float4Column,
        @ColumnName("float8_column") Double float8Column,
        @ColumnName("money_column") Double moneyColumn,
        @ColumnName("name_column") String nameColumn,
        @ColumnName("text_column") String textColumn,
        @ColumnName("varchar_column") String varcharColumn,
        @ColumnName("date_column") LocalDate dateColumn,
        @ColumnName("time_column") LocalTime timeColumn,
        @ColumnName("timetz_column") LocalTime timetzColumn,
        @ColumnName("timestamp_column") LocalDateTime timestampColumn,
        @ColumnName("timestamptz_column") LocalDateTime timestamptzColumn,
        @ColumnName("xml_column") String xmlColumn
    ) implements SetupModel {

    @Override
    public Tables tableMeta() {
        return Tables.DATA_TYPES;
    }

    public static class Builder {
        private Boolean boolColumn;
        private Boolean bitColumn;
        private Long int8Column;
        private Long bigserialColumn;
        private Long oidColumn;
        private byte[] byteaColumn;
        private String charColumn;
        private String bpcharColumn;
        private BigDecimal numericColumn;
        private Integer int4Column;
        private Integer serialColumn;
        private Short int2Column;
        private Short smallserialColumn;
        private String float4Column;
        private Double float8Column;
        private Double moneyColumn;
        private String nameColumn;
        private String textColumn;
        private String varcharColumn;
        private LocalDate dateColumn;
        private LocalTime timeColumn;
        private LocalTime timetzColumn;
        private LocalDateTime timestampColumn;
        private LocalDateTime timestamptzColumn;
        private String xmlColumn;

        public Builder(
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
            this.boolColumn = boolColumn;
            this.bitColumn = bitColumn;
            this.int8Column = int8Column;
            this.bigserialColumn = bigserialColumn;
            this.oidColumn = oidColumn;
            this.byteaColumn = byteaColumn;
            this.charColumn = charColumn;
            this.bpcharColumn = bpcharColumn;
            this.numericColumn = numericColumn;
            this.int4Column = int4Column;
            this.serialColumn = serialColumn;
            this.int2Column = int2Column;
            this.smallserialColumn = smallserialColumn;
            this.float4Column = float4Column;
            this.float8Column = float8Column;
            this.moneyColumn = moneyColumn;
            this.nameColumn = nameColumn;
            this.textColumn = textColumn;
            this.varcharColumn = varcharColumn;
            this.dateColumn = dateColumn;
            this.timeColumn = timeColumn;
            this.timetzColumn = timetzColumn;
            this.timestampColumn = timestampColumn;
            this.timestamptzColumn = timestamptzColumn;
            this.xmlColumn = xmlColumn;
        }

        public Builder boolColumn(final Boolean boolColumn) {
            this.boolColumn = boolColumn;
            return this;
        }

        public Builder bitColumn(final Boolean bitColumn) {
            this.bitColumn = bitColumn;
            return this;
        }

        public Builder int8Column(final Long int8Column) {
            this.int8Column = int8Column;
            return this;
        }

        public Builder bigserialColumn(final Long bigserialColumn) {
            this.bigserialColumn = bigserialColumn;
            return this;
        }

        public Builder oidColumn(final Long oidColumn) {
            this.oidColumn = oidColumn;
            return this;
        }

        public Builder byteaColumn(final byte[] byteaColumn) {
            this.byteaColumn = byteaColumn;
            return this;
        }

        public Builder charColumn(final String charColumn) {
            this.charColumn = charColumn;
            return this;
        }

        public Builder bpcharColumn(final String bpcharColumn) {
            this.bpcharColumn = bpcharColumn;
            return this;
        }

        public Builder numericColumn(final BigDecimal numericColumn) {
            this.numericColumn = numericColumn;
            return this;
        }

        public Builder int4Column(final Integer int4Column) {
            this.int4Column = int4Column;
            return this;
        }

        public Builder serialColumn(final Integer serialColumn) {
            this.serialColumn = serialColumn;
            return this;
        }

        public Builder int2Column(final Short int2Column) {
            this.int2Column = int2Column;
            return this;
        }

        public Builder smallserialColumn(final Short smallserialColumn) {
            this.smallserialColumn = smallserialColumn;
            return this;
        }

        public Builder float4Column(final String float4Column) {
            this.float4Column = float4Column;
            return this;
        }

        public Builder float8Column(final Double float8Column) {
            this.float8Column = float8Column;
            return this;
        }

        public Builder moneyColumn(final Double moneyColumn) {
            this.moneyColumn = moneyColumn;
            return this;
        }

        public Builder nameColumn(final String nameColumn) {
            this.nameColumn = nameColumn;
            return this;
        }

        public Builder textColumn(final String textColumn) {
            this.textColumn = textColumn;
            return this;
        }

        public Builder varcharColumn(final String varcharColumn) {
            this.varcharColumn = varcharColumn;
            return this;
        }

        public Builder dateColumn(final LocalDate dateColumn) {
            this.dateColumn = dateColumn;
            return this;
        }

        public Builder timeColumn(final LocalTime timeColumn) {
            this.timeColumn = timeColumn;
            return this;
        }

        public Builder timetzColumn(final LocalTime timetzColumn) {
            this.timetzColumn = timetzColumn;
            return this;
        }

        public Builder timestampColumn(final LocalDateTime timestampColumn) {
            this.timestampColumn = timestampColumn;
            return this;
        }

        public Builder timestamptzColumn(final LocalDateTime timestamptzColumn) {
            this.timestamptzColumn = timestamptzColumn;
            return this;
        }

        public Builder xmlColumn(final String xmlColumn) {
            this.xmlColumn = xmlColumn;
            return this;
        }


        public DataType build() {
            return new DataType(
                this.boolColumn,
                this.bitColumn,
                this.int8Column,
                this.bigserialColumn,
                this.oidColumn,
                this.byteaColumn,
                this.charColumn,
                this.bpcharColumn,
                this.numericColumn,
                this.int4Column,
                this.serialColumn,
                this.int2Column,
                this.smallserialColumn,
                this.float4Column,
                this.float8Column,
                this.moneyColumn,
                this.nameColumn,
                this.textColumn,
                this.varcharColumn,
                this.dateColumn,
                this.timeColumn,
                this.timetzColumn,
                this.timestampColumn,
                this.timestamptzColumn,
                this.xmlColumn
            );
        }
    }

    public static Builder builder() {
        return new Builder(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        );
    }

    public Builder editor() {
        return new Builder(
            this.boolColumn,
            this.bitColumn,
            this.int8Column,
            this.bigserialColumn,
            this.oidColumn,
            this.byteaColumn,
            this.charColumn,
            this.bpcharColumn,
            this.numericColumn,
            this.int4Column,
            this.serialColumn,
            this.int2Column,
            this.smallserialColumn,
            this.float4Column,
            this.float8Column,
            this.moneyColumn,
            this.nameColumn,
            this.textColumn,
            this.varcharColumn,
            this.dateColumn,
            this.timeColumn,
            this.timetzColumn,
            this.timestampColumn,
            this.timestamptzColumn,
            this.xmlColumn
        );
    }
}
