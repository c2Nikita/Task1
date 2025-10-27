package org.example.task.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.example.task.service.ArrayCalculator;

public class ArrayCalculatorService implements ArrayCalculator {

    public static final Logger logger = LogManager.getLogger();

    @Override
    public int calculateSum(CustomArray customArray) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("empty array");
        }

        int result = 0;

        for (int num : customArray.getArray()) {
            result += num;
        }

        logger.info("Sum of elements: " + result);
        return result;

    }

    @Override
    public double calculateAverage(CustomArray customArray) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("empty array");
        }

        double result = (double) calculateSum(customArray) / customArray.getLenght();
        logger.info("Average value: " + result);
        return result;

    }

    @Override
    public int calculatePositiveElements(CustomArray customArray) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("empty array");
        }

        int result = 0;

        for (int num : customArray.getArray()) {
            if (num > 0) {
                result++;
            }
        }

        logger.info("Positive elements: " + result);
        return result;
    }

    @Override
    public int calculateNegativeElements(CustomArray customArray) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("empty array");
        }

        int result = 0;

        for (int num : customArray.getArray()) {
            if (num < 0) {
                result++;
            }
        }

        logger.info("Negative elements: " + result);
        return result;

    }
}
