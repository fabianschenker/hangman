package com.example.hangman1;

import java.util.Scanner;

public class Eingabe {

    Scanner scanner = new Scanner(System.in);

    private char eingabe;

    public Eingabe(){
        eingabe = scanner.next().charAt(0);

        //Umwandlung zu Grossbuchstaben
        eingabe = grossBuchstaben(eingabe);
    }

    public char grossBuchstaben(char e){
        int eingabeAscii = (int)e;
        if (eingabeAscii > 96 && eingabeAscii < 123){
            e = (char) (eingabeAscii - 32);
        }
        return e;
    }

    public char getEingabe() {
        return eingabe;
    }
}
