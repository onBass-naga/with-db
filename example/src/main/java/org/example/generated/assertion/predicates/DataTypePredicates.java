package org.example.generated.assertion.predicates;

import org.example.generated.assertion.records.DataTypeEntity;
import org.example.generated.setup.model.DataType;

import java.util.Objects;
import java.util.function.Predicate;
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

public class DataTypePredicates {

    public static class Editor {
        private Predicate<DataTypeEntity> boolColumn;
        private Predicate<DataTypeEntity> bitColumn;
        private Predicate<DataTypeEntity> int8Column;
        private Predicate<DataTypeEntity> bigserialColumn;
        private Predicate<DataTypeEntity> oidColumn;
        private Predicate<DataTypeEntity> byteaColumn;
        private Predicate<DataTypeEntity> charColumn;
        private Predicate<DataTypeEntity> bpcharColumn;
        private Predicate<DataTypeEntity> numericColumn;
        private Predicate<DataTypeEntity> int4Column;
        private Predicate<DataTypeEntity> serialColumn;
        private Predicate<DataTypeEntity> int2Column;
        private Predicate<DataTypeEntity> smallserialColumn;
        private Predicate<DataTypeEntity> float4Column;
        private Predicate<DataTypeEntity> float8Column;
        private Predicate<DataTypeEntity> moneyColumn;
        private Predicate<DataTypeEntity> nameColumn;
        private Predicate<DataTypeEntity> textColumn;
        private Predicate<DataTypeEntity> varcharColumn;
        private Predicate<DataTypeEntity> dateColumn;
        private Predicate<DataTypeEntity> timeColumn;
        private Predicate<DataTypeEntity> timetzColumn;
        private Predicate<DataTypeEntity> timestampColumn;
        private Predicate<DataTypeEntity> timestamptzColumn;
        private Predicate<DataTypeEntity> xmlColumn;

        public Editor(final DataType DataType) {
            this.boolColumn = (entity) -> Objects.equals(entity.boolColumn(), DataType.boolColumn());
            this.bitColumn = (entity) -> Objects.equals(entity.bitColumn(), DataType.bitColumn());
            this.int8Column = (entity) -> Objects.equals(entity.int8Column(), DataType.int8Column());
            this.bigserialColumn = (entity) -> Objects.equals(entity.bigserialColumn(), DataType.bigserialColumn());
            this.oidColumn = (entity) -> Objects.equals(entity.oidColumn(), DataType.oidColumn());
            this.byteaColumn = (entity) -> Objects.equals(entity.byteaColumn(), DataType.byteaColumn());
            this.charColumn = (entity) -> Objects.equals(entity.charColumn(), DataType.charColumn());
            this.bpcharColumn = (entity) -> Objects.equals(entity.bpcharColumn(), DataType.bpcharColumn());
            this.numericColumn = (entity) -> Objects.equals(entity.numericColumn(), DataType.numericColumn());
            this.int4Column = (entity) -> Objects.equals(entity.int4Column(), DataType.int4Column());
            this.serialColumn = (entity) -> Objects.equals(entity.serialColumn(), DataType.serialColumn());
            this.int2Column = (entity) -> Objects.equals(entity.int2Column(), DataType.int2Column());
            this.smallserialColumn = (entity) -> Objects.equals(entity.smallserialColumn(), DataType.smallserialColumn());
            this.float4Column = (entity) -> Objects.equals(entity.float4Column(), DataType.float4Column());
            this.float8Column = (entity) -> Objects.equals(entity.float8Column(), DataType.float8Column());
            this.moneyColumn = (entity) -> Objects.equals(entity.moneyColumn(), DataType.moneyColumn());
            this.nameColumn = (entity) -> Objects.equals(entity.nameColumn(), DataType.nameColumn());
            this.textColumn = (entity) -> Objects.equals(entity.textColumn(), DataType.textColumn());
            this.varcharColumn = (entity) -> Objects.equals(entity.varcharColumn(), DataType.varcharColumn());
            this.dateColumn = (entity) -> Objects.equals(entity.dateColumn(), DataType.dateColumn());
            this.timeColumn = (entity) -> Objects.equals(entity.timeColumn(), DataType.timeColumn());
            this.timetzColumn = (entity) -> Objects.equals(entity.timetzColumn(), DataType.timetzColumn());
            this.timestampColumn = (entity) -> Objects.equals(entity.timestampColumn(), DataType.timestampColumn());
            this.timestamptzColumn = (entity) -> Objects.equals(entity.timestamptzColumn(), DataType.timestamptzColumn());
            this.xmlColumn = (entity) -> Objects.equals(entity.xmlColumn(), DataType.xmlColumn());
        }

