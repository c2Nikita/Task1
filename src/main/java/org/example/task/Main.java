package org.example.task;

import org.example.task.builder.impl.CustomArrayBuilder;
import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.example.task.exception.FileReaderException;
import org.example.task.reader.impl.FileArrayReaderService;
import org.example.task.service.impl.*;
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

        ArrayCalculatorServiceToStream arrayCalculatorServiceToStream = new ArrayCalculatorServiceToStream();
        CustomArray customArray1 = new CustomArray(1);
        arrayCalculatorServiceToStream.calculateAverage(customArray1);



        arrayCalculatorService.calculateAverage(customArray);
        arrayCalculatorService.calculateSum(customArray1);
        arrayCalculatorService.calculatePositiveElements(customArray);
        arrayCalculatorService.calculateNegativeElements(customArray);
        System.out.println(customArray);
        arrayManipulatorService.replaceByCondition(customArray,num -> num > 2, 25);
        System.out.println(customArray);


        arraySorterService.quickSort(customArray);
        System.out.println(customArray);


    }
}