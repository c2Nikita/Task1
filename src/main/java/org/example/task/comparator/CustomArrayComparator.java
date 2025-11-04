package org.example.task.comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.example.task.service.ArrayCalculator;
import org.example.task.service.impl.ArrayCalculatorService;

import java.util.Comparator;


public enum CustomArrayComparator implements Comparator<CustomArray> {
    BY_ID {
        @Override
        public int compare(CustomArray array1, CustomArray array2) {
            return Integer.compare(array1.getId(), array2.getId());
        }
    },
    BY_SUM {
        @Override
        public int compare(CustomArray array1, CustomArray array2) {
            int result;
            try {
                ArrayCalculator service = new ArrayCalculatorService();
                result = Integer.compare(
                        service.calculateSum(array1),
                        service.calculateSum(array2)
                );
            } catch (ArrayException e) {
                logger.info("Can't find sum of CustomArrays");
                result = 0;
            }
            return result;
        }
    },
    BY_LENGTH {
        @Override
        public int compare(CustomArray array1, CustomArray array2) {
            return Integer.compare(array1.getLenght(), array2.getLenght());
        }
    };
    public static final Logger logger = LogManager.getLogger();
}
