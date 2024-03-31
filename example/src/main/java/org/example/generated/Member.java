package org.example.generated;


import com.example.with_db.database.TableName;
import com.example.with_db.database.column.ColumnName;
import com.example.with_db.database.status.Ng;
import com.example.with_db.database.status.Ok;
import com.example.with_db.database.status.Status;
import com.example.with_db.database.Record;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.function.Function;

@TableName("members")
public record Member(@ColumnName("id") Long id,
                     @ColumnName("name") String name,
                     @ColumnName("birthday") Date birthday,
                     @ColumnName("created_at") Timestamp createdAt) implements Record {

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

    public static Member build(Builder<Ok, Ok> builder) {
        return new Member(
                builder.id, builder.name, builder.birthday, builder.createdAt
        );
    }

    public static Member build(Function<Builder<Ng, Ng>, Builder<Ok, Ok>> f) {
        return build(f.apply(builder()));
    }

}
