package com.example.hangman1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class GameEngineTest {

    @Test
    void test1() {
        /*Um die Klasse test() zu testen, erzeugen wir ein randomWort um die Benutzereingabe zu simulieren
        und lassen uns durch die entsprechende Funktion die Underlines anzeigen.
        Wir lassen die Klasse Test() mit den vorherigen Parametern laufen und lassen uns die Positionen der A's darstellen
        Durch AssertTrue sehen wir, ob die GameEngine.test() gut gelaufen ist.
        Die Benutzung von assertAll() sorgt dafür, dass alle Funktionen durchlaufen werden und keine ausgelassen werden kann*/

        Controller.random = "JAVATESTENISTSCHWER".toCharArray();
        Controller.underlines = Wort.buildUnderlines(Controller.random);
        Controller.ein = 'A';
        GameEngine.test();
        assertAll(
                ()-> assertEquals(GameEngine.richtig,"_A_A_______________","GameEngine.richtig nicht korrekt"),
                ()-> assertTrue(GameEngine.visible[1],"Erstes A nicht erkannt"),
                ()-> assertTrue(GameEngine.visible[3],"Zweites A nicht erkannt")

        );
    }

    @Test
    void gewonnen() {
        /*
        Um die Klasse gewonnen() zu testen, stellen wir das richtige Wort durch GameEngine.richtig dar. Der counter hat
        die gleich Länge wie GameEngine.richtig().
        assertTrue, testet die Klasse gewonnen() mit den eingestellten Parametern.
        Wenn der counter == der Länge des Worts entspricht, gibt assertTrue die "String message" aus.
         */
        GameEngine.richtig = "JAVATESTENISTSCHWER";
        GameEngine.counter = GameEngine.richtig.length(); //oder 19 statt GameEngine.richtig.length()
        assertTrue(GameEngine.gewonnen(), "Die Anzahl richtiger Buchstaben stimmt nicht mit der Wortlänge überein");
    }

    @Test
    void doppelt() {
        /*
        Um die Klasse doppelt() zu testen, stellen wir  das richtige Wort durch GameEngine.richtig dar. Der eingegebene
        Buchstabe wird durch Controller.ein dargestellt und der counter ist gleich der Länge des richtiges Wortes.
        Wir lassen die klasse doppelt() mit diesen Parametern laufen.
        Da der Buchstabe T 3 Mal im zu suchenden Wort vorhanden ist, müsste der counter um -3 auf 16 angepasst werden.
        Falls dies nicht klappt, wird die Error-Message geworfen.
        */
            GameEngine.richtig = "JAVATESTENISTSCHWER";
            Controller.ein = 'T';
            GameEngine.counter = GameEngine.richtig.length();
            GameEngine.doppelt();
            assertEquals(GameEngine.counter,16,"Counter wurde nicht angepasst");
    }
}