        public Editor boolColumn(final Predicate<Boolean> predicate) {
            this.boolColumn = DataTypePredicates.boolColumn(predicate);
            return this;
        }

        public Editor bitColumn(final Predicate<Boolean> predicate) {
            this.bitColumn = DataTypePredicates.bitColumn(predicate);
            return this;
        }

        public Editor int8Column(final Predicate<Long> predicate) {
            this.int8Column = DataTypePredicates.int8Column(predicate);
            return this;
        }

        public Editor bigserialColumn(final Predicate<Long> predicate) {
            this.bigserialColumn = DataTypePredicates.bigserialColumn(predicate);
            return this;
        }

        public Editor oidColumn(final Predicate<Long> predicate) {
            this.oidColumn = DataTypePredicates.oidColumn(predicate);
            return this;
        }

        public Editor byteaColumn(final Predicate<byte[]> predicate) {
            this.byteaColumn = DataTypePredicates.byteaColumn(predicate);
            return this;
        }

        public Editor charColumn(final Predicate<String> predicate) {
            this.charColumn = DataTypePredicates.charColumn(predicate);
            return this;
        }

        public Editor bpcharColumn(final Predicate<String> predicate) {
            this.bpcharColumn = DataTypePredicates.bpcharColumn(predicate);
            return this;
        }

        public Editor numericColumn(final Predicate<BigDecimal> predicate) {
            this.numericColumn = DataTypePredicates.numericColumn(predicate);
            return this;
        }

        public Editor int4Column(final Predicate<Integer> predicate) {
            this.int4Column = DataTypePredicates.int4Column(predicate);
            return this;
        }

        public Editor serialColumn(final Predicate<Integer> predicate) {
            this.serialColumn = DataTypePredicates.serialColumn(predicate);
            return this;
        }

        public Editor int2Column(final Predicate<Short> predicate) {
            this.int2Column = DataTypePredicates.int2Column(predicate);
            return this;
        }

        public Editor smallserialColumn(final Predicate<Short> predicate) {
            this.smallserialColumn = DataTypePredicates.smallserialColumn(predicate);
            return this;
        }

        public Editor float4Column(final Predicate<String> predicate) {
            this.float4Column = DataTypePredicates.float4Column(predicate);
            return this;
        }

        public Editor float8Column(final Predicate<Double> predicate) {
            this.float8Column = DataTypePredicates.float8Column(predicate);
            return this;
        }

        public Editor moneyColumn(final Predicate<Double> predicate) {
            this.moneyColumn = DataTypePredicates.moneyColumn(predicate);
            return this;
        }

        public Editor nameColumn(final Predicate<String> predicate) {
            this.nameColumn = DataTypePredicates.nameColumn(predicate);
            return this;
        }

        public Editor textColumn(final Predicate<String> predicate) {
            this.textColumn = DataTypePredicates.textColumn(predicate);
            return this;
        }

        public Editor varcharColumn(final Predicate<String> predicate) {
            this.varcharColumn = DataTypePredicates.varcharColumn(predicate);
            return this;
        }

        public Editor dateColumn(final Predicate<LocalDate> predicate) {
            this.dateColumn = DataTypePredicates.dateColumn(predicate);
            return this;
        }

        public Editor timeColumn(final Predicate<LocalTime> predicate) {
            this.timeColumn = DataTypePredicates.timeColumn(predicate);
            return this;
        }

        public Editor timetzColumn(final Predicate<LocalTime> predicate) {
            this.timetzColumn = DataTypePredicates.timetzColumn(predicate);
            return this;
        }

        public Editor timestampColumn(final Predicate<LocalDateTime> predicate) {
            this.timestampColumn = DataTypePredicates.timestampColumn(predicate);
            return this;
        }

        public Editor timestamptzColumn(final Predicate<LocalDateTime> predicate) {
            this.timestamptzColumn = DataTypePredicates.timestamptzColumn(predicate);
            return this;
        }

