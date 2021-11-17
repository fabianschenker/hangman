package com.example.hangman1;


import java.util.*;

import static javafx.application.Platform.exit;

public class GameEngine {

    public static String falsch = "";
    public static String richtig = "";
    public static boolean victory;

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

        //build boolean to show vicotry
        boolean [] visible = new boolean[wordToGuess[0].length];
        boolean gameOver = false;
        char input;
        //Loop to run the game

            //get input from INPUT-Class TBD
            input = Controller.getEin();

            System.out.println(input);

            if (Vergleich.vergleich(wordToGuess[0], input)){
                position = Vergleich.position (wordToGuess[0], input);

                visible =  ScreenOutput.visible(visible, position);
                trueLetters = ScreenOutput.buildTrue(wordToGuess, visible);
                System.out.println(trueLetters);
                richtig = new String(trueLetters);
                Controller.setEnterCounter(1);


                //add build true once it is done


                for (int i = 0; i< visible.length; i++){
                    if(visible[i]){
                        victory = true;
                    }
                    else{
                        victory = false;
                        break;
                    }
                }
                Controller.setVictory(victory);
                if (victory){
                    System.out.println("Victory!");
                }

            }

            else {
                falseLetters.add(input);
                //add vector to Textfield falsche Buchstaben
                falsch += ScreenOutput.buildFalse(falseLetters) + " ";
               System.out.println(ScreenOutput.buildFalse(falseLetters));

                System.out.println(falseLetters.size());
                //add function to increment hangman
                //to be added later

                if(falseLetters.size()==11){
                    gameOver = true;
                    System.out.println("Game Over!");
                }
            }

    }
}