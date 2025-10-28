package org.example.task.service.impl;

import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.example.task.service.ArrayFinder;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ArrayFindServiceToStream implements ArrayFinder {

    @Override
    public int findMin(CustomArray customArray) throws ArrayException {
        int result = Arrays.stream(customArray.getArray())
                .min()
                .getAsInt();
        return result;
    }

    @Override
    public int findMax(CustomArray customArray) throws ArrayException {
        int result = Arrays.stream(customArray.getArray())
                .max()
                .getAsInt();
        return result;
    }

    @Override
    public OptionalInt findLastIndexOf(CustomArray customArray, int num) throws ArrayException {
        OptionalInt result = IntStream.range(0, customArray.getArray().length)
                .filter(i -> customArray.getArray()[i] == num)
                .max();
        return result;
    }

    @Override
    public OptionalInt findFirstIndexOf(CustomArray customArray, int num) throws ArrayException {
        OptionalInt result = IntStream.range(0, customArray.getArray().length)
                .filter(i -> customArray.getArray()[i] == num)
                .min();
        return result;
    }
}
