package org.blackjack.blackjack.components;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class VBoxController {

    @FXML
    private Label label;

    @FXML
    private Button button1;

    @FXML
    private Button button2;


    @FXML
    public  void initialize() {
        System.out.println("Initializing VBoxController");
        label.getText();
        System.out.println("Label: " + label.getText());
        label.setText("VBoxController");
    }
}

