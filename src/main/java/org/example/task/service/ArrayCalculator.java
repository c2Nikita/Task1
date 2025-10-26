package org.example.task.service;

import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;

public interface ArrayCalculator {

    float calculateAverage(CustomArray customArray) throws ArrayException;

    int calculateSum(CustomArray customArray) throws ArrayException;

    int calculatePositiveElements(CustomArray customArray) throws ArrayException;

    int calculateNegativeElements(CustomArray customArray) throws ArrayException;
}
