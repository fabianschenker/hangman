package com.example.hangman1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Vector;

public class Controller {

    //Deklaration der Variablen aus der hangman.fxml Datei
    public Button playAgainKnopfMenu;
    public Button helpKnopfMenu;
    public Button rulesKnopfMenu;
    public Button closeKnopfMenu;
    public Button closeKnopf;
    Stage primaryStage;
    @FXML
    private TextField meineEingabe;
    @FXML
    private TextField falscheBuchstaben;
    @FXML
    private Button playAgainKnopf;
    @FXML
    private Button StartButton;
    @FXML
    private TextField erratenesWort;
    @FXML
    private Label WelcomeLable;


    //Deklaration von benötigten Variablen
    private static char ein;
    private static int counter;
    private static Wort wort = new Wort();
    private static char[] random;
    private static char[] underlines;
    private static boolean fertig;
    private static String richtig;
    boolean startProgramm = false; //setzen des StartButton gedrückt auf nicht wahr


    public void init(Stage primaryStage, Scene mainScene) {
        this.primaryStage = primaryStage;
    }


    //start und restart des programms
    @FXML
    public void start(ActionEvent actionEvent){
        counter = 0;
        startProgramm = true;
        random = wort.selectRandomWord();
        underlines = wort.buildUnderlines(random);
        richtig = new String(underlines);
        erratenesWort.setText(richtig);
        meineEingabe.setText("");
        makeInvisibleP();
        fertig = false;
    }
    @FXML
    public void restart(ActionEvent actionEvent) {
        start(actionEvent);
        resetProgres();
        falscheBuchstaben.setText("");
        GameEngine.falsch = "";
        GameEngine.counter = 0;
        GameEngine.falseLetters = new Vector();
    }


    //Aktion wenn Enter gedrückt wird
    @FXML
    public void readEingabe(ActionEvent actionEvent) {
        System.out.println("Enter gedrückt");
        if (counter < 11 && startProgramm && !fertig) {
            String e = meineEingabe.getText();
            e = e.toUpperCase();
            ein = e.charAt(0);
            eingabeKontrollieren(ein);
            meineEingabe.setText("");
            progresImage();
            erratenesWort.setText(GameEngine.richtig);
            falscheBuchstaben.setText(GameEngine.falsch);
            victory();
            System.out.println("counter: " + counter);
        }
    }

    private void victory() {
        fertig = GameEngine.gewonnen();
        if (fertig){
            makeVisibleL(gewonnen);
            makeVisibleB(playAgainKnopf);
        }
    }

    public void eingabeKontrollieren(char e){
        if ((int)e > 64 && (int)e < 91){
            makeInvisibleL(ungueltigeEingabe);
            doppelteBuchstaben();
            GameEngine.test();
        }
        else {
            makeVisibleL(ungueltigeEingabe);
            makeInvisibleL(doppelteEingabe);
        }
    }

   private void doppelteBuchstaben() {
        String userEin = String.valueOf(ein);

        if (String.valueOf(GameEngine.richtig).contains(userEin) ||
                String.valueOf(GameEngine.falsch).contains(userEin)) {
            if (String.valueOf(GameEngine.richtig).contains(userEin)){
            GameEngine.doppelt();}
            makeVisibleL(doppelteEingabe);}
            else {makeInvisibleL(doppelteEingabe);}
        }



    //Varablen für das Updaten der Hangmanfigur
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
    @FXML
    private Label doppelteEingabe;


//Methoden für ein- und ausblenden der verschiedenen Objektarten
    private void makeVisibleR(Rectangle r) {
        r.visibleProperty().set(true);
    }private void makeVisibleC(Circle c) {
        c.visibleProperty().set(true);
    }private void makeVisibleL(Label l) {
        l.visibleProperty().set(true);
    }private void makeVisibleB(Button b) {
        b.visibleProperty().set(true);
    }
    private void makeInvisibleR(Rectangle r) {
        r.visibleProperty().set(false);
    }private void makeInvisibleC(Circle c) {
        c.visibleProperty().set(false);
    }private void makeInvisibleL(Label l) {
        l.visibleProperty().set(false);
    }private void makeInvisibleB(Button b) {
        b.visibleProperty().set(false);
    }private void makeInvisibleP() {
        StartButton.visibleProperty().set(false);
        closeKnopf.visibleProperty().set(false);
        WelcomeLable.visibleProperty().set(false);
    }
    //Updaten der Hangmanfigur, abhängig vom counter
    private void progresImage() {
        if(counter == 1){
            makeVisibleR(hangman1);
        }else if(counter == 2){
            makeVisibleR(hangman2);
        }else if(counter == 3){
            makeVisibleR(hangman3);
        }else if(counter == 4){
            makeVisibleR(hangman4);
        }else if(counter == 5){
            makeVisibleR(hangman5);
        }else if(counter == 6){
            makeVisibleC(hangman6);
        }else if(counter == 7){
            makeVisibleR(hangman7);
        }else if(counter == 8){
            makeVisibleR(hangman8);
        }else if(counter == 9){
            makeVisibleR(hangman9);
        }else if(counter == 10){
            makeVisibleR(hangman10);
        }else if(counter == 11){
            makeVisibleR(hangman11);
            makeVisibleR(hangmanD1);
            makeVisibleR(hangmanD2);
            makeVisibleR(hangmanD3);
            makeVisibleR(hangmanD4);
            makeVisibleL(verloren);
            makeVisibleB(playAgainKnopf);
        }
    }

    //Zurücksetzen des Fensters
    private void resetProgres() {
        counter = 0;
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
        makeInvisibleB(playAgainKnopf);
        GameEngine.counter = 0;
        GameEngine.falsch = "";
        GameEngine.richtig = richtig;
    }

    //Getter
    public static char getEin() {
        return ein;
    }

    public static char[] getRandom() {
        return random;
    }

    public static char[] getUnderlines() {
        return underlines;
    }

    public static String getRichtig() {
        return richtig;
    }

    //Setter
    public static void setCounter() {
        counter++;
    }


    public void showHelp(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help is here");
        alert.setHeaderText("You need help");
        alert.setContentText("don't contact us");

        alert.showAndWait();
    }

    public void showRules(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Rules");
        alert.setHeaderText("Rules here");
        alert.setContentText("Here are the Rules");

        alert.showAndWait();
    }

    public void closeApp(ActionEvent actionEvent) {
        Platform.exit();
    }

}