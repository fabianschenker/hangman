package com.example.hangman1;


import java.util.*;

import static javafx.application.Platform.exit;

public class GameEngine {

    public static String falsch = "";
    public static String richtig = Controller.getRichtig();

    public static void test() {
        Wort wort = Controller.getWort();
        char[][] wordToGuess = new char[2][];
        wordToGuess[0] = Controller.getRandom();
        wordToGuess[1] = Controller.getUnderlines();
        System.out.println(wordToGuess[0]);
        System.out.println(wordToGuess[1]);

        Vector <Integer> position;
        Vector<Character> falseLetters = new Vector();
        char [] trueLetters = new char[wordToGuess[0].length];

        boolean [] visible = new boolean[wordToGuess[0].length];
        char input;

            input = Controller.getEin();

            System.out.println(input);

            if (Vergleich.vergleich(wordToGuess[0], input)){
                position = Vergleich.position (wordToGuess[0], input);

                visible =  ScreenOutput.visible(visible, position);
                trueLetters = ScreenOutput.buildTrue(wordToGuess, visible);
                System.out.println(trueLetters);
                richtig = new String(trueLetters);
                Controller.setEnterCounter(-1);

            }

            else {
                falseLetters.add(input);
                falsch += ScreenOutput.buildFalse(falseLetters) + " ";
               System.out.println(ScreenOutput.buildFalse(falseLetters));
            }

    }
    static boolean gewonnen(){
        boolean rueckgabe = false;
        for (int i = 0; i < richtig.length(); i++){
            char at = richtig.charAt(i);

            if (at == '_'){
                rueckgabe = false;
                break;
            }
            else {
                rueckgabe = true;
            }
        }
        return rueckgabe;
    }
}