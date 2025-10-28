package org.example.task.parser.impl;

import org.example.task.parser.FileLineParser;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileLineParserImplTest {

    @Test
    void provideLinesForParseToCustomArrayFromStringList() {
        FileLineParser parser = new FileLineParserImpl();
        List<String> lines = Arrays.asList(
                "1 2 3 4",
                "-5, 10, -3",
                "7;-8;9",
                "10, -11, 12",
                "text",
                "1, 2, a",
                "",
                "abc xyz"
        );

        int[] expected = {-5, 10, -3, 7, -8, 9, 10, -11, 12};
        int[] actual = parser.parseToCustomArrayFromStringList(lines);

        assertArrayEquals(expected, actual);
    }

}