module org.blackjack.blackjack {
    requires javafx.controls;
    requires javafx.fxml;

    // Exporta los paquetes necesarios
    exports org.blackjack.blackjack;
    exports org.blackjack.blackjack.controller;
    exports org.blackjack.blackjack.components;

    // Abre los paquetes necesarios para JavaFX FXML
    opens org.blackjack.blackjack to javafx.fxml;
    opens org.blackjack.blackjack.controller to javafx.fxml;
    opens org.blackjack.blackjack.components to javafx.fxml;
}