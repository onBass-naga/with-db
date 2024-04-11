package com.example.with_db.generator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableNameTest {

    @Test
    void pascalCaseSingular() {
        final var sut = new TableName("ORDER_DETAILS");
        final var actual = sut.upperCamelCaseSingular();
        assertEquals("OrderDetail", actual);
    }
}