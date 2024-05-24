package org.blackjack.blackjack.controller;
import org.blackjack.blackjack.models.Deck;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class GameController {
    @FXML
    private ListView<String> deckView;

    private Deck deck;

    public void initialize() {
        deck = new Deck();
        updateDeckView();
    }

    private  void updateDeckView(){
        deckView.getItems().clear();
        deck.getDeck().forEach(card -> deckView.getItems().add(card.toString()));
    }
}
