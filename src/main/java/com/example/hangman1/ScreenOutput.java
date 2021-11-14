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

    public static String buildFalse(Vector<String> falseVector) {
        return falseVector.toString();
    }

    public static String buildTrue(String[] w,String c, Vector<Integer> position, StringBuilder str) {
        String [] wordDisplay= new String[w.length];
        for (int i = 0; i < position.size(); i++) {
            wordDisplay[position.get(i)] = c;
        }

        for (int i = 0; i < wordDisplay.length; i++){
            str.append(wordDisplay[i]);
        }

       return str.toString();
    }


}