        public Editor xmlColumn(final Predicate<String> predicate) {
            this.xmlColumn = DataTypePredicates.xmlColumn(predicate);
            return this;
        }


        public Predicate<DataTypeEntity> edit() {
            return boolColumn
                .and(bitColumn)
                .and(int8Column)
                .and(bigserialColumn)
                .and(oidColumn)
                .and(byteaColumn)
                .and(charColumn)
                .and(bpcharColumn)
                .and(numericColumn)
                .and(int4Column)
                .and(serialColumn)
                .and(int2Column)
                .and(smallserialColumn)
                .and(float4Column)
                .and(float8Column)
                .and(moneyColumn)
                .and(nameColumn)
                .and(textColumn)
                .and(varcharColumn)
                .and(dateColumn)
                .and(timeColumn)
                .and(timetzColumn)
                .and(timestampColumn)
                .and(timestamptzColumn)
                .and(xmlColumn);
        }
    }

    public static Editor editorOf(final DataType DataType) {
        return new Editor(DataType);
    }

    public static Predicate<DataTypeEntity> of(final DataType DataType) {
        return new Editor(DataType).edit();
    }

    public static Predicate<DataTypeEntity> boolColumn(final Predicate<Boolean> predicate) {
        return (entity) -> predicate.test(entity.boolColumn());
    }

    public static Predicate<DataTypeEntity> boolColumn(final Boolean boolColumn) {
        return (entity) -> Objects.equals(entity.boolColumn(), boolColumn);
    }

    public static Predicate<DataTypeEntity> bitColumn(final Predicate<Boolean> predicate) {
        return (entity) -> predicate.test(entity.bitColumn());
    }

    public static Predicate<DataTypeEntity> bitColumn(final Boolean bitColumn) {
        return (entity) -> Objects.equals(entity.bitColumn(), bitColumn);
    }

    public static Predicate<DataTypeEntity> int8Column(final Predicate<Long> predicate) {
        return (entity) -> predicate.test(entity.int8Column());
    }

    public static Predicate<DataTypeEntity> int8Column(final Long int8Column) {
        return (entity) -> Objects.equals(entity.int8Column(), int8Column);
    }

    public static Predicate<DataTypeEntity> int8Column(final int int8Column) {
        return (entity) -> entity.int8Column() == (long) int8Column;
    }

    public static Predicate<DataTypeEntity> bigserialColumn(final Predicate<Long> predicate) {
        return (entity) -> predicate.test(entity.bigserialColumn());
    }

    public static Predicate<DataTypeEntity> bigserialColumn(final Long bigserialColumn) {
        return (entity) -> Objects.equals(entity.bigserialColumn(), bigserialColumn);
    }

    public static Predicate<DataTypeEntity> bigserialColumn(final int bigserialColumn) {
        return (entity) -> entity.bigserialColumn() == (long) bigserialColumn;
    }

    public static Predicate<DataTypeEntity> oidColumn(final Predicate<Long> predicate) {
        return (entity) -> predicate.test(entity.oidColumn());
    }

    public static Predicate<DataTypeEntity> oidColumn(final Long oidColumn) {
        return (entity) -> Objects.equals(entity.oidColumn(), oidColumn);
    }

    public static Predicate<DataTypeEntity> oidColumn(final int oidColumn) {
        return (entity) -> entity.oidColumn() == (long) oidColumn;
    }

    public static Predicate<DataTypeEntity> byteaColumn(final Predicate<byte[]> predicate) {
        return (entity) -> predicate.test(entity.byteaColumn());
    }

    public static Predicate<DataTypeEntity> byteaColumn(final byte[] byteaColumn) {
        return (entity) -> Objects.equals(entity.byteaColumn(), byteaColumn);
    }

    public static Predicate<DataTypeEntity> charColumn(final Predicate<String> predicate) {
        return (entity) -> predicate.test(entity.charColumn());
    }

    public static Predicate<DataTypeEntity> charColumn(final String charColumn) {
        return (entity) -> Objects.equals(entity.charColumn(), charColumn);
    }

    public static Predicate<DataTypeEntity> bpcharColumn(final Predicate<String> predicate) {
        return (entity) -> predicate.test(entity.bpcharColumn());
    }

