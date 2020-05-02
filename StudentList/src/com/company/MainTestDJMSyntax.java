package com.company;

import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class MainTestDJMSyntax {
    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    /*
    Original
    if(a&&b) It must be a number >= 1 and <=6
    Syntax Test
    if(a||b)    0
    if(a & b)   3&3
    if(a | b)   3|3
    if(a ^ b)   10 A is true, B is false
    if(a)       10
    if(b)       0
     */

    @Test
    void SwitchCasesOr() throws IOException {
        //This covers both OR and if(b)
        assertFalse(main.SwitchCases(0));
    }

    @Test
    void SwitchCasesBitwiseAnd() throws NullPointerException{
        //So Syntax Test says this should return false, BUT This isn't possible since L and R must be the same number.
        assertThrows(NullPointerException.class,()->main.SwitchCases(3&3));
    }

    @Test
    void SwitchCasesBitwiseOr() throws NullPointerException{
        //So Syntax Test says this should return false, BUT This isn't possible since L and R must be the same number.
        assertThrows(NullPointerException.class,()->main.SwitchCases(3|3));
    }

    @Test
    void SwitchCasesXOr() throws IOException {
        //This covers both XOr and if(a)
        assertFalse(main.SwitchCases(10));
    }
}