package com.example.hangman1;


import java.util.*;

public class GameEngine {
  
    public static String falsch;
    public static String richtig;
    public static int counter;
    public static boolean[] visible;
    public static Vector<Character> falseLetters = new Vector<>();

    public static void test() {
        char[][] wordToGuess = new char[2][];
        wordToGuess[0] = Controller.random;
        wordToGuess[1] = Controller.underlines;
        Vector<Integer> position;
            System.out.println(wordToGuess[0]); //Konsole
            System.out.println(wordToGuess[1]); //Konsole

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
        //Bei falscher Eingabe wird der Buchstabe dem Vektor mit falschen Buchstaben hinzugefügt
        } else {
            if (!falsch.contains(Character.toString(input))) {
                Controller.counter++;
                falseLetters.add(input);
                falsch = ScreenOutput.buildFalse(falseLetters);
            }
        }
    }

    //gibt true zurück, falls die Anzahl richtiger Buchstaben und die Länge des Worts gleich sind
    static boolean gewonnen() {
        return richtig.length() == counter;
    }
    //Anpassen des counters falls der eingegebene Buchstabe bereits im Array richtig eingegebener Buchstaben ist
    //aka, bei doppelter Eingabe
    static void doppelt() {
        for (int i = 0; i < richtig.length(); i++) {
            if (richtig.charAt(i) == Controller.ein) {
                counter--;
            }
        }
    }
}