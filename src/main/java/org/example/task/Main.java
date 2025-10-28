package org.example.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.example.task.parser.impl.FileLineParserImpl;
import org.example.task.reader.impl.FileArrayReaderImpl;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ArrayException {
        Logger logger = LogManager.getLogger();
        FileArrayReaderImpl fileArrayReaderService = new FileArrayReaderImpl();
        FileLineParserImpl fileLineParserService = new FileLineParserImpl();
        List<String> list = fileArrayReaderService.readFile("data/file.txt");
        int[] array = fileLineParserService.parseToCustomArrayFromStringList(list);
        CustomArray customArray = CustomArray.builder().setArray(array).setId(2).build();
        logger.info(customArray.toString());
    }
}