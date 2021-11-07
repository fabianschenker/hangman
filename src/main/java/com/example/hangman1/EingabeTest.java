package com.example.hangman1;

public class EingabeTest {
    public static void main(String[] args) {

        System.out.println("Eingabe: ");
        Eingabe e = new Eingabe();

        System.out.println("Eingegebenes Zeichen: " + e.getEingabe());
    }
}
