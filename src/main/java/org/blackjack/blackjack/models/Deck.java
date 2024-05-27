package org.blackjack.blackjack.models;

import org.blackjack.blackjack.models.interfac.IDeck;

import java.util.*;

public class Deck implements IDeck{

    protected Stack<Carts> deck = new Stack<>();

    public Deck() {
        createDeck();
        shuffleDeck();
    }

    private void createDeck() {
        deck.clear();
        for(int suit = 1; suit <=4; suit++){
            for(int cardId = 1; cardId <= 13; cardId++){
                deck.push( new Carts(cardId, suit) );
            }

        }
    }

    public Stack<Carts> shuffleDeck (){
        Collections.shuffle(deck);
        return deck;

    }

    public String resetDeck(){
        try {
            if(deck.size() < 52 && !deck.isEmpty()){
                throw new IllegalArgumentException("Deck Is Complete, Cannot Reset Deck");
            }
            createDeck();
            shuffleDeck();
            System.out.println("Deck created and shuffled hg");
            return  "Deck created and shuffled";
        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return( e.getMessage());
        }
    }

    public void dealCard(){
        deck.remove(0);
    }

    public <T extends String> LinkedList<Carts>  handoutCard(){
        try {
            if(deck.isEmpty()){
                throw new IllegalArgumentException("Deck is empty");
            }
            LinkedList<Carts> hand = new LinkedList<>();
            hand.add(deck.get(0));
            hand.add(deck.get(1));
            deck.remove(0);
            deck.remove(1);
            return hand;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Stack<Carts> getDeck() {
        return deck;
    }

}
