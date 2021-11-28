package com.example.hangman1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class VergleichTest {

    @Test
    void vergleich() {
        //create Variable to run through vergleich
        //JAVALERNENISTSCHWER soll nach H's abgesucht werden
        //returnvalue der Funktion soll also falsch sein
        //also boolean am Anfang erstellen der bereits falsch ist
        //und assertequals drüberhauen
        //Let's go:
        char[] testchar = "JAVATESTENISTSCHWER".toCharArray();
        assertFalse(Vergleich.vergleich(testchar, 'P'), "Testbuchstabe darf es in Testwort nicht geben");
    }

    @Test
    void position() {
        //Create a testword to throw in a char, take a letter and note its position in the char
        //get the size and values of the vektor and add tthe ints in it
        //assertEquals mit Soll-Position und selbst eingegebener Position
        char[] testchar = "HUNDSGEMEIN".toCharArray();
        Vector<Integer> testvector = Vergleich.position(testchar, 'E');
        Assertions.assertAll(
                () -> assertEquals(testvector.size(), 2, "Anzahl richtige Buchstaben stimmt nicht"),
                //Integers in the vector "position" should be 6 and 8 =14
                () -> assertEquals(testvector.get(0) + testvector.get(1), 14, "Position nicht richtig erfasst")
        );

    }
}