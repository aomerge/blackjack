package org.blackjack.blackjack.models.interfac;

import java.util.List;
import java.util.Stack;

public interface IPiles {
    int getBet();
    void setBet(int bet);
    int getCall();
    void setCall();
    Stack<Integer> getPile();
    int getRaise();
    void setRaise(int number);
    List<String> getLogger();
    int getAllIn();
    void setAllIn (int number);
    int getSumPile();
}
