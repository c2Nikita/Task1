package org.example.service;

import org.example.entity.CustomArray;
import org.example.exception.ArrayException;

public interface ArrayCalculator {

    float calculateAverage(CustomArray customArray) throws ArrayException;

    int calculateSum(CustomArray customArray) throws ArrayException;

    int calculatePositiveElements(CustomArray customArray) throws ArrayException;

    int calculateNegativeElements(CustomArray customArray) throws ArrayException;
}
