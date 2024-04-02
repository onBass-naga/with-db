package com.example.with_db;

import com.example.with_db.operation.InsertOperation;
import com.example.with_db.operation.TruncateOperation;
import org.example.generated.setup.Member;
import org.example.generated.tables.Tables;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class SampleTest {

    @Test
    void test1() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/sample",
                "postgres",
                "postgres");

        TruncateOperation.execute(con, Tables.MEMBERS);

        final var member = Member.build(builder ->
                builder.id(2L)
                        .name("Nobita")
                        .birthday(Date.valueOf("1990-08-07"))
                        .createdAt(Timestamp.valueOf("2024-03-30 01:22:34")));

        final var member2 = Member.build(builder ->
                builder.id(3L)
                        .name("Suneo"));

        final var member3 = Member.build(builder ->
                builder.id(4L).name("Shizuka"));

        InsertOperation.execute(con, member, member2, member3);

        Assertions.assertEquals(1, 1);
    }
}
