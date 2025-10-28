package org.example.task.parser.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.parser.FileLineParser;
import org.example.task.validator.LineValidator;
import org.example.task.validator.impl.LineValidatorImpl;

import java.util.Arrays;
import java.util.List;

public class FileLineParserImpl implements FileLineParser {
    public static final Logger logger = LogManager.getLogger();

    @Override
    public int[] parseToCustomArrayFromStringList(List<String> listReadedFromFile){
        LineValidator lineValidator = new LineValidatorImpl();
        logger.info("Parser start work");
        return listReadedFromFile.stream()
                .filter(lineValidator::isLineFromFileValid)
                .flatMap(line -> Arrays.stream(line.trim().split(REGEX_FOR_INT_ARRAY)))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
