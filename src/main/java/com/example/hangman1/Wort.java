package com.example.hangman1;

import java.io.File;
import java.io.FileReader;

public class Wort {

    public String[] readWordFile(){
        String[] strArray = null;
        try{
            File file = new File("src/main/java/com/example/hangman1/wortdatenbank.txt");
            FileReader fileReader = new FileReader("src/main/java/com/example/hangman1/wortdatenbank.txt");
            //Einlesen der Datei, Speicherung in einem Array aus Strings
            char[] c = new char[(int) file.length()];
            String s = new String(c);
            strArray = s.split("\r\n");

        }catch(Exception e){
            System.err.println("Fehler beim Einlesen der Datei.");
            System.err.println(e.getMessage());
        }
        return strArray;
    }

    public char[] selectRandomWord(){
        //Methode zur Auswahl eines zufälligen Worts aus "strArray" von readWordFile
        String[] s = readWordFile();
        int zufall = (int) (Math.random()*(s.length-1));
        String wortString = s[zufall];
        //Speicherung des zufällig ausgewählten Worts in einem char-Array
        char[] wortCharArray = new char[wortString.length()];
        for( int i=0; i<wortString.length(); i++){
            wortCharArray[i] = wortString.charAt(i);
        }

        return wortCharArray;
    }

    public static char[] buildUnderlines(char[] w){
        //Methode zur Erstellung der Underlines um die Länge des Worts anzuzeigen
        char[] underline = new char[w.length];
        for (int i=0; i<w.length; i++){
            underline[i] = '_';
        }
        return underline;
    }

    public void printWord(char[] c){
        String wordStr = new String(c);
        System.out.println(wordStr);
    }


    public void printUnterline(char[] c){
        String unterlineStr = new String(c);
        System.out.println(unterlineStr);
    }
}
