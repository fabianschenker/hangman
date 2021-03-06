package com.example.hangman1;

import java.util.*;

//Klasse die den Ablauf, das Gewinnen und die Einabe doppelter Buchstaben steuert
public class GameEngine {

    public static String falsch;
    public static String richtig;
    public static int counter;
    public static boolean[] visible;
    public static Vector<Character> falseLetters = new Vector<>();
    //Testen des eingegebenen Buchstabens gegen das gesuchte Wort
    public static void test() {
        char[][] wordToGuess = new char[2][];
        wordToGuess[0] = Controller.random;
        wordToGuess[1] = Controller.underlines;
        Vector<Integer> position;

        visible = new boolean[wordToGuess[0].length];
        char input = Controller.ein;

        if (Vergleich.vergleich(wordToGuess[0], input)) {
            position = Vergleich.position(wordToGuess[0], input);

            ScreenOutput.visible(visible, position);
            richtig = ScreenOutput.buildTrue(wordToGuess, visible);
            for (boolean b : visible) {
                if (b) {
                    counter++;
                }
            }
        } else {
            if (!falsch.contains(Character.toString(input))) {
                Controller.counter++;
                falseLetters.add(input);
                falsch = ScreenOutput.buildFalse(falseLetters);
            }
        }
    }
    //Gibt true aus, falls das Spiel gewonnen wurde
    static boolean gewonnen() {
        return richtig.length() == counter;
    }
    //Überprüfung ob der eingegebene Buchstabe bereits vorhanden ist
    static void doppelt() {
        for (int i = 0; i < richtig.length(); i++) {
            if (richtig.charAt(i) == Controller.ein) {
                counter--;
            }
        }
    }
}