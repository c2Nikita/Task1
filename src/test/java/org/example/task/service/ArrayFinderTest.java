package org.example.task.service;

import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class ArrayFinderTest {

    protected abstract ArrayFinder getFinder();
    static Stream<Arguments> provideArrayForFindMin() {
        return Stream.of(
                Arguments.of(new int[]{-2, 4, 6, 0, -5, 8}, -5),
                Arguments.of(new int[]{2, 6, 8, 4, 1, 5}, 1),
                Arguments.of(new int[]{0}, 0)
        );
    }

    static Stream<Arguments> provideArrayForFindMax() {
        return Stream.of(
                Arguments.of(new int[]{-2, 4, 6, 0, -5, 8}, 8),
                Arguments.of(new int[]{2, 6, 12, 4, 1, 5}, 12),
                Arguments.of(new int[]{0}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArrayForFindMin")
    void findMin(int[] input, int expected) throws ArrayException {
        ArrayFinder arrayFinder = getFinder();
        CustomArray customArray = new CustomArray(input);
        int min = arrayFinder.findMin(customArray);
        assertEquals(expected, min);
    }

    @ParameterizedTest
    @MethodSource("provideArrayForFindMax")
    void findMax(int[] input, int expected) throws ArrayException {
        ArrayFinder arrayFinder = getFinder();
        CustomArray customArray = new CustomArray(input);
        int max = arrayFinder.findMax(customArray);
        assertEquals(expected, max);
    }
}
