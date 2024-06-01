package org.blackjack.blackjack.models.interfac;

import org.blackjack.blackjack.models.Player;

import java.util.LinkedList;
import java.util.List;

public interface IGame {
    String startGame ();
    void setPlayers(Player player);
    List<Player> getPlayers();
    LinkedList<String> getLogger();
    Player getHomePlayer();
}
