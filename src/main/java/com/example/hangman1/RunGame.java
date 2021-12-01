package com.example.hangman1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URISyntaxException;

//Main Klasse
public class RunGame extends Application {
    @Override
    public void start(Stage mainStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RunGame.class.getResource("hangman.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 860);
        Image icon = null;
        try {
            icon = new Image(RunGame.class.getResource("icon.jpg").toURI().toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        mainStage.getIcons().add(icon);
        mainStage.setTitle("Hangman");
        mainStage.setScene(scene);
        mainStage.show();

        //Schliesst alle Fenster wenn mainStage geschlossen wird
        mainStage.setOnCloseRequest(e -> Platform.exit());
    }

    public static void main(String[] args) {
        launch();
    }
}