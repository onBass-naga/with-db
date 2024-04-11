package org.example.generated.assertion.records;

import com.example.with_db.database.Records;

import java.util.List;

public class DataTypeRecords extends Records<DataTypeEntity, DataTypeRecords> {
    public DataTypeRecords(final List<DataTypeEntity> values) {
        super.values = values;
    }

    @Override
    protected Class<DataTypeRecords> getRecordsClass() {
        return DataTypeRecords.class;
    }
}
