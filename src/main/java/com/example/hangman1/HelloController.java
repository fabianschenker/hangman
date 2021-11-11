package com.example.hangman1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HelloController {

    Stage primaryStage;
    @FXML
    private TextField meineEingabe;
    @FXML
    private Button enter;
    @FXML
    private TextField falscheBuchstaben;
    @FXML
    private Button playAgainKnopf;
    @FXML
    private TextField wort;

    char ein;
    public int enterCounter = 0;



    public void init(Stage primaryStage, Scene mainScene) {
        this.primaryStage = primaryStage;
    }




    @FXML
    public void readEingabe(ActionEvent actionEvent) {
        System.out.println("Enter gedrückt");
        String e = meineEingabe.getText();
        ein = e.charAt(0);
        ein = grossBuchstaben(ein);
        boolean kontrolle = eingabeKontrollieren(ein);
        meineEingabe.setText("");
        enterCounter++;
        progres();
    }



    public boolean eingabeKontrollieren(char e){
        int eingabeAscii = (int)e;
        if (eingabeAscii > 64 && eingabeAscii < 91){
            makeInvisibleL(ungueltigeEingabe);
            return true;
        }
        else {
            makeVisibleL(ungueltigeEingabe);
            enterCounter--;
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

    @FXML
    public void restart(ActionEvent actionEvent) {
        resetProgres();
        wort.setText("");
        falscheBuchstaben.setText("");
    }




    //Updaten der Hangmanfigur
    @FXML
    private Rectangle hangman1;
    @FXML
    private Rectangle hangman2;
    @FXML
    private Rectangle hangman3;
    @FXML
    private Rectangle hangman4;
    @FXML
    private Rectangle hangman5;
    @FXML
    private Circle hangman6;
    @FXML
    private Rectangle hangman7;
    @FXML
    private Rectangle hangman8;
    @FXML
    private Rectangle hangman9;
    @FXML
    private Rectangle hangman10;
    @FXML
    private Rectangle hangman11;
    @FXML
    private Rectangle hangmanD1;
    @FXML
    private Rectangle hangmanD4;
    @FXML
    private Rectangle hangmanD3;
    @FXML
    private Rectangle hangmanD2;

    @FXML
    private Label gewonnen;
    @FXML
    private Label verloren;
    @FXML
    private Label ungueltigeEingabe;


    private void makeVisibleR(Rectangle r) {
        r.visibleProperty().set(true);
    }
    private void makeVisibleC(Circle c) {
        c.visibleProperty().set(true);
    }
    private void makeVisibleL(Label l) {
        l.visibleProperty().set(true);
    }
    private void makeInvisibleR(Rectangle r) {
        r.visibleProperty().set(false);
    }private void makeInvisibleC(Circle c) {
        c.visibleProperty().set(false);
    }private void makeInvisibleL(Label l) {
        l.visibleProperty().set(false);
    }
    private void progres() {
        if(enterCounter == 1){
            makeVisibleR(hangman1);
        }else if(enterCounter == 2){
            makeVisibleR(hangman2);
        }else if(enterCounter == 3){
            makeVisibleR(hangman3);
        }else if(enterCounter == 4){
            makeVisibleR(hangman4);
        }else if(enterCounter == 5){
            makeVisibleR(hangman5);
        }else if(enterCounter == 6){
            makeVisibleC(hangman6);
        }else if(enterCounter == 7){
            makeVisibleR(hangman7);
        }else if(enterCounter == 8){
            makeVisibleR(hangman8);
        }else if(enterCounter == 9){
            makeVisibleR(hangman9);
        }else if(enterCounter == 10){
            makeVisibleR(hangman10);
        }else if(enterCounter == 11){
            makeVisibleR(hangman11);
            makeVisibleR(hangmanD1);
            makeVisibleR(hangmanD2);
            makeVisibleR(hangmanD3);
            makeVisibleR(hangmanD4);
            makeVisibleL(verloren);

        }
    }
    private void resetProgres() {
        enterCounter = 0;
        makeInvisibleR(hangman1);
        makeInvisibleR(hangman2);
        makeInvisibleR(hangman3);
        makeInvisibleR(hangman4);
        makeInvisibleR(hangman5);
        makeInvisibleC(hangman6);
        makeInvisibleR(hangman7);
        makeInvisibleR(hangman8);
        makeInvisibleR(hangman9);
        makeInvisibleR(hangman10);
        makeInvisibleR(hangman11);
        makeInvisibleR(hangmanD1);
        makeInvisibleR(hangmanD2);
        makeInvisibleR(hangmanD3);
        makeInvisibleR(hangmanD4);
        makeInvisibleL(verloren);
        makeInvisibleL(gewonnen);
        makeInvisibleL(ungueltigeEingabe);
    }


}