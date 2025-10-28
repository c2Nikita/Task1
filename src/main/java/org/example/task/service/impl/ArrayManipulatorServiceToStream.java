package org.example.task.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.example.task.service.ArrayManipulator;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class ArrayManipulatorServiceToStream implements ArrayManipulator {
    public static final Logger logger = LogManager.getLogger();
    @Override
    public void replaceByCondition(CustomArray customArray, IntPredicate condition, int newValue) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("empty array");
        }

        IntStream.range(0, customArray.getArray().length)
                .filter(i -> condition.test(customArray.getArray()[i]))
                .forEach(i ->{ try {
                    logger.info("Replace element {} (index {}) on {}", customArray.getElement(i), i, newValue);
                    customArray.setElement(i, newValue);
                } catch (ArrayException e) {
                    logger.error("Failed to replace element at index {}: {}", i, e.getMessage());
                }
                });
    }
}
