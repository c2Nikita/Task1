package org.example.task;

import org.example.task.builder.impl.CustomArrayBuilder;
import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.example.task.exception.FileReaderException;
import org.example.task.parser.impl.FileLineParserService;
import org.example.task.reader.impl.FileArrayReaderService;
import org.example.task.service.impl.*;
import org.example.task.validator.impl.LineValidatorService;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ArrayException, FileReaderException {
        FileArrayReaderService fileArrayReaderService = new FileArrayReaderService();
        FileLineParserService fileLineParserService = new FileLineParserService();
        List<String> list = fileArrayReaderService.readFile("data/file.txt");
        int[] array = fileLineParserService.parseToCustomArrayFromStringList(list);
        System.out.println(Arrays.toString(array));
         CustomArray customArray = CustomArray.Builder().setArray(array).setId(2).build();
    }
}