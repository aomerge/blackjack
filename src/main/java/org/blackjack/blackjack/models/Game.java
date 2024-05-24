package org.blackjack.blackjack.models;

import org.blackjack.blackjack.models.interfac.ICart;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<ICart> deck;

    public Game() {
        deck = new ArrayList<>();
        createDeck();
        shuffleDeck();
    }

    public void createDeck() {}

    public void shuffleDeck (){}

    public void moveCard(){}

    public void applyRules(){}

    public void createPiles(){}

    public void startGame(){}

    public void endGame(){}

    public void restartGame(){}

    public void saveGame(){}
}
