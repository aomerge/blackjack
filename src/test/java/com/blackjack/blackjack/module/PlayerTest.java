package com.blackjack.blackjack.module;
import org.blackjack.blackjack.models.Carts;
import org.blackjack.blackjack.models.Deck;
import org.blackjack.blackjack.models.Player;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test
    public void testGetPlayer() {
        Player player = new Player("John" );
        assertEquals("John", player.getName());
        assertEquals(2000, player.getMoney());
        assertEquals("[2000]", player.getBalance().toString());
    }

    @Test
    public void testSetName() {
        Player player = new Player("John" );
        player.setName("Jane");
        assertEquals("Jane", player.getName());
    }

    @Test
    public void testSetMoney() {
        Player player = new Player("John" );
        player.setMoney(1000);
        assertEquals(3000, player.getMoney());
    }

    @Test
    public void testRemoveBalance() {
        Player player = new Player("John" );
        player.removeBalance(1000);
        assertEquals(1000, player.getMoney());
    }

    @Test
    public void testGetHand() {
        Player player = new Player("John" );
        // Deck and Payer
        Deck deck = new Deck();
        LinkedList<Carts> hand =  deck.handoutCard();
        player.setHand(hand.get(0));
        player.setHand(hand.get(1));

        assertEquals(2, player.getHand().size());
        assertEquals(50, deck.getDeck().size());
    }

    @Test
    public void testSetHandoutCard() {

        // Deck and Payer
        Deck deck = new Deck();
        Player player = new Player("John" );

        // Deck Test
        List<Carts> deckAll = deck.getDeck();
        LinkedList<Carts> handTest = new LinkedList<>();
        handTest.add(deckAll.get(0));
        handTest.add(deckAll.get(1));

        // deck.handoutCard()
        LinkedList<Carts> hand =  deck.handoutCard();
        player.setHand(hand.get(0));
        player.setHand(hand.get(1));

        LinkedList<Carts> handPlayer =  player.getHand();

        // Test
        assertEquals(50, deck.getDeck().size());
        assertEquals(2, handPlayer.size());
        assertEquals(handTest, handPlayer);
    }

    @Test
    public void testSetHand() {
        // Deck and Payer
        Deck deck = new Deck();
        Player player = new Player("John" );

        // Deck Test
        List<Carts> deckAll = deck.getDeck();
        LinkedList<Carts> handTest = new LinkedList<>();
        handTest.add(deckAll.get(0));
        handTest.add(deckAll.get(1));
        handTest.add(deckAll.get(2));

        // deck.handoutCard()
        LinkedList<Carts> hand =  deck.handoutCard();
        deck.setHand();
        player.setHand(hand.get(0));
        player.setHand(hand.get(1));
        player.setHand(hand.get(2));

        LinkedList<Carts> handPlayer =  player.getHand();

        // Test
        assertEquals(49, deck.getDeck().size());
        assertEquals(3, handPlayer.size());
        assertEquals(handTest, handPlayer);
    }

    @Test void testSumHand(){
        // Deck and Payer
        Deck deck = new Deck();
        Player player = new Player("John" );

        // Deck Test
        List<Carts> deckAll = deck.getDeck();
        Stack<Carts> handTest = new Stack<>();
        Stack<Integer> handSumTest = new Stack<>();
        handTest.add(deckAll.get(0));
        handTest.add(deckAll.get(1));
        handTest.add(deckAll.get(2));
        handTest.add(deckAll.get(3));
        handTest.forEach(carts ->{
            if (carts.getCartId() == 1 && handSumTest.stream().mapToInt(Integer::intValue).sum() + 11 <= 21){
                handSumTest.add(11);
            }
            else if (carts.getCartId() > 10){
                handSumTest.add(10);
            }
            else {
                handSumTest.add(carts.getCartId());
            }
        });
        int sumTest = handSumTest.stream().mapToInt(Integer::intValue).sum();

        // deck.handoutCard()
        LinkedList<Carts> hand =  deck.handoutCard();
        player.setHand(hand.get(0));
        player.setHand(hand.get(1));
        deck.setHand();
        deck.setHand();
        player.setHand(hand.get(2));
        player.setHand(hand.get(3));

        System.out.println(player.getHand());

        int sum = player.getSumHand();

        // Test
        assertEquals(sumTest, sum);

    }

}
