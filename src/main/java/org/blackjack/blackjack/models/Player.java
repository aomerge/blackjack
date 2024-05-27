package org.blackjack.blackjack.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Player {
    private String name;
    protected LinkedList<Carts> hand  = new LinkedList<>();
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

    public LinkedList<Carts> startHand() {
        return hand;
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

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + money +
                ", balance=" + playsBalance +
                '}';
    }
}
