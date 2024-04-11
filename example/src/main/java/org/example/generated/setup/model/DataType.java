package org.example.generated.setup.model;

import com.example.with_db.database.SetupModel;
import com.example.with_db.database.column.ColumnName;
import com.example.with_db.database.status.Ng;
import com.example.with_db.database.status.Ok;
import com.example.with_db.database.status.Status;
import org.example.generated.tables.Tables;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.function.Function;

public record DataType(@ColumnName("id") Long id,
                       @ColumnName("name") String name,
                       @ColumnName("birthday") Date birthday,
                       @ColumnName("created_at") Timestamp createdAt) implements SetupModel {

    @Override
    public Tables tableMeta() {
        return Tables.MEMBERS;
    }

    public static class Builder<HasId extends Status, HasName extends Status> {
        private final Long id;
        private final String name;
        private final Date birthday;
        private final Timestamp createdAt;

        public Builder(Long id, String name, Date birthday, Timestamp createdAt) {
            this.id = id;
            this.name = name;
            this.birthday = birthday;
            this.createdAt = createdAt;
        }

        public Builder<Ok, HasName> id(Long id) {
            return new Builder<>(id, name, birthday, createdAt);
        }

        public Builder<HasId, Ok> name(String name) {
            return new Builder<>(id, name, birthday, createdAt);
        }

        public Builder<HasId, HasName> birthday(Date birthday) {
            return new Builder<>(id, name, birthday, createdAt);
        }

        public Builder<HasId, HasName> createdAt(Timestamp createdAt) {
            return new Builder<>(id, name, birthday, createdAt);
        }
    }

    public static Builder<Ng, Ng> builder() {
        return new Builder<>(null, null, null, null);
    }

    public static DataType build(Builder<Ok, Ok> builder) {
        return new DataType(
                builder.id, builder.name, builder.birthday, builder.createdAt
        );
    }

    public static DataType build(Function<Builder<Ng, Ng>, Builder<Ok, Ok>> f) {
        return build(f.apply(builder()));
    }

    public static class Editor {
        private Long id;
        private String name;
        private Date birthday;
        private Timestamp createdAt;

        public Editor(final Long id, final String name, final Date birthday, final Timestamp createdAt) {
            this.id = id;
            this.name = name;
            this.birthday = birthday;
            this.createdAt = createdAt;
        }

        public Editor id(Long id) {
            this.id = id;
            return this;
        }

        public Editor name(String name) {
            this.name = name;
            return this;
        }

        public Editor birthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public Editor createdAt(Timestamp createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public DataType edit() {
            return new DataType(this.id, this.name, this.birthday, this.createdAt);
        }
    }

    public Editor editor() {
        return new Editor(this.id, this.name, this.birthday, this.createdAt);
    }
}
