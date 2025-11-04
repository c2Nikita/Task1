package org.example.task.validator.impl;

import org.example.task.validator.LineValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineValidatorImplTest {

    private LineValidator validator;

    @BeforeEach
    void setUp() {
        validator = new LineValidatorImpl();
    }

    @Test
    void testValidLine() {
        String validLine1 = "1, 2, 3, 4";
        String validLine2 = "-5;10;-15";

        assertAll(
                () -> assertTrue(validator.isLineFromFileValid(validLine1)),
                () -> assertTrue(validator.isLineFromFileValid(validLine2))
        );
    }

    @Test
    void testInvalidLine() {
        String invalidLine1 = "abc, 123";
        String invalidLine2 = "1,,2,3";
        String invalidLine3 = "1, 2, 3, ";
        String invalidLine4 = "";
        String invalidLine5 = null;

        assertAll(
                () -> assertFalse(validator.isLineFromFileValid(invalidLine1)),
                () -> assertFalse(validator.isLineFromFileValid(invalidLine2)),
                () -> assertFalse(validator.isLineFromFileValid(invalidLine3)),
                () -> assertFalse(validator.isLineFromFileValid(invalidLine4)),
                () -> assertFalse(validator.isLineFromFileValid(invalidLine5))
        );
    }

    @Test
    void testSingleNumber() {
        assertAll(
                () -> assertTrue(validator.isLineFromFileValid("42")),
                () -> assertTrue(validator.isLineFromFileValid("-7"))
        );
    }

    @Test
    void testSpacesAroundNumbers() {
        assertAll(
                () -> assertTrue(validator.isLineFromFileValid("   1 ,  2 ,   3  ")),
                () -> assertTrue(validator.isLineFromFileValid(" -1 ; -2 ; -3 "))
        );
    }
}
