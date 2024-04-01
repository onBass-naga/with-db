package com.example.with_db.operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TruncateOperation {
    public static void execute(final Connection connection, final List<String> tableNames) {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableNames.forEach(name -> {
            try (final var stmt = connection.createStatement()) {
                stmt.executeUpdate("TRUNCATE " + name);
                connection.commit();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
