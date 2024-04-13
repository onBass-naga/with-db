package org.example.generated.assertion.predicates;

import org.example.generated.assertion.records.MemberEntity;
import org.example.generated.setup.model.Member;

import java.util.Objects;
import java.util.function.Predicate;
import java.lang.Long;
import java.lang.String;
import java.sql.Date;
import java.sql.Timestamp;

public class MemberPredicates {

    public static class Editor {
        private Predicate<MemberEntity> id;
        private Predicate<MemberEntity> name;
        private Predicate<MemberEntity> birthday;
        private Predicate<MemberEntity> createdAt;

        public Editor(final Member Member) {
            this.id = (entity) -> Objects.equals(entity.id(), Member.id());
            this.name = (entity) -> Objects.equals(entity.name(), Member.name());
            this.birthday = (entity) -> Objects.equals(entity.birthday(), Member.birthday());
            this.createdAt = (entity) -> Objects.equals(entity.createdAt(), Member.createdAt());
        }

        public Editor id(final Predicate<Long> predicate) {
            this.id = MemberPredicates.id(predicate);
            return this;
        }

        public Editor name(final Predicate<String> predicate) {
            this.name = MemberPredicates.name(predicate);
            return this;
        }

        public Editor birthday(final Predicate<Date> predicate) {
            this.birthday = MemberPredicates.birthday(predicate);
            return this;
        }

        public Editor createdAt(final Predicate<Timestamp> predicate) {
            this.createdAt = MemberPredicates.createdAt(predicate);
            return this;
        }


        public Predicate<MemberEntity> edit() {
            return id.and(name.and(birthday.and(createdAt)));
        }
    }

    public static Editor editorOf(final Member Member) {
        return new Editor(Member);
    }

    public static Predicate<MemberEntity> of(final Member Member) {
        return new Editor(Member).edit();
    }

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
