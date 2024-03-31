package org.example;


import org.example.generated.InsertOperation;
import org.example.generated.Member;
import org.example.generated.TruncateOperation;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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

        try (
                Connection con = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/sample",
                        "postgres",
                        "postgres");
        ) {

//            InsertOperation.execute(con, List.of(member, member2, member3));
//            TruncateOperation.execute(con, List.of("members"));



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}