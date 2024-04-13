package org.example.generated.assertion.records;

import com.example.with_db.database.Records;

import java.util.List;

public class MemberRecords extends Records<MemberEntity, MemberRecords> {
    public MemberRecords(final List<MemberEntity> values) {
        super.values = values;
    }

    @Override
    protected Class<MemberRecords> getRecordsClass() {
        return MemberRecords.class;
    }
}