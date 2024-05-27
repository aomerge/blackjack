package org.blackjack.blackjack.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Player extends Deck {
    private String name;
    private final HashSet<Carts> hand = new HashSet<>();
    private int money;
    private final List<Integer> playsBalance = new ArrayList<>();

    public Player(String name) {
        this.name = name;
        playsBalance.add(2000);
        money = playsBalance.get(0);
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

    public HashSet<Carts> startHand() {
        return hand;
    }

    public HashSet<Carts> setHand(int handSize) {
        return hand;
    }

    public HashSet<Carts> getHand() {

        return hand;
    }

    public void removeBalance(int balance) {
        playsBalance.add(-balance);
        this.money = playsBalance.stream().mapToInt(Integer::intValue).sum();

    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + money +
                ", balance=" + playsBalance +
                '}';
    }
}
