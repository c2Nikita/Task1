package org.example.task.validator;

public interface LineValidator {
    String REGEX_FILE_LINE = "-?\\d+(\\s*[,;-]\\s*-?\\d+)*";

    boolean isLineFromFileValid(String lineFromFile);
}
