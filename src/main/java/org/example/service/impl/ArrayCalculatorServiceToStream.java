package org.example.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.CustomArray;
import org.example.exception.ArrayException;
import org.example.service.ArrayCalculator;

import java.util.Arrays;

public class ArrayCalculatorServiceToStream implements ArrayCalculator {

    public static final Logger logger = LogManager.getLogger(ArrayCalculatorServiceToStream.class);
    @Override
    public float calculateAverage(CustomArray customArray) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("empty array");
        }

        float average = (float) Arrays.stream(customArray.getArray())
                .average()
                .orElse(0);

        logger.info("Average value: " + average);
        return average;
    }

    @Override
    public int calculateSum(CustomArray customArray) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("empty array");
        }

        int sum = Arrays.stream(customArray.getArray())
                .sum();

        logger.info("Sum of elements: " + sum);
        return sum;
    }

    @Override
    public int calculatePositiveElements(CustomArray customArray) throws ArrayException {
        return 0;
    }

    @Override
    public int calculateNegativeElements(CustomArray customArray) throws ArrayException {
        return 0;
    }
}
