package com.example.hangman1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EingabeController {

    private static List<String> stringList = new ArrayList<>();
    private String filePath = "src/main/java/com/example/hangman1/wortdatenbank.txt";

    @FXML
    public TextField eingabefeld;
    @FXML
    public GridPane eingabefenster;

    public void onSaveButtonClicked(ActionEvent actionEvent) {

        if (readEingabefeld()) {
            stringList.add(eingabefeld.getText().toUpperCase(Locale.ROOT));
            try {
                saveToTxt();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean readEingabefeld() {
        String eingabe = eingabefeld.getText().toUpperCase(Locale.ROOT);
        String doppel = "-- doppelter Eintag --";
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
            return true;
        }
    }

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

    public void onBackButtonClicked(ActionEvent actionEvent) {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
