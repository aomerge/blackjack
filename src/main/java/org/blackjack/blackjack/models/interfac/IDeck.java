package org.blackjack.blackjack.models.interfac;

import org.blackjack.blackjack.models.Carts;


import java.util.LinkedList;
import java.util.List;

public interface IDeck {
    List<Carts> getDeck();
    LinkedList<Carts>  handoutCard();
    void removeHand();
    LinkedList<Carts> getHand();
    LinkedList<String> getLogger();
    LinkedList<Carts> setHand();
    //int getSumHand();
}
