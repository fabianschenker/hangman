package com.example.hangman1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class GameEngineTest {

    @Test
    void test1() {
        /*Um die Klasse test() zu testen, wir darstellen den randomWort, der "Underline Wort" der die gleiche länge des
        randomWorts hat und ein Benutzer eingabe (Controller.ein)
        Wir lassen die Klasse Test() mit die vorherige parameter laufen und darstellen die Positionen von die richtige A.
        Durch die AssertTrue, sehen wir, ob die GameEngine.test() gut gelaufen ist.
        Die Benutzung von assertAll() und lambda expression vereinfacht der Test*/

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
        Um die Klasse gewonnen() zu testen, wir darstellen den richtige Wort durch GameEngine.richtig. Der counter hat
        die gleich länge als GameEngine.richtig().
        assertTrue, lass die Klasse gewonnen() mit die eingestellte Parameter. Wenn der counter = der länge der Wort ist,
        gebe assertTrue sein "String message"
         */
        GameEngine.richtig = "JAVATESTENISTSCHWER";
        GameEngine.counter = GameEngine.richtig.length(); //oder 19 statt GameEngine.richtig.length()
        assertTrue(GameEngine.gewonnen(), "GEWONNEN ==> TRUE is returned in gewonnen");
    }

    @Test
    void doppelt() {
        /*
        Um die Klasse doppelt() zu testen, wir darstellen den richtige Wort durch GameEngine.richtig. Die eingegebene
        Buchstabe ist Controller.ein dargestellt und der counter ist gleich die länge des richtiges Wortes.
        Wir lassen die klasse doppelt() mit diese Parameter laufen. Die T wurde schon bei der Parameter actual = 16
        eingestellt, dadurch ist die eingabe 'T' eine doppeleingabe ==> der counter wurde nicht angepasst.
         */
            GameEngine.richtig = "JAVATESTENISTSCHWER";
            Controller.ein = 'T';
            GameEngine.counter = GameEngine.richtig.length();
            GameEngine.doppelt();
            assertEquals(GameEngine.counter,16,"Counter wurde nicht angepasst");
    }
}