    public static Predicate<DataTypeEntity> bpcharColumn(final String bpcharColumn) {
        return (entity) -> Objects.equals(entity.bpcharColumn(), bpcharColumn);
    }

    public static Predicate<DataTypeEntity> numericColumn(final Predicate<BigDecimal> predicate) {
        return (entity) -> predicate.test(entity.numericColumn());
    }

    public static Predicate<DataTypeEntity> numericColumn(final BigDecimal numericColumn) {
        return (entity) -> Objects.equals(entity.numericColumn(), numericColumn);
    }

    public static Predicate<DataTypeEntity> numericColumn(final int numericColumn) {
        return (entity) -> Objects.equals(entity.numericColumn(), BigDecimal.valueOf(numericColumn));
    }

    public static Predicate<DataTypeEntity> numericColumn(final long numericColumn) {
        return (entity) -> Objects.equals(entity.numericColumn(), BigDecimal.valueOf(numericColumn));
    }

    public static Predicate<DataTypeEntity> numericColumn(final double numericColumn) {
        return (entity) -> Objects.equals(entity.numericColumn(), BigDecimal.valueOf(numericColumn));
    }

    public static Predicate<DataTypeEntity> int4Column(final Predicate<Integer> predicate) {
        return (entity) -> predicate.test(entity.int4Column());
    }

    public static Predicate<DataTypeEntity> int4Column(final Integer int4Column) {
        return (entity) -> Objects.equals(entity.int4Column(), int4Column);
    }

    public static Predicate<DataTypeEntity> serialColumn(final Predicate<Integer> predicate) {
        return (entity) -> predicate.test(entity.serialColumn());
    }

    public static Predicate<DataTypeEntity> serialColumn(final Integer serialColumn) {
        return (entity) -> Objects.equals(entity.serialColumn(), serialColumn);
    }

    public static Predicate<DataTypeEntity> int2Column(final Predicate<Short> predicate) {
        return (entity) -> predicate.test(entity.int2Column());
    }

    public static Predicate<DataTypeEntity> int2Column(final Short int2Column) {
        return (entity) -> Objects.equals(entity.int2Column(), int2Column);
    }

    public static Predicate<DataTypeEntity> int2Column(final int int2Column) {
        if (int2Column > Short.MAX_VALUE || int2Column < Short.MIN_VALUE) {
            throw new IllegalArgumentException("out of range: " + int2Column);
        }
        return (entity) -> entity.int2Column() == (short) int2Column;
    }

    public static Predicate<DataTypeEntity> smallserialColumn(final Predicate<Short> predicate) {
        return (entity) -> predicate.test(entity.smallserialColumn());
    }

    public static Predicate<DataTypeEntity> smallserialColumn(final Short smallserialColumn) {
        return (entity) -> Objects.equals(entity.smallserialColumn(), smallserialColumn);
    }

    public static Predicate<DataTypeEntity> smallserialColumn(final int smallserialColumn) {
        if (smallserialColumn > Short.MAX_VALUE || smallserialColumn < Short.MIN_VALUE) {
            throw new IllegalArgumentException("out of range: " + smallserialColumn);
        }
        return (entity) -> entity.smallserialColumn() == (short) smallserialColumn;
    }

    public static Predicate<DataTypeEntity> float4Column(final Predicate<String> predicate) {
        return (entity) -> predicate.test(entity.float4Column());
    }

    public static Predicate<DataTypeEntity> float4Column(final String float4Column) {
        return (entity) -> Objects.equals(entity.float4Column(), float4Column);
    }

    public static Predicate<DataTypeEntity> float8Column(final Predicate<Double> predicate) {
        return (entity) -> predicate.test(entity.float8Column());
    }

    public static Predicate<DataTypeEntity> float8Column(final Double float8Column) {
        return (entity) -> Objects.equals(entity.float8Column(), float8Column);
    }

    public static Predicate<DataTypeEntity> moneyColumn(final Predicate<Double> predicate) {
        return (entity) -> predicate.test(entity.moneyColumn());
    }

    public static Predicate<DataTypeEntity> moneyColumn(final Double moneyColumn) {
        return (entity) -> Objects.equals(entity.moneyColumn(), moneyColumn);
    }

