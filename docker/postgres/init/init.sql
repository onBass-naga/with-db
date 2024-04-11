
CREATE DATABASE sample;

\c sample

DROP TABLE IF EXISTS members;
CREATE TABLE members
(
    id         BIGINT       NOT NULL PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    birthday   DATE,
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE SEQUENCE members_id_seq START 1;

INSERT INTO members (id, name)
VALUES (nextval('members_id_seq'), 'Ash');

DROP TABLE IF EXISTS DATA_TYPES;
CREATE TABLE DATA_TYPES
(
    bool_column        BOOLEAN,
    bit_column         BIT,
    int8_column        BIGINT,
    bigserial_column   BIGSERIAL,
    oid_column         OID,
    bytea_column       BYTEA,
    char_column        CHAR,
    bpchar_column      BPCHAR,
    numeric_column     NUMERIC,
    int4_column        INTEGER,
    serial_column      SERIAL,
    int2_column        SMALLINT,
    smallserial_column SMALLSERIAL,
    float4_column      REAL,
    float8_column      DOUBLE PRECISION,
    money_column       MONEY,
    name_column        NAME,
    text_column        TEXT,
    varchar_column     VARCHAR,
    date_column        DATE,
    time_column        TIME,
    timetz_column      TIMETZ,
    timestamp_column   TIMESTAMP,
    timestamptz_column TIMESTAMPTZ,
    xml_column         XML
);

INSERT INTO DATA_TYPES (bool_column,
                        bit_column,
                        int8_column,
                        bigserial_column,
                        oid_column,
                        bytea_column,
                        char_column,
                        bpchar_column,
                        numeric_column,
                        int4_column,
                        serial_column,
                        int2_column,
                        smallserial_column,
                        float4_column,
                        float8_column,
                        money_column,
                        name_column,
                        text_column,
                        varchar_column,
                        date_column,
                        time_column,
                        timetz_column,
                        timestamp_column,
                        timestamptz_column,
                        xml_column)
VALUES (TRUE, -- bool_column
        B'1', -- bit_column
        123456789, -- int8_column
        DEFAULT, -- bigserial_column (自動採番)
        987654321, -- oid_column
        E'\\xDEADBEEF', -- bytea_column (16進数形式)
        'A', -- char_column
        'abc', -- bpchar_column
        123.45, -- numeric_column
        123456, -- int4_column
        DEFAULT, -- serial_column (自動採番)
        123, -- int2_column
        DEFAULT, -- smallserial_column (自動採番)
        3.14, -- float4_column
        3.141592653589793, -- float8_column
        100.50, -- money_column
        'John Doe', -- name_column
        'Lorem ipsum', -- text_column
        'Sample', -- varchar_column
        '2024-04-06', -- date_column
        '14:30:00', -- time_column
        '14:30:00+05:30', -- timetz_column
        '2024-04-06 14:30:00', -- timestamp_column
        '2024-04-06 14:30:00+05:30', -- timestamptz_column
        '
        <data>sample</data>' -- xml_column
       ),
       (FALSE, -- bool_column
        B'0', -- bit_column
        -987654321, -- int8_column
        DEFAULT, -- bigserial_column (自動採番)
        123456789, -- oid_column
        E'\\xFEEDFACE', -- bytea_column (16進数形式)
        'B', -- char_column
        'def', -- bpchar_column
        -123.45, -- numeric_column
        -123456, -- int4_column
        DEFAULT, -- serial_column (自動採番)
        -123, -- int2_column
        DEFAULT, -- smallserial_column (自動採番)
        -3.14, -- float4_column
        -3.141592653589793, -- float8_column
        -100.50, -- money_column
        'Jane Smith', -- name_column
        'Dolor sit amet', -- text_column
        'Data', -- varchar_column
        '2023-12-25', -- date_column
        '09:45:00', -- time_column
        '09:45:00-02:00', -- timetz_column
        '2023-12-25 09:45:00', -- timestamp_column
        '2023-12-25 09:45:00-02:00', -- timestamptz_column
        '
        <data>example</data>' -- xml_column
       ),
       (TRUE, -- bool_column
        B'1', -- bit_column
        0, -- int8_column
        DEFAULT, -- bigserial_column (自動採番)
        0, -- oid_column
        E'\\x', -- bytea_column (空のバイナリデータ)
        'C', -- char_column
        'ghi', -- bpchar_column
        0, -- numeric_column
        0, -- int4_column
        DEFAULT, -- serial_column (自動採番)
        0, -- int2_column
        DEFAULT, -- smallserial_column (自動採番)
        0.0, -- float4_column
        0.0, -- float8_column
        0.00, -- money_column
        'Michael Johnson', -- name_column
        '', -- text_column (空文字列)
        '', -- varchar_column (空文字列)
        '2025-01-01', -- date_column
        '00:00:00', -- time_column
        '00:00:00-05:00', -- timetz_column
        '2025-01-01 00:00:00', -- timestamp_column
        '2025-01-01 00:00:00-05:00', -- timestamptz_column
        '
        <data/>' -- xml_column (空のXML要素)
       );
