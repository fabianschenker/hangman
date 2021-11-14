package com.example.hangman1;


import java.util.Objects;
import java.util.Vector;

public class Vergleich {


    public static boolean vergleich(char[] w, char c) {
        int counter = 0;
        for (int i = 0; i < w.length; i++) {
            if (Objects.equals(c, w[i])) {
                counter++;
            }
        }
        if (counter > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static Vector<Integer> position(char[] w, char c) {
        Vector<Integer> position = new Vector<Integer>();
        for (int i = 0; i < w.length; i++) {
            if (Objects.equals(c, w[i])) {
                position.add(i);
            }
        }
        return position;
    }
}

