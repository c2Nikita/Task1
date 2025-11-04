package org.example.task.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.example.task.specification.CustomArraySpecification;
import org.example.task.warehouse.CustomArrayWareHouse;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayRepository {
    public static final Logger logger = LogManager.getLogger();
    private static CustomArrayRepository instance;

    private final List<CustomArray> arrays = new ArrayList<>();

    private CustomArrayRepository() {}

    public static CustomArrayRepository getInstance() {
        if(instance == null) {
            logger.info("create new instance of repository");
            instance = new CustomArrayRepository();
        }
        logger.info("return instance of repository");
        return instance;
    }

    public void add(CustomArray customArray) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("Bad entity to add");
        }

        logger.info("add custom array {} in repo",customArray);
        customArray.notifyObservers();
        arrays.add(customArray);

    }

    public void remove(CustomArray customArray) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("Bad entity to delete");
        }
        logger.info("remove custom array {} from repo",customArray);
        CustomArrayWareHouse.getInstance().removeArrayStats(customArray.getId());
        arrays.remove(customArray);

    }

    public List<CustomArray> query(CustomArraySpecification specification) {
        logger.info("Starting query operation with specification: {}",
                specification != null ? specification.getClass().getSimpleName() : "null");
        return arrays.stream().filter(specification::specify).toList();
    }


}