package com.example.hangman1;

public class WortTest {

    public static void main(String[] args){

        Wort wort = new Wort();

        char[][] testWort = new char[2][];
        testWort[0] = wort.selectRandomWord();
        testWort[1] = wort.buildUnderlines(testWort[0]);

        wort.printWord(testWort[0]);
        wort.printUnterline(testWort[1]);
    }
}
