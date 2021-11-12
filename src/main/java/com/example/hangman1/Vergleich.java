package com.example.hangman1;


import java.util.Vector;

public class Vergleich{


    public static boolean vergleich(String [] w, String c) {
        int counter = 0;
        for (int i = 0; i < w.length; i++) {
            if (c.equals(w[i])) {
                counter++;
            }
        }
       if (counter>0){
           return true;
       }
       else{
           return false;
       }
    }

    public static Vector<Integer> position (String [] w, String c){
        Vector<Integer> position = new Vector<Integer>();
        for (int i = 0; i < w.length; i++) {
            if (c.equals(w[i])) {
                position.add(i);

            }
        }
        return position;
    }
}

