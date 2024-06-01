package com.blackjack.blackjack.module;

import org.blackjack.blackjack.models.Deck;
import org.blackjack.blackjack.models.Game;
import org.blackjack.blackjack.models.interfac.IGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @Test
    public void testErrorStartGame() {
        Deck deck = new Deck();
        deck.shuffleDeck();
        IGame game = new Game(deck);
        game.startGame();
        assertEquals("Is necesario añadir el set player", game.getLogger().get(0));
        assertEquals("No se pudo inicializar el juego checka el logger", game.startGame());
    }

    @Test
    public void testMoneyHomePlayer(){
        Deck deck = new Deck();
        deck.shuffleDeck();
        IGame game = new Game(deck);
        game.getHomePlayer();
        assertEquals(102000, game.getHomePlayer().getMoney());
    }
}
