package org.example.task.service;

import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.example.task.service.impl.ArrayManipulatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.IntPredicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class ArrayManipulatorTest {

    protected abstract ArrayManipulator getManipulator();
    static Stream<Arguments> provideArraysReplaceByCondition() {
        return Stream.of(
                Arguments.of(
                        new int[]{-2, 4, 6, 0, -5, 8},
                        (IntPredicate) i -> i < 0,
                        5,
                        new int[]{5, 4, 6, 0, 5, 8}),
                Arguments.of(
                        new int[]{-2, 4, 6, 0, -5, 8},
                        (IntPredicate) i -> i > 3,
                        7,
                        new int[]{-2, 7, 7, 0, -5, 7}),
                Arguments.of(
                        new int[]{-2, 4, 6, 0, -5, 8},
                        (IntPredicate) i -> i == 0,
                        120,
                        new int[]{-2, 4, 6, 120, -5, 8}
                )


        );
    }

    @ParameterizedTest
    @MethodSource("provideArraysReplaceByCondition")
    void replaceByCondition(int[] input, IntPredicate condition, int newValue, int[] expected) throws ArrayException {
        ArrayManipulator arrayManipulator = getManipulator();
        CustomArray customArray = new CustomArray(input);
        arrayManipulator.replaceByCondition(customArray, condition, newValue);
        assertArrayEquals(expected, customArray.getArray());
    }
}
