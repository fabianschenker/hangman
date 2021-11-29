package com.example.hangman1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Vector;

//Testklasse für die Klasse Vergleich
class VergleichTest {

    //Test für die Methode vergleich
    @Test
    void vergleich() {
        //Variable erstellen, die durch vergleich gejagt werden kann
        //JAVALERNENISTSCHWER soll nach H's abgesucht werden
        //returnvalue der Funktion soll also falsch sein
        //also boolean am Anfang erstellen der bereits falsch ist
        //und assertequals drüberhauen
        //Let's go:
        char[] testchar = "JAVATESTENISTSCHWER".toCharArray();
        assertFalse(Vergleich.vergleich(testchar, 'P'), "Testbuchstabe darf es in Testwort nicht geben");
    }

    //Test für die Methode position
    @Test
    void position() {
        //Ein testword erstellen, dieses in einen char stecken, einen Buchstaben auswählen und seine Position im Wort notieren
        //Grösse und Werte des Vektors holen und ints einfügen
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
