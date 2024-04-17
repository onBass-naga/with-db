package com.example.with_db.database;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;

public class ResultSetWrapper {

    private final ResultSet resultSet;

    public ResultSetWrapper(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public boolean next() {
        try {
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getString(final String columnName) {
        try {
            return resultSet.getString(columnName);
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean getBoolean(final String columnName) {
        try {
            return resultSet.getBoolean(columnName);
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Long getLong(final String columnName) {
        try {
            return resultSet.getLong(columnName);
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getInteger(final String columnName) {
        try {
            return resultSet.getInt(columnName);
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Short getShort(final String columnName) {
        try {
            return resultSet.getShort(columnName);
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Float getFloat(final String columnName) {
        try {
            return resultSet.getFloat(columnName);
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Double getDouble(final String columnName) {
        try {
            return resultSet.getDouble(columnName);
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public BigDecimal getBigDecimal(final String columnName) {
        try {
            return resultSet.getBigDecimal(columnName);
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LocalDate getLocalDate(final String columnName) {
        try {
            final var date = resultSet.getDate(columnName);
            return date == null ? null : date.toLocalDate();
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LocalTime getLocalTime(final String columnName) {
        try {
            final var time = resultSet.getTime(columnName);
            return time == null ? null : time.toLocalTime();
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LocalDateTime getLocalDateTime(final String columnName) {
        try {
            final var timestamp = resultSet.getTimestamp(columnName);
            return timestamp == null ? null : timestamp.toLocalDateTime();
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public OffsetTime getOffsetTime(final String columnName) {
        try {
            final var time = resultSet.getTime(columnName);
            return time == null ? null : OffsetTime.of(time.toLocalTime(), ZoneOffset.UTC);
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public OffsetDateTime getOffsetDateTime(final String columnName) {
        try {
            final var timestamp = resultSet.getTimestamp(columnName);
            return timestamp == null ? null : OffsetDateTime.of(timestamp.toLocalDateTime(), ZoneOffset.UTC);
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] getBytes(final String columnName) {
        try {
            return resultSet.getBytes(columnName);
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
