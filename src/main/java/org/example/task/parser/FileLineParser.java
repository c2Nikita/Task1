package org.example.task.parser;

import java.util.List;

public interface FileLineParser {
    String REGEX_FOR_INT_ARRAY = "[,;\\s]+";

    int[] parseToCustomArrayFromStringList(List<String> listReadedFromFile);
}
