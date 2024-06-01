package org.blackjack.blackjack.models;

import java.util.*;

public class Player {
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
        hand.forEach(carts ->{
            if (carts.getCartId() == 1 && handSum.stream().mapToInt(Integer::intValue).sum() + 11 <= 21){
                handSum.add(11);
            }
            else if (carts.getCartId() > 10){
                handSum.add(10);
            }
            else {
                handSum.add(carts.getCartId());
            }
        });
        return handSum.stream().mapToInt(Integer::intValue).sum();
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
