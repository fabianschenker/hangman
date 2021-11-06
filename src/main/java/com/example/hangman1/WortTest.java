package com.example.hangman1;

public class WortTest {

    public static void main(String[] args){

        Wort wort = new Wort();

        String testWort = wort.selectRandomWord();

        System.out.println(testWort);
        System.out.println(wort.printUnderlines(testWort));
    }
}
