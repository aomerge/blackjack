module org.blackjack.blackjack {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.blackjack.blackjack to javafx.fxml;
    exports org.blackjack.blackjack;
}