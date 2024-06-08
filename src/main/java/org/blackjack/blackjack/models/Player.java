package org.blackjack.blackjack.models;

import java.util.*;
import org.blackjack.blackjack.models.interfac.IPlayer;

public class Player implements IPlayer{
    private String name;
    protected LinkedList<Carts> hand  = new LinkedList<>();
    private final List<Integer> playsBalance = new ArrayList<>();
    private int money ;
    private Stack<Integer> handSum = new Stack<>();

    public Player(String name) {
        this.name = name;
        playsBalance.add(2000);
        money = playsBalance.stream().mapToInt(Integer::intValue).sum();
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public List<Integer> getBalance() {
        return playsBalance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        playsBalance.add(money);
        this.money = playsBalance.stream().mapToInt(Integer::intValue).sum();
    }

    public LinkedList<Carts> startHand() {
        return hand;
    }

    public void removeHandSum() {
        handSum.clear();
    }

    public LinkedList<Carts> setHand(Carts carts) {
        hand.add(carts);
        return hand;
    }

    public LinkedList<Carts> getHand() {
        return hand;
    }

    public void removeBalance(int balance) {
        playsBalance.add(-balance);
        this.money = playsBalance.stream().mapToInt(Integer::intValue).sum();

    }

    public int getSumHand() {
        List<Integer> handSum = new ArrayList<>();
        sumHand(handSum);
        int totalSum = handSum.stream().mapToInt(Integer::intValue).sum();
        return totalSum;
    }

    private void sumHand(List<Integer> handSum){
        for (Carts cart : hand) {
            if (cart.getCartId() == 1) {
                int potentialSum = handSum.stream().mapToInt(Integer::intValue).sum() + 11;
                if (potentialSum <= 21) {
                    handSum.add(11);
                } else {
                    handSum.add(1);
                }
            } else if (cart.getCartId() > 10) {
                handSum.add(10);
            } else {
                handSum.add(cart.getCartId());
            }
        }
    }

    public void setAllSumHand(int number) {
        handSum.clear();
        handSum.add(number);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + money +
                ", balance=" + playsBalance +
                '}';
    }

    @Override
    public void removeHand() {

    }
}