    public static Predicate<DataTypeEntity> nameColumn(final Predicate<String> predicate) {
        return (entity) -> predicate.test(entity.nameColumn());
    }

    public static Predicate<DataTypeEntity> nameColumn(final String nameColumn) {
        return (entity) -> Objects.equals(entity.nameColumn(), nameColumn);
    }

    public static Predicate<DataTypeEntity> textColumn(final Predicate<String> predicate) {
        return (entity) -> predicate.test(entity.textColumn());
    }

    public static Predicate<DataTypeEntity> textColumn(final String textColumn) {
        return (entity) -> Objects.equals(entity.textColumn(), textColumn);
    }

    public static Predicate<DataTypeEntity> varcharColumn(final Predicate<String> predicate) {
        return (entity) -> predicate.test(entity.varcharColumn());
    }

    public static Predicate<DataTypeEntity> varcharColumn(final String varcharColumn) {
        return (entity) -> Objects.equals(entity.varcharColumn(), varcharColumn);
    }

    public static Predicate<DataTypeEntity> dateColumn(final Predicate<LocalDate> predicate) {
        return (entity) -> predicate.test(entity.dateColumn());
    }

    public static Predicate<DataTypeEntity> dateColumn(final LocalDate dateColumn) {
        return (entity) -> Objects.equals(entity.dateColumn(), dateColumn);
    }

    public static Predicate<DataTypeEntity> dateColumn(final String dateColumn) {
        return (entity) -> Objects.equals(entity.dateColumn(), LocalDate.parse(dateColumn));
    }

    public static Predicate<DataTypeEntity> timeColumn(final Predicate<LocalTime> predicate) {
        return (entity) -> predicate.test(entity.timeColumn());
    }

    public static Predicate<DataTypeEntity> timeColumn(final LocalTime timeColumn) {
        return (entity) -> Objects.equals(entity.timeColumn(), timeColumn);
    }

    public static Predicate<DataTypeEntity> timeColumn(final String timeColumn) {
        return (entity) -> Objects.equals(entity.timeColumn(), LocalTime.parse(timeColumn));
    }

    public static Predicate<DataTypeEntity> timetzColumn(final Predicate<LocalTime> predicate) {
        return (entity) -> predicate.test(entity.timetzColumn());
    }

    public static Predicate<DataTypeEntity> timetzColumn(final LocalTime timetzColumn) {
        return (entity) -> Objects.equals(entity.timetzColumn(), timetzColumn);
    }

    public static Predicate<DataTypeEntity> timetzColumn(final String timetzColumn) {
        return (entity) -> Objects.equals(entity.timetzColumn(), LocalTime.parse(timetzColumn));
    }

    public static Predicate<DataTypeEntity> timestampColumn(final Predicate<LocalDateTime> predicate) {
        return (entity) -> predicate.test(entity.timestampColumn());
    }

    public static Predicate<DataTypeEntity> timestampColumn(final LocalDateTime timestampColumn) {
        return (entity) -> Objects.equals(entity.timestampColumn(), timestampColumn);
    }

    public static Predicate<DataTypeEntity> timestampColumn(final String timestampColumn) {
        return (entity) -> Objects.equals(entity.timestampColumn(), LocalDateTime.parse(timestampColumn));
    }

    public static Predicate<DataTypeEntity> timestamptzColumn(final Predicate<LocalDateTime> predicate) {
        return (entity) -> predicate.test(entity.timestamptzColumn());
    }

    public static Predicate<DataTypeEntity> timestamptzColumn(final LocalDateTime timestamptzColumn) {
        return (entity) -> Objects.equals(entity.timestamptzColumn(), timestamptzColumn);
    }

    public static Predicate<DataTypeEntity> timestamptzColumn(final String timestamptzColumn) {
        return (entity) -> Objects.equals(entity.timestamptzColumn(), LocalDateTime.parse(timestamptzColumn));
    }

    public static Predicate<DataTypeEntity> xmlColumn(final Predicate<String> predicate) {
        return (entity) -> predicate.test(entity.xmlColumn());
    }

    public static Predicate<DataTypeEntity> xmlColumn(final String xmlColumn) {
        return (entity) -> Objects.equals(entity.xmlColumn(), xmlColumn);
    }

}

