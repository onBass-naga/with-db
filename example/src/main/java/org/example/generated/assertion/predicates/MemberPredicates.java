package org.example.generated.assertion.predicates;

import org.example.generated.assertion.records.MemberEntity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.function.Predicate;

public class MemberPredicates {

    public static Predicate<MemberEntity> id(final Predicate<Long> predicate) {
        return (entity) -> predicate.test(entity.id());
    }

    public static Predicate<MemberEntity> id(final Long id) {
        return (entity) -> Objects.equals(entity.id(), id);
    }

    public static Predicate<MemberEntity> name(final Predicate<String> predicate) {
        return (entity) -> predicate.test(entity.name());
    }

    public static Predicate<MemberEntity> name(final String name) {
        return (entity) -> Objects.equals(entity.name(), name);
    }

    public static Predicate<MemberEntity> birthday(final Predicate<Date> predicate) {
        return (entity) -> predicate.test(entity.birthday());
    }

    public static Predicate<MemberEntity> birthday(final Date birthday) {
        return (entity) -> Objects.equals(entity.birthday(), birthday);
    }

    public static Predicate<MemberEntity> birthday(final String birthday) {
        return (entity) -> Objects.equals(entity.birthday(), Date.valueOf(birthday));
    }

    public static Predicate<MemberEntity> createdAt(final Predicate<Timestamp> predicate) {
        return (entity) -> predicate.test(entity.createdAt());
    }

    public static Predicate<MemberEntity> createdAt(final Timestamp createdAt) {
        return (entity) -> Objects.equals(entity.createdAt(), createdAt);
    }

    public static Predicate<MemberEntity> createdAt(final String createdAt) {
        return (entity) -> Objects.equals(entity.createdAt(), Timestamp.valueOf(createdAt));
    }
}
