package com.example.with_db;

import org.example.generated.assertion.SampleDataSet;
import com.example.with_db.operation.InsertOperation;
import com.example.with_db.operation.TruncateOperation;
import com.example.with_db.assertion.predicates.CommonPredicates;
import org.example.generated.assertion.predicates.MemberPredicates;
import org.example.generated.assertion.records.MemberEntity;
import org.example.generated.setup.model.Member;
import org.example.generated.tables.Tables;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.Objects;
import java.util.function.Predicate;

import static com.example.with_db.assertion.predicates.CommonPredicates.any;

public class SampleTest {

    @Test
    void test1() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/sample",
                "postgres",
                "postgres");

        TruncateOperation.execute(con, Tables.MEMBERS);

        final var member = Member.builder()
                .id(2L)
                .name("Nobita")
                .birthday(Date.valueOf("1990-08-07"))
                .createdAt(Timestamp.valueOf("2024-03-30 01:22:34"))
                .build();

        final var member2 = Member.builder().id(3L)
                .name("Suneo")
                .build();

        final var member3 = member2.editor().id(4L).name("Shizuka").build();

        final var member4 = Member.builder().id(5L).name("Tom").birthday(Date.valueOf("1990-08-07")).build();

        InsertOperation.execute(con, member, member2, member3, member4);

        final var dataSet = SampleDataSet.load(con, Tables.MEMBERS);
        final var members = dataSet.members();

        Assertions.assertEquals(4, members.count());

        Predicate<MemberEntity> birthdayIsNull = it -> Objects.isNull(it.birthday());
        Assertions.assertEquals(2, members.filter(birthdayIsNull).count());

        Predicate<MemberEntity> nameIsShizuka = it -> Objects.equals(it.name(), "Shizuka");
        Assertions.assertEquals(1, members.filter(birthdayIsNull.and(nameIsShizuka)).count());

        final var found = members.filter(MemberPredicates.id(2L)).one();
        Assertions.assertEquals("Nobita", found.name());

        final var idIsGreaterThan3 = MemberPredicates.id(id -> id > 3);
        Assertions.assertEquals(2, members.filter(idIsGreaterThan3).count());

        final var birthdayIsNotNull = MemberPredicates.birthday(CommonPredicates.nonNull());
        Assertions.assertEquals(2, members.filter(birthdayIsNotNull).count());

        final var sameBirthday = MemberPredicates.editorOf(member)
                .id(any())
                .name(any())
                .createdAt(any())
                .edit();
        Assertions.assertEquals(2, members.filter(sameBirthday).count());

        Assertions.assertEquals(1, members.filter(MemberPredicates.of(member)).count());
    }

    @Test
    void test2() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/sample",
                "postgres",
                "postgres");

        final var dataSet = SampleDataSet.load(con, Tables.DATA_TYPES);
        System.out.println(dataSet.dataTypes());
    }
}
