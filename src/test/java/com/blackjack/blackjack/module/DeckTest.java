package com.blackjack.blackjack.module;

import org.blackjack.blackjack.models.Deck;
import org.blackjack.blackjack.models.Carts;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DeckTest {
    @Test
    public void testNumberCartsDeck() {
        Deck deck = new Deck();
        assertEquals(52, deck.getDeck().size());
    }

    @Test
    public void testShuffleDeck() {
        Deck deck1 = new Deck();
        Stack<Carts> deck1List = new Stack<>();
        deck1List.addAll(deck1.getDeck());

        Deck deck2 = new Deck();
        Stack<Carts> deck2List = new Stack<>();
        deck2List.addAll(deck2.getDeck());

        assertNotEquals(deck1List, deck2List);
    }

    @Test
    public void testDealCard() {
        Deck deck = new Deck();
        deck.dealCard();
        assertEquals(51, deck.getDeck().size());
    }

    @Test void testResetDeck() {
        Deck deck = new Deck();
        for (int i = 0; i < 52; i++) {
            deck.dealCard();
        }
        deck.resetDeck();
        assertEquals(52, deck.getDeck().size());
        assertEquals("Deck created and shuffled", deck.resetDeck());
    }

    @Test
    public void testResetDeckException() {
        Deck deck = new Deck();
        for (int i = 0; i < 50; i++) {
            deck.dealCard();
        }
        deck.resetDeck();
        assertEquals(2, deck.getDeck().size());
        assertEquals("Deck Is Complete, Cannot Reset Deck", deck.resetDeck());
    }

    @Test
    public void testHandoutCard() {
        // Deck
        Deck deck = new Deck();
        // Deck Test
        List<Carts> deckAll = deck.getDeck();
        LinkedList<Carts> handTest = new LinkedList<>();
        handTest.add(deckAll.get(0));
        handTest.add(deckAll.get(1));
        
        // deck.handoutCard()
        LinkedList<Carts> hand =  deck.handoutCard();
        
        // Test
        assertEquals(50, deck.getDeck().size());
        assertEquals(2, hand.size());
        assertEquals(handTest, hand);
    }


}
