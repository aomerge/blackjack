package com.blackjack.blackjack.module;

import org.blackjack.blackjack.models.Player;
import org.blackjack.blackjack.models.Record;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RecordTest {
    @Test
    public void testGetRecord() {
        Player player = new Player("John" );
        Record record = new Record(player);
        record.setRecord();

        assertEquals(5, record.getRecord().size());
        assertEquals(200, record.getRecord().get(0));
        assertEquals(400, record.getRecord().get(1));
        assertEquals(600, record.getRecord().get(2));
        assertEquals(1000, record.getRecord().get(3));
    }

    @Test
    public void testSetRecord() {
        Player player = new Player("John" );
        Record record = new Record(player);
        record.setRecord();

        assertNotEquals(100, record.getRecord().get(0));
        assertNotEquals(200, record.getRecord().get(1));
        assertNotEquals(300, record.getRecord().get(2));
        assertNotEquals(500, record.getRecord().get(3));
    }
}
