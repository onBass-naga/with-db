package org.example.generated.assertion.records;

import java.util.List;
import java.util.function.Predicate;

public record MemberRecords(List<MemberEntity> rows) {
    public MemberEntity one() {
        return rows.getFirst();
    }

    public int count() {
        return rows.size();
    }

    public boolean notExist() {
        return rows.isEmpty();
    }

    public MemberRecords filter(final Predicate<MemberEntity> predicate) {
        return new MemberRecords(rows.stream().filter(predicate).toList());
    }
}
