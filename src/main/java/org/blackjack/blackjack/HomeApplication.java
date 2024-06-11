package org.blackjack.blackjack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;

public class HomeApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {

            URL resource = getClass().getResource("home-view.fxml");
            if (resource == null) {
                throw new IOException("Resource not found: /home-view.fxml");
            }
            Parent root = FXMLLoader.load(resource);
            primaryStage.setTitle("Blackjack Game");
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
