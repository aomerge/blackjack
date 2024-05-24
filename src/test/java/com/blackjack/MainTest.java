package com.blackjack;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void testHelloWorld() {
        String greeting = "Hello World!";
        assertEquals("Hello World!", greeting);
    }

    @Test
    public void testHelloWorld2() {
        String greeting = "mon";
        assertEquals("mon", greeting);
    }
}
