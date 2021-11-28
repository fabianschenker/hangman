package com.example.hangman1;
import java.util.*;
public class ScreenOutput {
    //Erstellt aus einem Vektor falscher Buchstaben einen String
    public static String buildFalse (Vector<Character> falseVector) {
        StringBuilder f = new StringBuilder();

        for (int i = 0; i< falseVector.size(); i++){
            f.append(falseVector.get(i));
            if(falseVector.size()>1){
            if(i < falseVector.size()-1){
            f.append(" ");
                }
            }
        }

        return f.toString();
    }
    //Macht die entsprechende Position eines richtig erratenen bBuchstabens sichtbar
    public static boolean [] visible (boolean [] visible, Vector<Integer> position){
        for (int i = 0; i<position.size(); i++){
            visible[position.get(i)] = true;
        }
        return visible;

    }
    //Gibt einen String aus richtig geratenen Buchstaben zurück
    public static String buildTrue(char[][] wordToGuess, boolean[] visible) {

        for (int i = 0; i < wordToGuess[0].length;i++){
            if(visible[i]){
                wordToGuess[1][i] = wordToGuess[0][i];
            }
        }

        return new String(wordToGuess[1]);
    }

}