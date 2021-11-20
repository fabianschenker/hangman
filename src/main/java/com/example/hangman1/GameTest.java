package com.example.hangman1;


import java.util.*;

import static javafx.application.Platform.exit;

public class GameTest {


    public static void main(String[] args) {
        Wort wort = new Wort();
        char[][] wordToGuess = new char[2][];
        wordToGuess[0] = wort.selectRandomWord();
        wordToGuess[1] = Wort.buildUnderlines(wordToGuess[0]);
        System.out.println(wordToGuess[0]);
        System.out.println(wordToGuess[1]);

        Vector <Integer> position;
        Vector<Character> falseLetters = new Vector();
        String trueLetters;

        //build boolean to show vicotry
        boolean [] visible = new boolean[wordToGuess[0].length];
        boolean gameOver = false;
        boolean victory = false;
        char input;
        //Loop to run the game
        while(!gameOver && !victory){
            //get input from INPUT-Class TBD
            Scanner inputKey = new Scanner(System.in);
            String key = inputKey.next();
            input = key.charAt(0);

            System.out.println(input);

            if (Vergleich.vergleich(wordToGuess[0], input)){
                position = Vergleich.position (wordToGuess[0], input);

                visible =  ScreenOutput.visible(visible, position);
                trueLetters = ScreenOutput.buildTrue(wordToGuess, visible);
                System.out.println(trueLetters);

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
                if (victory){
                    System.out.println("Victory!");
                    exit();
                }

            }

            else {
                falseLetters.add(input);
                //add vector to Textfield falsche Buchstaben
                System.out.println(ScreenOutput.buildFalse(falseLetters));

                System.out.println(falseLetters.size());
                //add function to increment hangman
                //to be added later

                if(falseLetters.size()==11){
                    gameOver = true;
                    System.out.println("Game Over!");
                    exit();
                }
            }
        }
    }
}