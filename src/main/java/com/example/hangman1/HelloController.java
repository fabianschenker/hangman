package com.example.hangman1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    Stage primaryStage;
    @FXML
    private TextField meineEingabe;
    @FXML
    private Button enter;
    @FXML
    private TextField erraten;

    public void init(Stage primaryStage, Scene mainScene) {
        this.primaryStage = primaryStage;
    }


    @FXML
    public void readEingabe(ActionEvent actionEvent) {
        System.out.println("Enter gedrückt");
        String e = meineEingabe.getText();
        char ein = e.charAt(0);
        ein = grossBuchstaben(ein);
        boolean kontrolle = eingabeKontrollieren(ein);
        meineEingabe.setText("");
    }
    public boolean eingabeKontrollieren(char e){
        int eingabeAscii = (int)e;
        if (eingabeAscii > 64 && eingabeAscii < 91){
            return true;
        }
        else {
            return false;
        }

    }
    public char grossBuchstaben(char e){
        int eingabeAscii = (int)e;
        if (eingabeAscii > 96 && eingabeAscii < 123){
            e = (char) (eingabeAscii - 32);
        }
        return e;
    }

}