package org.example.task.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.example.task.service.ArrayCalculator;

import java.util.Arrays;

public class ArrayCalculatorServiceToStream implements ArrayCalculator {

    public static final Logger logger = LogManager.getLogger();
    @Override
    public double calculateAverage(CustomArray customArray) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("empty array");
        }

        double average = Arrays.stream(customArray.getArray())
                .average()
                .orElseThrow(() -> new ArrayException("Array is empty"));

        logger.info("Average value: " + average);
        return average;
    }

    @Override
    public int calculateSum(CustomArray customArray) throws ArrayException {
        if (customArray == null || customArray.getArray().length < 1) {
            throw new ArrayException("empty array");
        }

        int sum = Arrays.stream(customArray.getArray())
                .sum();

        logger.info("Sum of elements: " + sum);
        return sum;
    }

    @Override
    public int calculatePositiveElements(CustomArray customArray) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("empty array");
        }

        long sum = Arrays.stream(customArray.getArray())
                .filter(num -> num > 0)
                .count();

        logger.info("positive elements: " + sum);
        return (int) sum;
    }

    @Override
    public int calculateNegativeElements(CustomArray customArray) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("empty array");
        }

        long sum = Arrays.stream(customArray.getArray())
                .filter(num -> num < 0)
                .count();

        logger.info("negative elements: " + sum);
        return (int) sum;
    }
}
