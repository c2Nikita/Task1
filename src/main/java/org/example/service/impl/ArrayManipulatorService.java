package org.example.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.CustomArray;
import org.example.exception.ArrayException;
import org.example.service.ArrayManipulator;

import java.util.function.IntPredicate;

public class ArrayManipulatorService implements ArrayManipulator {

    public static final Logger logger = LogManager.getLogger(ArrayManipulatorService.class);

    @Override
    public void replaceByCondition(CustomArray customArray, IntPredicate condition, int newValue) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("empty array");
        } else {
            for (int i = 0; i < customArray.getLenght(); i++) {
                if (condition.test(customArray.getArray()[i])) {
                    logger.info("Replace element " + customArray.getElement(i) + " (index " + i + ") on " + newValue);
                    customArray.setElement(i, newValue);
                }
            }
        }
    }
}
