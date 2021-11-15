package com.example.hangman1;
import java.util.*;
public class ScreenOutput {

    public static String [] buildHidden(int wordLength){
        String [] hiddenWord = new String [wordLength];
        for(int i = 0; i < wordLength; i++){
            hiddenWord [i] = "_";
        }
        return hiddenWord;
    }

    public static String buildFalse(Vector<Character> falseVector) {
        return falseVector.toString();
    }

    public static boolean [] visible (boolean [] visible, Vector<Integer> position){
        for (int i = 0; i<position.size(); i++){
            visible[position.get(i)] = true;
        }
        return visible;

    }


    public static String buildTrue(char[] w, Character c, Vector<Integer> position, StringBuilder str) {
        char [] wordDisplay = new char[w.length];
        for (int i = 0; i < position.size(); i++) {
            wordDisplay[position.get(i)] = c;
        }

        for (int i = 0; i < wordDisplay.length; i++){
            str.append(wordDisplay[i]);
        }

        return str.toString();
    }

}