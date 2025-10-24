package org.example.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.CustomArray;
import org.example.exception.ArrayException;
import org.example.service.ArrayFinder;

public class ArrayFindService implements ArrayFinder {

    public static final Logger logger = LogManager.getLogger(ArrayFindService.class);

    @Override
    public int findMin(CustomArray customArray) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("empty array");
        } else {
            int min = customArray.getArray()[0];
            for (int num : customArray.getArray()) {
                if (num < min) {
                    min = num;
                }
            }
            logger.info("Min element in array is " + min);
            return min;
        }
    }

    @Override
    public int findMax(CustomArray customArray) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("empty array");
        } else {
            int max = customArray.getArray()[0];
            for (int num : customArray.getArray()) {
                if (num > max) {
                    max = num;
                }
            }
            logger.info("Max element in array is " + max);
            return max;
        }
    }

    @Override
    public int findFirstIndexOf(CustomArray customArray, int num) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("empty array");
        } else {
            for (int i = 0; i < customArray.getLenght(); i++) {
                if (customArray.getArray()[i] == num) {
                    logger.info("First index of " + num + " is " + i);
                    return i;
                }
            }
        }
        throw new ArrayException("no such element");
    }

    @Override
    public int findLastIndexOf(CustomArray customArray, int num) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("empty array");
        } else {
            for (int i = customArray.getLenght() - 1; i >= 0; i--) {
                if (customArray.getArray()[i] == num) {
                    logger.info("Last index of " + num + " is " + i);
                    return i;
                }
            }
        }
        throw new ArrayException("no such element");
    }
}
