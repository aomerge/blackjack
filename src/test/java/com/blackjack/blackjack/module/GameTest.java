package com.blackjack.blackjack.module;

import org.blackjack.blackjack.models.Carts;
import org.blackjack.blackjack.models.Deck;
import org.blackjack.blackjack.models.Game;
import org.blackjack.blackjack.models.Player;
import org.blackjack.blackjack.models.interfac.IGame;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @Test
    public void testErrorStartGame() {
        Deck deck = new Deck();
        deck.shuffleDeck();
        IGame game = new Game(deck);
        game.startGame();
        assertEquals("2530 Error: Is necesario añadir el set player  Class: startGame", game.getLogger().get(0));
        assertEquals(deck.getDeck(), game.getDeckGame());
    }

    @Test
    public void testMoneyHomePlayer(){
        Deck deck = new Deck();
        deck.shuffleDeck();
        IGame game = new Game(deck);
        game.getCasino();
        assertEquals(102000, game.getCasino().getMoney());
        assertEquals(102000, game.getCasino().getMoney());
    }

    @Test
    public void testSetPlayers(){
        Deck deck = new Deck();
        Player player = new Player("John");
        Player player2 = new Player("Jane");
        deck.shuffleDeck();
        IGame game = new Game(deck);
        game.setPlayers(player);
        game.setPlayers(player2);
        System.out.println(game.getPlayers());
        assertEquals(2, game.getPlayers().size());
    }

    @Test
    public void testStartPlayer(){
        Deck deck = new Deck();
        deck.shuffleDeck();

        Player player = new Player("John");

        // Test hand
        LinkedList<Carts> TestCart = new LinkedList<>();
        TestCart.add(deck.getDeck().get(2));
        TestCart.add(deck.getDeck().get(3));

        LinkedList<Carts> TestCart2 = new LinkedList<>();
        TestCart2.add(deck.getDeck().get(0));
        TestCart2.add(deck.getDeck().get(1));

        // Game
        IGame game = new Game(deck);
        game.setPlayers(player);
        game.startGame();



        //Test
        assertEquals(2, player.getHand().size());
        assertEquals(TestCart, player.getHand());
        assertEquals(TestCart2, game.getCasino().getHand());
        assertEquals(48, game.getDeckGame().size());
        assertEquals(1, game.getPlayers().size());
        assertEquals("2255 Game Started , Class : startGame", game.getLogger().get(0));
    }

    @Test
    public void testAddCart(){
        Deck deck = new Deck();
        Player player = new Player("John");
        deck.shuffleDeck();
        System.out.println(deck.getDeck());
        IGame game = new Game(deck);
        game.setPlayers(player);
        game.startGame();
        game.setAddCart("John");

        System.out.println(player.getHand());
        System.out.println(player.getSumHand());

        assertEquals(47, game.getDeckGame().size());
        assertEquals(3, player.getHand().size());
    }

    @Test
    public void testGetStand(){
        Deck deck = new Deck();
        Player player = new Player("John");
        deck.shuffleDeck();
        IGame game = new Game(deck);
        game.setPlayers(player);
        game.startGame();
        game.setAddCart("John");
        game.NxtMove("John", 0, 100);
        game.getStand("John");

        int sumTest =game.getCasino().getHand().stream().mapToInt(Carts ->{
            LinkedList<Integer> handSum = new LinkedList<>();
            if (Carts.getCartId() == 1 && handSum.stream().mapToInt(Integer::intValue).sum() + 11 <= 21){
                handSum.add(11);
            }
            else if (Carts.getCartId() > 10){
                handSum.add(10);
            }
            else {
                handSum.add(Carts.getCartId());
            }
            return handSum.stream().mapToInt(Integer::intValue).sum();
        }).sum();
        int sumTest2 = game.getCasino().getSumHand();

        // Test
        assertEquals(3, player.getHand().size());
        assertEquals(sumTest, sumTest2 );

        List<String> loggerSearching = Arrays.asList(game.getLogger().get(1).split(" "));

        boolean isLose = loggerSearching.stream().anyMatch("lose"::equals);

        if(isLose) {
            assertEquals(102000 - 100, game.getCasino().getMoney());
        } else {
            assertEquals(102000 + 100, game.getCasino().getMoney());
        }
    }

    @Test
    public void testNxtMove() {
        Deck deck = new Deck();
        Player player = new Player("John");
        deck.shuffleDeck();
        IGame game = new Game(deck);
        game.setPlayers(player);
        game.startGame();
        game.setAddCart("John");
        game.NxtMove("John", 0, 100);
        game.getStand("John");

        if (game.getLogger().get(1).contains("lose")) {
            assertEquals(102000 + 100, game.getCasino().getMoney());
            assertEquals(2000 - 100, player.getMoney());
        }
        if (game.getLogger().get(1).contains("win") ) {
            assertEquals(102000 - 100, game.getCasino().getMoney());
            assertEquals(2000 + 100, player.getMoney());
        }
        if(game.getLogger().get(1).contains("draw")) {
            assertEquals(102000, game.getCasino().getMoney());
        }
        assertEquals(200, game.getPiles().getBet());

    }

}
