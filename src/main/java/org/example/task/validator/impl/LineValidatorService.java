package org.example.task.validator.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.validator.LineValidator;

import java.util.regex.Pattern;

public class LineValidatorService implements LineValidator {

    public static final Logger logger = LogManager.getLogger(LineValidatorService.class);
    public static final String REGEX = "^\\s*(-?\\d+)(\\s*[,;\\-\\s]\\s*-?\\d+)*\\s*$";

    public boolean isValid(String line){
        if (line == null || line.trim().isEmpty()){
            logger.info("Line is empty");
            return false;
        }

        Pattern pattern = Pattern.compile(REGEX);
        boolean result = pattern.matcher(line).matches();

        if(result){
            logger.info("Line correct");
        } else {
            logger.info("Line incorrect");
        }

        return result;
    }
}
