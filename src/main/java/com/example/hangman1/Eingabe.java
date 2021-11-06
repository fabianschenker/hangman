package com.example.hangman1;

import java.util.Scanner;

public class Eingabe {

    Scanner scanner = new Scanner(System.in);

    private char eingabe;

    public Eingabe(){
        eingabe = scanner.next().charAt(0);
    }
}
