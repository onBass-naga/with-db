package org.example.generated.setup.model;

import com.example.with_db.database.column.ColumnName;
import com.example.with_db.database.SetupModel;
import org.example.generated.tables.Tables;

import java.lang.Long;
import java.lang.String;
import java.sql.Date;
import java.sql.Timestamp;

public record Member(
        @ColumnName("id") Long id,
        @ColumnName("name") String name,
        @ColumnName("birthday") Date birthday,
        @ColumnName("created_at") Timestamp createdAt
    ) implements SetupModel {

    @Override
    public Tables tableMeta() {
        return Tables.MEMBERS;
    }

    public static class Builder {
        private Long id;
        private String name;
        private Date birthday;
        private Timestamp createdAt;

        public Builder(
                Long id,
                String name,
                Date birthday,
                Timestamp createdAt
        ) {
            this.id = id;
            this.name = name;
            this.birthday = birthday;
            this.createdAt = createdAt;
        }

        public Builder id(final Long id) {
            this.id = id;
            return this;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder birthday(final Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public Builder createdAt(final Timestamp createdAt) {
            this.createdAt = createdAt;
            return this;
        }


        public Member build() {
            return new Member(
                this.id,
                this.name,
                this.birthday,
                this.createdAt
            );
        }
    }

    public static Builder builder() {
        return new Builder(
            null,
            null,
            null,
            null
        );
    }

    public Builder editor() {
        return new Builder(
            this.id,
            this.name,
            this.birthday,
            this.createdAt
        );
    }
}
