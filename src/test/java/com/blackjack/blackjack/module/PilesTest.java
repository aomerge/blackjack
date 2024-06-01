package com.blackjack.blackjack.module;

import org.blackjack.blackjack.models.Player;
import org.junit.jupiter.api.Test;
import  org.blackjack.blackjack.models.Piles;

import java.util.Stack;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PilesTest {
    @Test
    public void testGetBet() {
        Piles piles = new Piles();
        assertEquals(0, piles.getBet());
    }

    @Test
    public void testSetBet() {
        Piles piles = new Piles();
        piles.setBet(2);
        assertEquals(2, piles.getBet());
    }

    @Test
    public void testGetCall() {
        Piles piles = new Piles();
        piles.setBet(50);

        assertEquals(50, piles.getCall());
    }

    @Test
    public void testSetCall() {
        // Piles
        Piles piles = new Piles();
        piles.setBet(50);
        piles.setCall();
        Stack<Integer> pileTest =  piles.getPile();

        // Tests
        assertEquals(pileTest.get(0), piles.getCall());
        assertEquals(2, pileTest.size());

    }
    @Test
    public void testGetRaise(){
        Piles piles = new Piles();
        piles.setBet(50);
        piles.setRaise(60);
        assertEquals(60, piles.getRaise());
    }
    @Test
    public void testSetRaise(){
        Piles piles = new Piles();
        piles.setBet(50);
        piles.setRaise(60);
        assertEquals(60, piles.getPile().get(1));
        assertEquals(2, piles.getPile().size());
    }

    @Test
    public void  testErrorGetRaise()
    {
        Piles piles = new Piles();
        piles.setBet(50);
        piles.setRaise(40);
        assertEquals("El numero es manor al numero de apuesta", piles.getLogger().get(0));

    }

    @Test
    public void testGetAllIn(){
        // Object
        Player player = new Player("John");
        Piles piles = new Piles();

        piles.setBet(50);
        int Money = player.getMoney();
        piles.setAllIn(Money);
        piles.getAllIn();
        player.removeBalance(Money);

        assertEquals(piles.getAllIn(), Money);
        assertEquals(2, piles.getPile().size());
        assertEquals(0, player.getMoney());
    }

    @Test
    public void testSumGetPile(){
        // Players and Piles
        Player player = new Player("John");
        Player player1 = new Player("Angel");
        Player player2 = new Player("Jhonatan");
        Player player3 = new Player("Miguel");
        Player player4 = new Player("Francis");
        Piles piles = new Piles();

        // Piles changes
        piles.setBet(50);
        player.removeBalance(piles.getPile().get(piles.getPile().size()-1));
        piles.setCall();
        player1.removeBalance(piles.getPile().get(piles.getPile().size()-1));
        piles.setCall();
        player2.removeBalance(piles.getPile().get(piles.getPile().size()-1));
        piles.setRaise(300);
        player3.removeBalance(piles.getPile().get(piles.getPile().size()-1));
        piles.setAllIn(2000);
        player4.removeBalance(piles.getPile().get(piles.getPile().size()-1));

        // Tests
        assertEquals(1950, player1.getMoney());
        player1.setMoney(piles.getSumPile());
        assertEquals(2450, piles.getSumPile());
        assertEquals(1950, player2.getMoney());
        assertEquals(1700, player3.getMoney());
        assertEquals(0, player4.getMoney());
        assertEquals(4400, player1.getMoney());
    }

}
