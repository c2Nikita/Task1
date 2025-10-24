package org.example;

import org.example.Builder.impl.CustomArrayBuilder;
import org.example.entity.CustomArray;
import org.example.exception.ArrayException;
import org.example.exception.FileReaderException;
import org.example.service.LineValidator;
import org.example.service.impl.*;

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