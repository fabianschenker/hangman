package com.example.hangman1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Vector;


class GameEngineTest {

    @Test
    void test1() {
        Controller.random = "MALSCHAUENOBDASFUNZT".toCharArray();
        Controller.underlines = Wort.buildUnderlines(Controller.random);
        Controller.ein = 'A';
        GameEngine.test();
        assertAll(
                ()-> assertEquals(GameEngine.richtig,"_A____A______A______","GameEngine.richtig nicht korrekt"),
                ()-> assertTrue(GameEngine.visible[1],"Erstes A nicht erkannt"),
                ()-> assertTrue(GameEngine.visible[6],"Zweites A nicht erkannt"),
                ()-> assertTrue(GameEngine.visible[13],"Drittes A nicht erkannt")
        );
    }

    @Test
    void gewonnen() {
        GameEngine.richtig = "JAVATESTENISTSCHWER";
        GameEngine.counter = GameEngine.richtig.length(); //oder 19 statt GameEngine.richtig.length()
        assertTrue(GameEngine.gewonnen(), "GEWONNEN ==> TRUE is returned in gewonnen, what's activating this class gewonnen");
    }

    @Test
    void doppelt() {
            GameEngine.richtig = "JAVATESTENISTSCHWER";
            Controller.ein = 'T';
            GameEngine.counter = GameEngine.richtig.length();
            GameEngine.doppelt();
            assertEquals(GameEngine.counter,16,"Counter wurde nicht angepasst");
    }
}