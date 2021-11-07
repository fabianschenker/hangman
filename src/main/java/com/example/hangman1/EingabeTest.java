package com.example.hangman1;

public class EingabeTest {
    public static void main(String[] args) {

        System.out.println("Eingabe: ");
        Eingabe eingabe = new Eingabe();

        System.out.println("Eingegebenes Zeichen: " + eingabe.getEingabe());
    }
}
