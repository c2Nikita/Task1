package org.example.task.parser.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.validator.LineValidator;
import org.example.task.validator.impl.LineValidatorService;

import java.util.Arrays;
import java.util.List;


public class FileLineParserService {
    public static final Logger logger = LogManager.getLogger();
    public static final String REGEX_FOR_INT_ARRAY = "[,;\\s]+";

    public int[] parseToCustomArrayFromStringList(List<String> lines){
        LineValidator lineValidator = new LineValidatorService();
        logger.info("Parser start work");
        return lines.stream()
                .filter(lineValidator::isLineFromFileValid)
                .flatMap(line -> Arrays.stream(line.trim().split(REGEX_FOR_INT_ARRAY)))
                .mapToInt(Integer::parseInt)
                .toArray();

    }
}
