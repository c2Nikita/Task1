package org.example;

import org.example.entity.CustomArray;
import org.example.exception.ArrayException;
import org.example.service.ArrayCalculator;
import org.example.service.impl.ArrayCalculatorService;
import org.example.service.impl.ArrayFindService;
import org.example.service.impl.ArrayManipulatorService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ArrayException {
        CustomArray customArray = new CustomArrayBuilder().setLenght(10).build();
        ArrayFindService arrayFindService = new ArrayFindService();
        ArrayCalculatorService arrayCalculatorService = new ArrayCalculatorService();
        ArrayManipulatorService arrayManipulatorService = new ArrayManipulatorService();

        customArray.setElement(0, 22);
        customArray.setElement(1, -2);
        customArray.setElement(2, 4);
        customArray.setElement(3, 7);
        customArray.setElement(4, -10);
        customArray.setElement(5, 2);
        customArray.setElement(6, 7);
        customArray.setElement(7, 7);
        customArray.setElement(8, 10);
        customArray.setElement(9, 12);



        arrayFindService.findMin(customArray);
        arrayFindService.findMax(customArray);

        arrayFindService.findFirstIndexOf(customArray,7);
        arrayFindService.findLastIndexOf(customArray,7);

        arrayCalculatorService.calculateAverage(customArray);
        arrayCalculatorService.calculateSum(customArray);
        arrayCalculatorService.calculatePositiveElements(customArray);
        arrayCalculatorService.calculateNegativeElements(customArray);
        System.out.println(customArray);
        arrayManipulatorService.replaceByCondition(customArray,num -> num == 7, 25);
        System.out.println(customArray);


    }
}