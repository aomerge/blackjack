module org.blackjack.blackjack {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.blackjack.blackjack to javafx.fxml;
    exports org.blackjack.blackjack;
    exports org.blackjack.blackjack.controller;
    opens org.blackjack.blackjack.controller to javafx.fxml;
    exports org.blackjack.blackjack.controller.game;
    opens org.blackjack.blackjack.controller.game to javafx.fxml;
    exports org.blackjack.blackjack.models;
    opens org.blackjack.blackjack.models to javafx.fxml;
}