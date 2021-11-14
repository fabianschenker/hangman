package com.example.hangman1;

import java.io.File;
import java.io.FileReader;

public class Wort {

    public String[] readWordFile(){
        String[] strArray = null;
        try{
            File file = new File("src/main/java/com/example/hangman1/testdatenbank.txt");
            FileReader fileReader = new FileReader("src/main/java/com/example/hangman1/testdatenbank.txt");

            char[] c = new char[(int) file.length()];
            fileReader.read(c);
            String s = new String(c);
            strArray = s.split("\r\n");

        }catch(Exception e){
            System.err.println("Fehler beim Einlesen der Datei.");
            System.err.println(e.getMessage());
        }
        return strArray;
    }

    public char[] selectRandomWord(){
        String[] s = readWordFile();
        int zufall = (int) (Math.random()*s.length);
        String wortString = s[zufall];

        char[] wortCharArray = new char[wortString.length()];
        for( int i=0; i<wortString.length(); i++){
            wortCharArray[i] = wortString.charAt(i);
        }

        return wortCharArray;
    }

    public char[] buildUnderlines(char[] w){
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
