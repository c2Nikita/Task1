package org.example.task.specification.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.entity.CustomArray;
import org.example.task.specification.Specification;

import java.util.Arrays;


public record ContainsValueSpecification(int value) implements Specification {
    public static final Logger logger = LogManager.getLogger();
    @Override
    public boolean specify(CustomArray customArray) {
        boolean result = java.util.Arrays.stream(customArray.getArray()).anyMatch(num -> num == value);
        logger.info("contains value: {} {} in {}", value,result,customArray.getArray());
        return result;
    }
}
