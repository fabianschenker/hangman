package com.example.hangman1;
import java.util.*;
public class ScreenOutput {

    public static String buildFalse (Vector<Character> falseVector) {
        StringBuilder f = new StringBuilder();

        for (int i = 0; i< falseVector.size(); i++){
            f.append(falseVector.get(i));
            if(falseVector.size()>1) if (i < falseVector.size() - 1) f.append(" ");
        }
        return f.toString();
    }

    public static boolean [] visible (boolean [] visible, Vector<Integer> position){
        for (int i = 0; i<position.size(); i++){
            visible[position.get(i)] = true;
        }
        return visible;
    }

    public static String buildTrue(char[][] wordToGuess, boolean[] visible) {

        for (int i = 0; i < wordToGuess[0].length;i++){
            if(visible[i]){
                wordToGuess[1][i] = wordToGuess[0][i];
            }
        }
        return new String(wordToGuess[1]);
    }
}