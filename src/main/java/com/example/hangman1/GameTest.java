package com.example.hangman1;


import java.util.*;
public class GameTest {


    public static void main(String[] args) {
        Vector<Character> falseLetters = new Vector();
        Vector<Character> trueLetters = new Vector();
        CharTest test1 = new CharTest('G', "Gen", "Zur");

        String wortFalsch = test1.getWordFalse();
        String wortWahr = test1.getWordTrue();

        char [] c = new char[wortWahr.length()];
        for(int i=0; i<wortWahr.length();i++){
            c[i] = test1.getWordTrue().charAt(i);
        }
        char [] a = new char[wortFalsch.length()];

        for(int i=0; i<wortFalsch.length();i++){
            a[i] = test1.getWordFalse().charAt(i);
        }
        System.out.println(a);
        System.out.println(c);



        /*System.out.println(hidden[0]);
        hidden[0]= hidden[0].replace("_","a");
        System.out.println(hidden[0]);*/
        boolean compare1 = Vergleich.vergleich(c, test1.getG());
        boolean compare2 = Vergleich.vergleich(a, test1.getG());

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

        System.out.println(c[0]+c[1]+c[2]);
        System.out.println(trueLetters);
        System.out.println(a[0]+a[1]+a[2]);
        System.out.println(falseLetters);
        System.out.println(Vergleich.position(c, test1.getG()).get(0));
        System.out.println(ScreenOutput.buildFalse(falseLetters));

        System.out.println(ScreenOutput.buildTrue(c, test1.getG(), Vergleich.position(c, test1.getG()), str));
        System.out.println(ScreenOutput.buildTrue(c, 'e', Vergleich.position(c, 'e'), str));



    }
}