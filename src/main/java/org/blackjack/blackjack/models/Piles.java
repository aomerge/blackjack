package org.blackjack.blackjack.models;

import org.blackjack.blackjack.models.interfac.IPiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Piles implements IPiles {

    List<String> Logger = new ArrayList<>();

    Stack<Integer> pile = new Stack<>();
    private int bet = 0;
    private int call = 0;
    private int raise = 0;
    private int AllIn = 0;

    public Piles() {}

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        if (bet > 0  && pile.isEmpty()) {
            pile.add(bet);
        }
        this.bet = pile.get(0);
    }

    public int getCall() {
        Integer piles = pile.get(pile.size() - 1);
        return piles;
    }

    public void setCall() {
        this.call = pile.get(pile.size() - 1);
        pile.add(call);
    }

    public Stack<Integer> getPile() {
        return pile;
    }

    public int getRaise(){
        return raise;
    }

    public void setRaise(int number){
        try{
            if(  number < pile.get(pile.size() - 1) ) {
                throw new Exception("El numero es manor al numero de apuesta");
            }
            pile.add(number);
            raise = number;
        } catch (Exception e) {
            Logger.add(e.getMessage());
        }
    }

    public int getAllIn(){
        return AllIn;
    }

    @Override
    public void  setAllIn(int number){
        setRaise(number);
        AllIn = pile.get(pile.size() - 1);
    }

    @Override
    public int getSumPile() {
        return pile.stream().mapToInt(Integer::intValue).sum();
    }

    public List<String> getLogger() {
        return this.Logger;
    }

    @Override
    public String toString() {
        return "Piles{" +
                "pile=" + pile +
                ", bet=" + bet +
                ", call=" + call +
                ", raise=" + raise +
                ", AllIn=" + AllIn +
                '}';
    }
}
