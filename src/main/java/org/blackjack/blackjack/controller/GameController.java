package org.blackjack.blackjack.controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.blackjack.blackjack.models.Deck;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class GameController {

    @FXML
    private void handleShowVBoxButtonAction() {
        try {
            URL resource  =  getClass().getResource("/org/blackjack/blackjack/components/TableGame.fxml");
            if( resource == null ){
                    throw new IOException("Resource not found: /main/component/VBoxExample.fxml");
            }
            Node vBox = FXMLLoader.load(resource);
            container.getChildren().setAll(vBox);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleResetButtonAction() {
        container.getChildren().clear();
    }

    public void start(Stage primaryStage) {
        //Pane root = new Pane();
        //Scene scene = new Scene(root, 800, 600);

        // Crear las áreas de las cartas del dealer
        Rectangle dealerCard1 = new Rectangle(300, 50, 50, 70);
        dealerCard1.setFill(Color.RED);
        Rectangle dealerCard2 = new Rectangle(360, 50, 50, 70);
        dealerCard2.setFill(Color.GRAY);

        // Crear las áreas de las cartas del jugador
        Rectangle playerCard1 = new Rectangle(300, 400, 50, 70);
        playerCard1.setFill(Color.BLUE);
        Rectangle playerCard2 = new Rectangle(360, 400, 50, 70);
        playerCard2.setFill(Color.RED);

        // Crear el área de apuestas y dinero
        Label moneyLabel = new Label("Money");
        moneyLabel.setLayoutX(650);
        moneyLabel.setLayoutY(20);

        Label betLabel = new Label("Apuesta");
        betLabel.setLayoutX(720);
        betLabel.setLayoutY(20);

        // Crear botones (simulando las acciones del juego)
        Button hitButton = new Button("Hit");
        hitButton.setLayoutX(650);
        hitButton.setLayoutY(500);

        Button standButton = new Button("Stand");
        standButton.setLayoutX(700);
        standButton.setLayoutY(500);

        Button doubleButton = new Button("Double");
        doubleButton.setLayoutX(760);
        doubleButton.setLayoutY(500);

        // Agregar elementos al root
        //root.getChildren().addAll(dealerCard1, dealerCard2, playerCard1, playerCard2, moneyLabel, betLabel, hitButton, standButton, doubleButton);

        //primaryStage.setTitle("Blackjack Game");
        //primaryStage.setScene(scene);
        //primaryStage.show();
    }

    public void initialize() {
        deck = new Deck();
        start(new Stage());
        new Stage();
        image();
    }

    private void image(){
        URL resource = getClass().getResource("/org/blackjack/blackjack/image/cartEnd.png");
        Image image = new Image(resource.toString());
        imageView.setImage(image);

        // Ajustar la imagen al tamaño del ImageView
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);

        // Ajustar el tamaño del ImageView al tamaño de la ventana
        imageView.fitWidthProperty().bind(imageView.getScene().widthProperty());
        imageView.fitHeightProperty().bind(imageView.getScene().heightProperty());

    }

    // Elements

    @FXML
    private ImageView imageView;

    @FXML
    private ListView<String> deckView;

    private Deck deck;

    @FXML
    private AnchorPane container;

    @FXML
    private Pane PaneStart;

    @FXML
    private Button startButton;
}



