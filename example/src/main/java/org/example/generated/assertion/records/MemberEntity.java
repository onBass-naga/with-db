package org.example.generated.assertion.records;

import com.example.with_db.database.ResultSetWrapper;
import java.lang.Long;
import java.lang.String;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record MemberEntity(
        Long id,
        String name,
        LocalDate birthday,
        LocalDateTime createdAt
) {

    public static MemberEntity of(final ResultSetWrapper resultSet) {
        return new MemberEntity(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getLocalDate("birthday"),
                resultSet.getLocalDateTime("created_at")
        );
    }
}
