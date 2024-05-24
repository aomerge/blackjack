package org.blackjack.blackjack.models;
import org.blackjack.blackjack.models.interfac.ICart;

public class Carts implements ICart {
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

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        return suits[suit - 1 ] + " " + cartId;
    }
}
