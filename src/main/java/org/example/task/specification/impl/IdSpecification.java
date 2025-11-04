package org.example.task.specification.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.entity.CustomArray;
import org.example.task.specification.Specification;



public record IdSpecification(int id) implements Specification {
    public static final Logger logger = LogManager.getLogger();
    @Override
    public boolean specify(CustomArray customArray) {
        logger.info(" checking id: {}",this.id);
        return customArray.getId() == id;
    }
}
