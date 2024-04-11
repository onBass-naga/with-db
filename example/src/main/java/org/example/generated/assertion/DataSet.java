package org.example.generated.assertion;

import com.example.with_db.database.Table;
import org.example.generated.assertion.records.DataTypeEntity;
import org.example.generated.assertion.records.DataTypeRecords;
import org.example.generated.assertion.records.MemberEntity;
import org.example.generated.assertion.records.MemberRecords;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class DataSet {

    private enum TABLE_SETTERS {
        MEMBERS("members",
                (dataSet, records) -> dataSet.memberList = records.stream().map(MemberEntity.class::cast).toList(),
                MemberEntity::of),
        DATA_TYPES("DATA_TYPES",
                (dataSet, records) -> dataSet.dataTypeList = records.stream().map(DataTypeEntity.class::cast).toList(),
                DataTypeEntity::of);

        private final String tableName;
        private final BiConsumer<DataSet, List<Object>> setter;
        private final Function<ResultSet, Object> converter;

        TABLE_SETTERS(final String tableName,
                      final BiConsumer<DataSet, List<Object>> setter,
                      final Function<ResultSet, Object> converter) {
            this.tableName = tableName;
            this.setter = setter;
            this.converter = converter;
        }
    }

    private List<MemberEntity> memberList;
    public MemberRecords members() {
        return Optional.ofNullable(memberList)
                .map(MemberRecords::new)
                .orElseThrow(() -> new IllegalStateException("members did not load"));
    }

    private List<DataTypeEntity> dataTypeList;
    public DataTypeRecords dataTypes() {
        return Optional.ofNullable(dataTypeList)
                .map(DataTypeRecords::new)
                .orElseThrow(() -> new IllegalStateException("DATA_TYPES did not load"));
    }

    public static DataSet load(final Connection connection, final Table... tables) {
        return load(connection, List.of(tables));
    }

    public static DataSet load(final Connection connection, final List<Table> tables) {

        final var targetTableNames = tables.stream().map(Table::tableName).toList();
        final var dataSet = new DataSet();

        for (final var tableSetter : TABLE_SETTERS.values()) {

            if (!targetTableNames.contains(tableSetter.tableName)) {
                continue;
            }

            try {
                final var stmt = connection.createStatement();
                final var sql = "SELECT * FROM %s".formatted(tableSetter.tableName);
                final var resultSet = stmt.executeQuery(sql);

                final List<Object> records = new ArrayList<>();
                while (resultSet.next()) {
                    records.add(tableSetter.converter.apply(resultSet));
                }

                tableSetter.setter.accept(dataSet, records);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return dataSet;
    }
}
