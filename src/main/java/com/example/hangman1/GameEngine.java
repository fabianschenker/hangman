package com.example.hangman1;


import java.util.*;

public class GameEngine {

    public static String falsch = "";
    public static String richtig = Controller.getRichtig();
    public static int counter = 0;
    public static boolean [] visible;
    public static Vector<Character> falseLetters = new Vector();

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

    static boolean gewonnen(){

        return richtig.length() == counter;
    }

    static void doppelt(){
        for (int i = 0; i < richtig.length(); i++){
            if (richtig.charAt(i) == Controller.getEin()){
                counter--;
            }
        }
    }
}