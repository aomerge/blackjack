package org.blackjack.blackjack.models.interfac;

import org.blackjack.blackjack.models.Carts;
import org.blackjack.blackjack.models.Deck;
import org.blackjack.blackjack.models.Player;

import java.util.LinkedList;
import java.util.List;

public interface IGame {
    void startGame ();
    void setPlayers(Player player);
    List<Player> getPlayers();
    LinkedList<String> getLogger();
    Player getCasino();
    List<Carts> getDeckGame();
    void setAddCart(String namePlayer);
    void getStand(String namePlayer);
}
