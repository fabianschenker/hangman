package com.example.hangman1;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller {

    //Deklaration der Variablen aus der hangman.fxml Datei
    @FXML
    private TextField meineEingabe;
    @FXML
    private TextField falscheBuchstaben;
    @FXML
    private TextField erratenesWort;
    @FXML
    private Button playAgainButton;
    @FXML
    private Pane startPane;


    //Deklaration von benötigten Variablen
    public static char ein;
    public static int counter;
    private static final Wort wort = new Wort();
    public static char[] random;
    public static char[] underlines;
    private static boolean fertig;
    private static String richtig;
    boolean startProgramm = false; //setzen des StartButton gedrückt auf nicht wahr


    //start und restart des programms
    @FXML
    public void start() {
        makeInvisibleB(playAgainButton);
        makeInvisibleP(startPane);
        counter = 0;
        startProgramm = true;
        random = wort.selectRandomWord();
        underlines = Wort.buildUnderlines(random);
        richtig = new String(underlines);
        erratenesWort.setText(richtig);
        fertig = false;
        setGameEngine();
        resetProgres();
        falscheBuchstaben.clear();
    }

    @FXML
    public void setGameEngine() {
        GameEngine.falseLetters.clear();
        GameEngine.falsch = "";
        GameEngine.counter = 0;
    }


    //Aktion wenn Enter gedrückt wird
    @FXML
    public void readEingabe() {
        System.out.println("Enter gedrückt");
        if (counter < 11 && startProgramm && !fertig) {
            String e = meineEingabe.getText().toUpperCase();
            if(e.equals(String.valueOf(random))){
                GameEngine.counter = richtig.length();
                victory();
                erratenesWort.setText(String.valueOf(random));
            }else if(e.length()==1){
                ein = e.charAt(0);
                aufraeumen();
                eingabeKontrollieren();
                erratenesWort.setText(GameEngine.richtig);
                falscheBuchstaben.setText(GameEngine.falsch);
                progresImage();
                victory();
            }else{
                makeVisibleL(ungueltigeEingabe);
                meineEingabe.clear();
            }
        }
    }

    private void aufraeumen() {
        makeInvisibleL(doppelteEingabe);
        makeInvisibleL(ungueltigeEingabe);
        meineEingabe.clear();
    }

    public void eingabeKontrollieren() {
        if ((int) ein > 64 && (int) ein < 91) {
            doppelteBuchstaben();
            GameEngine.test();
        } else {
            makeVisibleL(ungueltigeEingabe);
        }
    }

    private void doppelteBuchstaben() {
        String userEin = String.valueOf(ein);
        if (String.valueOf(GameEngine.richtig).contains(userEin) ||
                String.valueOf(GameEngine.falsch).contains(userEin)) {
            if (String.valueOf(GameEngine.richtig).contains(userEin)) {
                GameEngine.doppelt();
            }
            makeVisibleL(doppelteEingabe);
        }
    }

    private void victory() {
        fertig = GameEngine.gewonnen();
        if (fertig) {
            makeInvisibleL(ungueltigeEingabe);
            makeInvisibleL(doppelteEingabe);
            makeVisibleL(gewonnen);
            makeVisibleB(playAgainButton);
        }
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
    private Pane hangman11;
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
    }
    private void makeVisibleC(Circle c) {
        c.visibleProperty().set(true);
    }
    private void makeVisibleL(Label l) {
        l.visibleProperty().set(true);
    }
    private void makeVisibleB(Button b) {
        b.visibleProperty().set(true);
    }
    private void makeVisibleP(Pane p) {
        p.visibleProperty().set(true);
    }
    private void makeInvisibleR(Rectangle r) {
        r.visibleProperty().set(false);
    }
    private void makeInvisibleC(Circle c) {
        c.visibleProperty().set(false);
    }
    private void makeInvisibleL(Label l) {
        l.visibleProperty().set(false);
    }
    private void makeInvisibleB(Button b) {
        b.visibleProperty().set(false);
    }
    private void makeInvisibleP(Pane p) {
        p.visibleProperty().set(false);
    }

    //Updaten der Hangmanfigur, abhängig vom counter
    private void progresImage() {
        if (counter == 1) {
            makeVisibleR(hangman1);
        } else if (counter == 2) {
            makeVisibleR(hangman2);
        } else if (counter == 3) {
            makeVisibleR(hangman3);
        } else if (counter == 4) {
            makeVisibleR(hangman4);
        } else if (counter == 5) {
            makeVisibleR(hangman5);
        } else if (counter == 6) {
            makeVisibleC(hangman6);
        } else if (counter == 7) {
            makeVisibleR(hangman7);
        } else if (counter == 8) {
            makeVisibleR(hangman8);
        } else if (counter == 9) {
            makeVisibleR(hangman9);
        } else if (counter == 10) {
            makeVisibleR(hangman10);
        } else if (counter == 11) {
            makeVisibleP(hangman11);
            makeVisibleL(verloren);
            makeVisibleB(playAgainButton);
            erratenesWort.setText(String.valueOf(random));
        }
    }

    //Zurücksetzen des Fensters
    private void resetProgres() {
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
        makeInvisibleP(hangman11);
        makeInvisibleL(verloren);
        makeInvisibleL(gewonnen);
        GameEngine.counter = 0;
        GameEngine.falsch = "";
        GameEngine.richtig = richtig;
    }

    //Menu Fenster um die Hilfen anzuzeigen
    public void showHelp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Du brauchst Hilfe?");
        alert.setHeaderText("Hier gibt's Hilfe!");
        alert.setContentText("""
                Versuche häufige Buchstaben als erstes einzugeben. Warum nicht mit den Buchstaben des eigenen Namens anfangen?

                Als Sonderzeichen gelten alle Zeichen ausser a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z in Gross- wie Kleinschreibung. ä,ö und ü werden durch ae, oe und ue ersetzt.""");

        alert.showAndWait();
    }
    //Menu Fenster um die Regeln anzuzeigen
    public void showRules() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Regeln");
        alert.setHeaderText("Die Spielregeln:");
        alert.setContentText("""
                1. Der Spieler darf alle 26 Buchstaben des Standart-Alphabets eingeben. Gross- und Kleinschreibung ist dabei irrelevant.

                2. Ein falscher Buchstabe zeichnet einen Teil der Hangman-Figur.

                3. Versuchen Sie, das Wort zu erraten,bevor die Hangman-Figur fertig ist.

                4. Sonderzeichen werden nicht akzeptiert.
                
                5. Jeweils nur ein Buchstabe pro Versuch, ausser man kennt das Lösungswort.

                """);

        alert.showAndWait();
    }
    //Menu Option um die Applikation zu schliessen
    public void closeApp() {
        Platform.exit();
    }
    //Startet das Menu zur Worteingabe
    public void onWortEingabeClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("worteingabe.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage eingabeStage = new Stage();
            eingabeStage.initModality(Modality.WINDOW_MODAL);
            eingabeStage.initStyle(StageStyle.DECORATED);
            eingabeStage.setTitle("Worteingabe");
            eingabeStage.setScene(new Scene(root1));
            eingabeStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}