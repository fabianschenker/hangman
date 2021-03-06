package com.example.hangman1;

import java.io.File;
import java.io.FileReader;
//Klasse zur Erstellung des zu erratenden Worts
public class Wort {
    //Einlesen der .txt Datei
    public String[] readWordFile(){
        String[] strArray = null;
        try{
            File file = new File(EingabeController.filePath);
            FileReader fileReader = new FileReader(EingabeController.filePath);

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
    //Aussuchen eines random Worts aus der .txt Datei
    public char[] selectRandomWord(){
        String[] s = readWordFile();
        /* Generierung ganzer Zahl zwischen 0 und 99 durch abrunden
            int zufallsZahl1 = (int)(Math.random()*100); */
        int zufall = (int) (Math.random()*(s.length));
        String wortString = s[zufall];

        char[] wortCharArray = new char[wortString.length()];
        for( int i=0; i<wortString.length(); i++){
            wortCharArray[i] = wortString.charAt(i);
        }

        return wortCharArray;
    }
    //Erstellen des char-Arrays mit der richtigen Anzahl Underlines
    public static char[] buildUnderlines(char[] w){
        char[] underline = new char[w.length];
        for (int i=0; i<w.length; i++){
            underline[i] = '_';
        }
        return underline;
    }
}
