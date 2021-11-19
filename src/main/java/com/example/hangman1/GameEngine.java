package com.example.hangman1;


import java.util.*;

import static javafx.application.Platform.exit;

public class GameEngine {

    public static String falsch = "";
    public static String richtig = Controller.getRichtig();
    public static int counter = 0;
    public static boolean [] visible;

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

        visible = new boolean[wordToGuess[0].length];
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

                for (int i = 0; i< visible.length; i++){
                    if(visible[i]){
                        counter++;
                    }
                }
            }

            else {
                falseLetters.add(input);
                falsch += ScreenOutput.buildFalse(falseLetters) + " ";
               System.out.println(ScreenOutput.buildFalse(falseLetters));
            }
            System.out.println(counter);

    }
    static boolean gewonnen(){

        boolean rueckgabe = false;
        if(richtig.length()==counter){
            rueckgabe = true;
        }
        return rueckgabe;
    }
    static void doppelt(){
        for (int i = 0; i < richtig.length(); i++){
            if (richtig.charAt(i) == Controller.getEin()){
                counter--;
            }
        }
    }
}