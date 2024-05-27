package com.blackjack.blackjack.module;
import org.blackjack.blackjack.models.Player;
import org.junit.jupiter.api.Test;
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
        assertEquals(0, player.getHand().size());
    }
}
