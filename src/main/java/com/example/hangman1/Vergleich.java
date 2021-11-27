package com.example.hangman1;


import java.util.Objects;
import java.util.Vector;

public class Vergleich {

//Vergleich des eingegebenen Buchstabens mit dem Array, welcher das gesuchte Wort enthält
    public static boolean vergleich(char[] w, char c) {
        int counter = 0;
        for (char value : w) {
            if (Objects.equals(c, value)) {
                counter++;
            }
        }
        return counter > 0;
    }
//Gibt die Position des eingegebenen Buchstabens im gesuchten Wort in einem Vektor zurück
    public static Vector<Integer> position(char[] w, char c) {
        Vector<Integer> position = new Vector<>();
        for (int i = 0; i < w.length; i++) {
            if (Objects.equals(c, w[i])) {
                position.add(i);
            }
        }
        return position;
    }
}

