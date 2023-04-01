package main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void calc() {
        assertAll(() -> assertEquals("9", Main.calc("2 + 7")),
                () -> assertEquals("11", Main.calc("2 + 9")),
                () -> assertEquals("2", Main.calc("9 - 7 ")),
                () -> assertEquals("30", Main.calc("3 * 10")),
                () -> assertEquals("3", Main.calc("10 / 3")),
                () -> assertEquals("10", Main.calc("10 / 1")),
                () -> assertEquals("II", Main.calc("I + I")),
                () -> assertEquals("IV", Main.calc("I + III")),
                () -> assertEquals("VII", Main.calc("I + IVII")),
                () -> assertEquals("I", Main.calc("III / II")),
                () -> assertEquals("V", Main.calc("X / II")),
                () -> assertEquals("XX", Main.calc("X * II")),
                () -> assertEquals("-2", Main.calc("8 - 10")),
                () -> assertEquals("9", Main.calc("2 + 7")));


        System.out.println("\t\tExceptions testing");
        Exception thrown = Assertions.assertThrows(Exception.class,
                () -> Main.calc(" + "), "Exception was expected");
        System.out.println("1 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc(" 1 + "), "Exception was expected");
        System.out.println("2 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("1 +  "), "Exception was expected");
        System.out.println("3 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("1  + "), "Exception was expected");
        System.out.println("4 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("1 +"), "Exception was expected");
        System.out.println("5 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("1 + "), "Exception was expected");
        System.out.println("6 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("  + 1"), "Exception was expected");
        System.out.println("7 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("1 + "), "Exception was expected");
        System.out.println("8 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("10 + "), "Exception was expected");
        System.out.println("9 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("1 + 11"), "Exception was expected");
        System.out.println("10 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("-1 + 1"), "Exception was expected");
        System.out.println("11 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("1 + 0"), "Exception was expected");
        System.out.println("12 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("1 + 1.2"), "Exception was expected");
        System.out.println("13 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("1 + I"), "Exception was expected");
        System.out.println("14 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("I + 0"), "Exception was expected");
        System.out.println("15 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("1 + 0"), "Exception was expected");
        System.out.println("16 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("X + x"), "Exception was expected");
        System.out.println("17 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("I + XI"), "Exception was expected");
        System.out.println("18 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("0 + 0"), "Exception was expected");
        System.out.println("19 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("2 - 17"), "Exception was expected");
        System.out.println("20 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("XI + I"), "Exception was expected");
        System.out.println("21 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("I - X"), "Exception was expected");
        System.out.println("22 Passed");
        Assertions.assertThrows(Exception.class,
                () -> Main.calc("I / X"), "Exception was expected");
        System.out.println("23 Passed");

//        Assertions.assertEquals("For input string: \"One\"", thrown.getMessage());
    }
}