package org.example.task.specification.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.entity.CustomArray;
import org.example.task.specification.Specification;

public record SumLessThanSpecification(int sum) implements Specification {
    public static final Logger logger = LogManager.getLogger();
    @Override
    public boolean specify(CustomArray customArray) {
        int[] array = customArray.getArray();
        int sum = 0;
        for(int num : array) {
            sum += num;
        }
        logger.info("sum of current array = {}",sum);
        return sum < this.sum;
    }
}
