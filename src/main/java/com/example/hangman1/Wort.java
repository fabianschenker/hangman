package com.example.hangman1;

import java.io.File;
import java.io.FileReader;
import java.util.Random;

public class Wort {

    public String[] readWordFile(){
        String[] strArray = null;
        try{
            File file = new File("src/main/java/com/example/hangman1/testdatenbank.txt");
            FileReader fileReader = new FileReader("src/main/java/com/example/hangman1/testdatenbank.txt");

            char[] c = new char[(int) file.length()];
            fileReader.read(c);
            String s = new String(c);
            strArray = s.split("\n");

        }catch(Exception e){
            System.err.println("Fehler beim Einlesen der Datei.");
            System.err.println(e.getMessage());
        }
        return strArray;
    }

    public String selectRandomWord(){
        String[] s = readWordFile();
        int zufall = (int) (Math.random()*s.length);
        String wort = s[zufall];
        return wort;
    }

    public String printUnderlines(String w){
        String underline = "";
        for (int i=0; i<w.length(); i++){
            underline += "_";
        }
        return underline;
    }
}
