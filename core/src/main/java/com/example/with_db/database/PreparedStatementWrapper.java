package com.example.with_db.database;

import java.sql.*;

public class PreparedStatementWrapper {

    private final PreparedStatement preparedStatement;

    public PreparedStatementWrapper(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    public void setValue(final int index, final Object value) {
        try {
            final var metaData = preparedStatement.getParameterMetaData();
            final int sqlTypeCode = metaData.getParameterType(index + 1);

            if (value == null) {
                preparedStatement.setNull(index + 1, sqlTypeCode);
                return;
            }

//            final var valueConverted = switch (value) {
//                case OffsetDateTime it -> it.format(DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.SSSSSSXXX"));
//                case Boolean it when sqlTypeCode == Types.BIT -> it? (byte)1: (byte)0;
//                default -> value;
//            };

            preparedStatement.setObject(index + 1, value, sqlTypeCode);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeUpdate() {
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
