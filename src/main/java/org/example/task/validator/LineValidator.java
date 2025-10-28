package org.example.task.validator;

public interface LineValidator {
    String REGEX_FILE_LINE = "\\s*-?\\d+(\\s*[,;-]\\s*-?\\d+)*\\s*";

    boolean isLineFromFileValid(String lineFromFile);
}
