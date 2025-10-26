package org.example.task;

import org.example.task.builder.impl.CustomArrayBuilder;
import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.example.task.exception.FileReaderException;
import org.example.task.reader.impl.FileArrayReaderService;
import org.example.service.impl.*;
import org.example.task.service.impl.ArrayCalculatorService;
import org.example.task.service.impl.ArrayFindService;
import org.example.task.service.impl.ArrayManipulatorService;
import org.example.task.service.impl.ArraySorterService;
import org.example.task.validator.impl.LineValidatorService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ArrayException, FileReaderException {
        LineValidatorService lineValidatorService = new LineValidatorService();
        FileArrayReaderService fileArrayReaderService = new FileArrayReaderService(lineValidatorService);
        int[] array = fileArrayReaderService.readFile("data/file.txt");
        CustomArray customArray = new CustomArrayBuilder().setArray(array).build();
        ArrayFindService arrayFindService = new ArrayFindService();
        ArrayCalculatorService arrayCalculatorService = new ArrayCalculatorService();
        ArrayManipulatorService arrayManipulatorService = new ArrayManipulatorService();
        ArraySorterService arraySorterService = new ArraySorterService();

        arrayFindService.findMin(customArray);
        arrayFindService.findMax(customArray);


        arrayCalculatorService.calculateAverage(customArray);
        arrayCalculatorService.calculateSum(customArray);
        arrayCalculatorService.calculatePositiveElements(customArray);
        arrayCalculatorService.calculateNegativeElements(customArray);
        System.out.println(customArray);
        arrayManipulatorService.replaceByCondition(customArray,num -> num == 7, 25);
        System.out.println(customArray);


        arraySorterService.quickSort(customArray);
        System.out.println(customArray);


    }
}