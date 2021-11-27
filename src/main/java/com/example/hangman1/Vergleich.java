package com.example.hangman1;

import java.util.Objects;
import java.util.Vector;

public class Vergleich {


    public static boolean vergleich(char[] w, char c) {
        int counter = 0;
        for (char test : w) {
            if (Objects.equals(c, test)) counter++;
        }
        return counter > 0;
    }

    public static Vector<Integer> position(char[] w, char c) {
        Vector<Integer> position = new Vector<>();
        //classical for-loop because of use of the index
        for (int i = 0; i < w.length; i++) {
            if (Objects.equals(c, w[i])) position.add(i);
        }
        return position;
    }
}

