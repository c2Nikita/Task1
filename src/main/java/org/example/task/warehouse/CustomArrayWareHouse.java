package org.example.task.warehouse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.stats.ArrayStats;

import java.util.HashMap;
import java.util.Map;

public class CustomArrayWareHouse {
    public static final Logger logger = LogManager.getLogger();
    private final Map<Integer, ArrayStats> stats = new HashMap<>();
    private static CustomArrayWareHouse instance;

    private CustomArrayWareHouse() {}

    public static CustomArrayWareHouse getInstance() {
        if(instance == null){
            logger.info("create new instance of warehouse");
            instance = new CustomArrayWareHouse();
        }
        logger.info("return instance of warehouse");
        return instance;
    }

    public ArrayStats put(Integer id, ArrayStats customArrayParameters) {
        if (customArrayParameters == null) {
            logger.warn("Attempt to put null MyArrayParameters for id: {}", id);
        }
        return stats.put(id, customArrayParameters);
    }
    public ArrayStats getArrayStats(int id) {
        logger.info("return stats of array with id: {}", id);
        return stats.get(id);
    }

    public void removeArrayStats(int id) {
        logger.info("remove stats of array with id: {}", id);
        stats.remove(id);
    }

}
