package org.example.generated.assertion.records;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.Long;
import java.lang.String;
import java.sql.Date;
import java.sql.Timestamp;

public record MemberEntity(
        Long id,
        String name,
        Date birthday,
        Timestamp createdAt
) {

    public static MemberEntity of(final ResultSet resultSet) {
        try {
            return new MemberEntity(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getDate("birthday"),
                    resultSet.getTimestamp("created_at")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
