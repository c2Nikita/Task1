package org.example.task.validator.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.validator.LineValidator;

import java.util.regex.Pattern;

public class LineValidatorImpl implements LineValidator {

    public static final Logger logger = LogManager.getLogger();

    public boolean isLineFromFileValid(String lineFromFile){
        if (lineFromFile == null || lineFromFile.isBlank()){
            logger.warn("Line is empty");
            return false;
        }

        Pattern pattern = Pattern.compile(REGEX_FILE_LINE);
        boolean result = pattern.matcher(lineFromFile).matches();
        logger.info("This line {}",result);
        return result;
    }
}
