package org.blackjack.blackjack.models;

import org.blackjack.blackjack.models.interfac.IDeck;

import java.util.*;

public class Deck implements IDeck{

    private  LinkedList<String> Logger = new LinkedList<>();
    protected Stack<Carts> deck = new Stack<>();
    public LinkedList<Carts> hand = new LinkedList<>();

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
            return  "Deck created and shuffled";
        }catch(IllegalArgumentException e) {
            Logger.add(e.getMessage());

            return( e.getMessage());
        }
    }

    public void dealCard(){
        deck.remove(0);
    }

    public LinkedList<Carts>  handoutCard(){
        try {
            if(deck.isEmpty()){
                throw new IllegalArgumentException("Deck is empty");
            }

            for (int i = 0; i < 2; i++) {
                hand.add(deck.get(0));
                deck.remove(0);
            }
            return hand;
        }catch (IllegalArgumentException e){
            Logger.add(e.getMessage());
            return null;
        }
    }

    public LinkedList<Carts> setHand() {
        hand.add(this.deck.get(0));
        deck.remove(0);
        return hand;
    }

    public void removeHand(){
        hand.clear();
    }

    @Override
    public Stack<Carts> getDeck() {
        return deck;
    }

    public LinkedList<Carts> getHand() {
        return hand;
    }

    public LinkedList<String> getLogger() {
        return Logger;
    }



    @Override
    public String toString() {
        return "Deck{" +
                "deck=" + deck +
                '}';
    }

}
