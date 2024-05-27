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

    public String getSuitName(){
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        return suits[suit - 1];
    }

    public void setSuit(int suit) {
        try {
            if (suit >= 1 && suit <= 4){
                this.suit = suit;
            }
            throw new IllegalArgumentException("Invalid suit");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
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
