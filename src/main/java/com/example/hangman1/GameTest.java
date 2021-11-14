package com.example.hangman1;


import java.util.*;
public class GameTest {


    public static void main(String[] args) {
        Vector<String> falseLetters = new Vector();
        Vector<String> trueLetters = new Vector();
        CharTest test1 = new CharTest("G", "G,e,n", "Z,u,r");



        String [] wortWahr = test1.getWordTrue().split(",");
        String[] wortFalsch = test1.getWordFalse().split(",");



        /*System.out.println(hidden[0]);
        hidden[0]= hidden[0].replace("_","a");
        System.out.println(hidden[0]);*/
        boolean compare1 = Vergleich.vergleich(wortWahr, test1.getG());
        boolean compare2 = Vergleich.vergleich(wortFalsch, test1.getG());

        if (compare1) {
            trueLetters.add(test1.getG());
        } else {
            falseLetters.add(test1.getG());
        }
        if (compare2) {
            trueLetters.add(test1.getG());
        } else {
            falseLetters.add(test1.getG());
        }
        StringBuilder str = new StringBuilder();

        System.out.println(wortWahr[0]+wortWahr[1]+wortWahr[2]);
        System.out.println(trueLetters);
        System.out.println(wortFalsch[0]+wortFalsch[1]+wortFalsch[2]);
        System.out.println(falseLetters);
        System.out.println(Vergleich.position(wortWahr, test1.getG()).get(0));
        System.out.println(ScreenOutput.buildFalse(falseLetters));

        System.out.println(ScreenOutput.buildTrue(wortWahr, test1.getG(), Vergleich.position(wortWahr, test1.getG()), str));
        System.out.println(ScreenOutput.buildTrue(wortWahr, "e", Vergleich.position(wortWahr, "e"), str));



    }
}

