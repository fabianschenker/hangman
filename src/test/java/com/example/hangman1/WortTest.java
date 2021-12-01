package com.example.hangman1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//Testklasse für die Klasse Wort
class WortTest {

    @Test
    //teste ob alle Einträge des Arrays Underscores sind und ob Array Underlines und Wort gleich lang sind
    void buildUnderlines() {
        char[] testchar = "JAVALERNENISTSCHWER".toCharArray();
        char[] underscores = Wort.buildUnderlines(testchar);
        assertEquals(testchar.length, underscores.length, "Anzahl chars != Anzahl Underscores");


        for (int i = 0; i < testchar.length; i++) {
            assertEquals('_', underscores[i], "Nicht alle chars = Underscores");
        }
    }
}