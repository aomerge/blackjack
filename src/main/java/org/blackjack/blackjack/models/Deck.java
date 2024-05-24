package org.blackjack.blackjack.models;

import org.blackjack.blackjack.models.interfac.IDeck;
import org.blackjack.blackjack.models.interfac.ICart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck implements IDeck{

    private List<Carts> deck;

    public Deck() {
        deck = new ArrayList<>();
        createDeck();
        shuffleDeck();
    }

    private void createDeck() {
        deck.clear();
        for(int suit = 1; suit <=4; suit++){
            for(int cardId = 1; cardId <= 13; cardId++){
                deck.add( new Carts(cardId, suit) );
            }

        }
    }

    public void shuffleDeck (){
        Collections.shuffle(deck);
    }

    @Override
    public List<Carts> getDeck() {
        return deck;
    }
}
