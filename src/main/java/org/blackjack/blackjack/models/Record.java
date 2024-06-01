package org.blackjack.blackjack.models;

import org.blackjack.blackjack.models.interfac.IRecord;
import java.util.ArrayList;
import java.util.List;

public class Record implements IRecord{

    private List<Integer> records = new ArrayList<>();
    private Player playerIn;

    public Record(Player player) {
        this.playerIn = player;
    }

    public List<Integer> getRecord() {
        return records;
    }

    public void setRecord() {
        int Money =  playerIn.getMoney();
        int record  = (int) (Money * .10);
        int record2 = (int) (Money * .20);
        int record3 = (int) (Money * .30);
        int record4 = (int) (Money * .50);
        int AllIn = Money;
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                records.add(record);
            } else if (i == 1) {
                records.add(record2);
            } else if (i == 2) {
                records.add(record3);
            } else if (i == 3) {
                records.add(record4);
            } else {
                records.add(AllIn);
            }
        }

    }
}
