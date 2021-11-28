package com.example.hangman1;


import java.util.*;

public class GameEngine {
    //Deklaration der Variablen
    public static String falsch = "";
    public static String richtig = Controller.getRichtig();
    public static int counter = 0;
    public static boolean [] visible;
    public static Vector<Character> falseLetters = new Vector();
    //Zu erratenes Wort wird mit eingegebenem Buchstaben verglichen
    public static void test() {
        char[][] wordToGuess = new char[2][];
        wordToGuess[0] = Controller.getRandom();
        wordToGuess[1] = Controller.getUnderlines();
        System.out.println(wordToGuess[0]);
        System.out.println(wordToGuess[1]);


        Vector <Integer> position;
        String trueLetters;


        visible = new boolean[wordToGuess[0].length];
        char input;

            input = Controller.getEin();

            System.out.println(input);
            //Schlaufe falls der eingegebene Buchstabe im Wort vorhanden ist
            if (Vergleich.vergleich(wordToGuess[0], input)){
                position = Vergleich.position (wordToGuess[0], input);

                ScreenOutput.visible(visible, position);
                trueLetters = ScreenOutput.buildTrue(wordToGuess, visible);
                System.out.println(trueLetters);
                richtig = trueLetters;

                for (boolean b : visible) {
                    if (b) {
                        counter++;
                    }
                }
            }
            //Bei falscher Eingabe wird der Buchstabe dem Vektor mit falschen Buchstaben hinzugefügt
            else {
                if (!falsch.contains(Character.toString(input))){
                    Controller.setCounter();
                    falseLetters.add(input);
                    falsch = ScreenOutput.buildFalse(falseLetters);
                }
               System.out.println(ScreenOutput.buildFalse(falseLetters));
            }
            System.out.println(counter);

    }
    //gibt true zurück, falls die Anzahl richtiger Buchstaben und die Länge des Worts gleich sind
    static boolean gewonnen(){

        return richtig.length() == counter;
    }
    //Anpassen des counters falls der eingegebene Buchstabe bereits im Array richtig eingegebener Buchstaben ist
    //aka, bei doppelter Eingabe
    static void doppelt(){
        for (int i = 0; i < richtig.length(); i++){
            if (richtig.charAt(i) == Controller.getEin()){
                counter--;
            }
        }
    }
}