package com.example.hangman1;

public class CharTest {
    protected char g;
    protected String wordTrue;
    protected String wordFalse;
    public CharTest(char c, String t, String f) {
       g = c;
       wordTrue = t;
       wordFalse = f;

    }


    public Character getG() {
        return g;
    }

    public String getWordTrue() {
        return wordTrue;
    }

    public String getWordFalse() {
        return wordFalse;
    }

    public void setG(char g) {
        this.g = g;
    }

    public void setWordTrue(String wordTrue) {
        this.wordTrue = wordTrue;
    }

    public void setWordFalse(String wordFalse) {
        this.wordFalse = wordFalse;
    }
}
