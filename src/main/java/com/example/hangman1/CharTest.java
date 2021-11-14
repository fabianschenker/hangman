package com.example.hangman1;

public class CharTest {
    protected String g;
    protected String wordTrue;
    protected String wordFalse;
    public CharTest(String c, String t, String f) {
       g = c;
       wordTrue = t;
       wordFalse = f;

    }


    public String getG() {
        return g;
    }

    public String getWordTrue() {
        return wordTrue;
    }

    public String getWordFalse() {
        return wordFalse;
    }

    public void setG(String g) {
        this.g = g;
    }

    public void setWordTrue(String wordTrue) {
        this.wordTrue = wordTrue;
    }

    public void setWordFalse(String wordFalse) {
        this.wordFalse = wordFalse;
    }
}
