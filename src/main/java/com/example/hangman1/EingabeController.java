package com.example.hangman1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Diese Klasse dient dem Hinzufügen neuer Worte zur Datenbank
public class EingabeController {

    private static final List<String> stringList = new ArrayList<>();

    // Wird in Klasse Wort verwendet
    public static final String filePath = "C:\\HANGMAN\\wortdatenbank.txt";

    @FXML
    public TextField eingabefeld;
    @FXML
    public GridPane eingabefenster;
    @FXML
    public Label anzahlWoerter;

    //Einlesen der .txt Datei
    public void readList() {
        try {
            File file = new File(filePath);
            FileReader f = new FileReader(filePath);

            char[] c = new char[(int) file.length()];
            f.read(c);
            String s = new String(c);
            String[] result = s.split("\r\n");

            stringList.addAll(Arrays.asList(result));
            System.out.println("File \"" + file.getName() + "\" erfolgreich eingelesen.");
            System.out.println(stringList.size() + " Eintraege generiert.");
            printAnzWoerter();
        } catch (IOException e) {
            System.err.println("Fehler beim Einlesen der Datei.");
            System.err.println(e.getMessage());
        }
    }
    //Schreiben der eingegebenen Wörter in die stringList
    @FXML
    public void onSaveButtonClicked() {
        stringList.clear();
        readList();
        if (readEingabefeld()) {
            stringList.add(eingabefeld.getText().toUpperCase(Locale.ROOT));
            try {
                saveToTxt();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    //Zwischenspeichern eines einzelnen eingegebenen Worts in einem Array
    public boolean readEingabefeld() {
        String eingabe = eingabefeld.getText().toUpperCase(Locale.ROOT);
        String doppel = "-- doppelter Eintrag --";
        String leer = "-- noch nichts eingegeben --";
        String sonder = "-- unerlaubtes Zeichen eingegeben --";

        Pattern p = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(eingabe);
        boolean b = m.find();

        if (stringList.contains(eingabe) || eingabefeld.getText().equals(doppel)) {
            eingabefeld.setText(doppel);
            return false;
        } else if (eingabefeld.getText().equals("") || eingabefeld.getText().equals(leer)) {
            eingabefeld.setText(leer);
            return false;
        } else if (b || eingabefeld.getText().equals(sonder)) {
            eingabefeld.setText(sonder);
            return false;
        } else {
            stringList.add(eingabe);
            System.out.println(stringList.size() + " Eintraege generiert.");
            printAnzWoerter();
            return true;
        }
    }
    // Letztes Wort aus stringList in .txt Datei speichern
    public void saveToTxt() throws IOException {

        try(FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {

            out.println(stringList.get(stringList.size()-1));

        } catch (Exception e){
            System.err.println("Fehler beim Schreiben der Datei.");
            System.err.println(e.getMessage());
        }
    }
    // Schliessen des Fensters, resp. zurück zum Hauptmenü
    @FXML
    public void onBackButtonClicked(ActionEvent actionEvent) {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    // Anzahl eingelesener Wörter auf Fenster ausgeben
    @FXML
    public void printAnzWoerter(){
        anzahlWoerter.setText(stringList.size() + " Wörter");
    }
    // Löscht Inhalt von eingabefeld, wenn darauf gedrückt
    @FXML
    public void onMouseClicked() {
        eingabefeld.clear();
    }
}
