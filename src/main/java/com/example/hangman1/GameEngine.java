package com.example.hangman1;

import java.util.Vector;

public class GameEngine {
    public void GameEngine (){
        //Word generation
        Wort wort = new Wort();
        char[][] wordToGuess = new char[2][];
        wordToGuess[0] = wort.selectRandomWord();
        wordToGuess[1] = Wort.buildUnderlines(wordToGuess[0]);

        //add function to showcase the Underscores into the text field wort

        //build boolean to show vicotry
        boolean [] visible = new boolean[wordToGuess.length];
        boolean gameOver = false;
        boolean victory = false;

        //build vectors to count false and true letters
        Vector<Character> falseLetters = new Vector();
        Vector<Character> trueLetters = new Vector();

        //Loop to run the game
        while(!gameOver || !victory){
            //get input from INPUT-Class TBD
            char input = Controller.getEin();

            if (Vergleich.vergleich(wordToGuess[0], input)){
                trueLetters.add(input);
                Vector position = Vergleich.position (wordToGuess[0], input);

                visible =  ScreenOutput.visible(visible, position);

                //add build true once it is done

                if (trueLetters.size()== wordToGuess.length){
                    victory = true;
                }

            }

            else {
                falseLetters.add(input);
                //add vector to Textfield falsche Buchstaben
                String falscheBuchstaben = ScreenOutput.buildFalse(falseLetters);

                //add function to increment hangman
                //to be added later

                if(falseLetters.size()>11){
                    gameOver = true;
                }
            }
        }
    }
}
