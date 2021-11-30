package com.example.hangman1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
//Main Klasse
public class RunGame extends Application {
    @Override
    public void start(Stage mainStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RunGame.class.getResource("hangman.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 860);
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