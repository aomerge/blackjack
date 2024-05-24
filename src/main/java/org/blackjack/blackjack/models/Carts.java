package org.blackjack.blackjack.controller.game;

public class Carts implements org.blackjack.blackjack.controller.game.interfac.Carts {
    private int cartId;


    private int suit;

    public Carts(int cartId, int suit) {
        this.cartId = cartId;
        this.suit = suit;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

}
