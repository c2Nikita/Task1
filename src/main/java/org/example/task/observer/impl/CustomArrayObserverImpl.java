package org.example.task.observer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.example.task.observer.CustomArrayObserver;
import org.example.task.service.ArrayCalculator;
import org.example.task.service.ArrayFinder;
import org.example.task.service.impl.ArrayCalculatorService;
import org.example.task.service.impl.ArrayFindService;
import org.example.task.stats.ArrayStats;
import org.example.task.warehouse.CustomArrayWareHouse;

public class CustomArrayObserverImpl implements CustomArrayObserver {
    public static final Logger logger = LogManager.getLogger();
    @Override
    public void update(CustomArray customArray) {
        CustomArrayWareHouse wareHouse = CustomArrayWareHouse.getInstance();
        ArrayCalculator arrayCalculator = new ArrayCalculatorService();
        ArrayFinder arrayFinder = new ArrayFindService();
        try {
            ArrayStats arrayStats = new ArrayStats(
                    arrayFinder.findMin(customArray),
                    arrayFinder.findMax(customArray),
                    arrayCalculator.calculateAverage(customArray),
                    arrayCalculator.calculateSum(customArray)
            );

            wareHouse.put(customArray.getId(), arrayStats);
            logger.info("update parameters for CustomArray id: {} in warehouse", customArray.getId());
        } catch (ArrayException e) {
            logger.error("Error for CustomArray id {}: {}",
                    customArray.getId(), e.getMessage());
        }
    }
}
