package com.blackjack.blackjack.module;

import org.blackjack.blackjack.models.Carts;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartsTest {
    @Test
    public void testGetCarts() {
        Carts carts = new Carts(1,1);
        assertEquals(1, carts.getCartId());
    }

    @Test
    public void testGetSuit() {
        Carts carts = new Carts(5,2);
        assertEquals(2, carts.getSuit());
    }

    @Test
    public void testGetSuitName() {
        Carts carts = new Carts(5,2);
        assertEquals("Diamonds", carts.getSuitName());
    }
}
