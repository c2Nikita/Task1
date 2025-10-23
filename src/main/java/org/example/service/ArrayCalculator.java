package org.example.service;

import org.example.entity.CustomArray;
import org.example.exception.ArrayException;

public interface ArrayCalculator {
    public float calculateAverage(CustomArray customArray) throws ArrayException;
    public int calculateSum(CustomArray customArray) throws ArrayException;
    public int calculatePositiveElements(CustomArray customArray) throws ArrayException;
    public int calculateNegativeElements(CustomArray customArray) throws ArrayException;
}
