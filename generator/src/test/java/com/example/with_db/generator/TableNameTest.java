package com.example.with_db.generator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableNameTest {

    @Test
    void pascalCaseSingular() {
        final var sut = new Table("ORDER_DETAILS");
        final var actual = sut.upperCamelCaseSingularName();
        assertEquals("OrderDetail", actual);
    }
}