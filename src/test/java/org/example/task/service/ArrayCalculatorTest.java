package org.example.task.service;

import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public abstract class ArrayCalculatorTest {

    protected abstract ArrayCalculator getCalculator();
    static Stream<Arguments> provideArraysForSum() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 10),
                Arguments.of(new int[]{-5, 10, -3}, 2),
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{0}, 0)
        );
    }

    static Stream<Arguments> provideArraysForAverage() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 2.5),
                Arguments.of(new int[]{-5, 10, -2}, 1),
                Arguments.of(new int[]{0}, 0)
        );
    }

    static Stream<Arguments> provideArraysForPositive() {
        return Stream.of(
                Arguments.of(new int[]{1,-2,3,-4,5}, 3),
                Arguments.of(new int[]{-2,-4,-6,-8}, 0),
                Arguments.of(new int[]{1,2,3}, 3),
                Arguments.of(new int[]{0}, 0)
        );
    }

    static Stream<Arguments> provideArraysForNegative() {
        return Stream.of(
                Arguments.of(new int[]{-2,3,5,7,-1}, 2),
                Arguments.of(new int[]{-2,-3,-2,-47,-1}, 5),
                Arguments.of(new int[]{3,4,5}, 0),
                Arguments.of(new int[]{0}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArraysForSum")
    void calculateSum(int[] input, int expected) throws ArrayException {
        ArrayCalculator arrayCalculator = getCalculator();
        CustomArray customArray = new CustomArray(input);
        int sum = arrayCalculator.calculateSum(customArray);
        assertEquals(expected, sum);
    }

    @Test
    void testConstructorWithNullArray_ThrowsException() {
        ArrayException exception = assertThrows(ArrayException.class, () -> new CustomArray(null));
        assertEquals("Bad array for create", exception.getMessage());
    }

    @ParameterizedTest
    @MethodSource("provideArraysForAverage")
    void calculateAverage(int[] input, double expected) throws ArrayException {
        ArrayCalculator arrayCalculator = getCalculator();
        CustomArray customArray = new CustomArray(input);
        double average = arrayCalculator.calculateAverage(customArray);
        assertEquals(expected, average);
    }

    @ParameterizedTest
    @MethodSource("provideArraysForPositive")
    void calculatePositiveElements(int[] input, int expected) throws ArrayException {
        ArrayCalculator arrayCalculator = getCalculator();
        CustomArray customArray = new CustomArray(input);
        int positives = arrayCalculator.calculatePositiveElements(customArray);
        assertEquals(expected, positives);
    }

    @ParameterizedTest
    @MethodSource("provideArraysForNegative")
    void calculateNegativeElements(int[] input, int expected) throws ArrayException {
        ArrayCalculator arrayCalculator = getCalculator();
        CustomArray customArray = new CustomArray(input);
        int negatives = arrayCalculator.calculateNegativeElements(customArray);
        assertEquals(expected, negatives);
    }
}