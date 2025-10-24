package org.example.service;

import org.example.entity.CustomArray;
import org.example.exception.ArrayException;

public interface ArrayFinder {

    int findMin(CustomArray customArray) throws ArrayException;

    int findMax(CustomArray customArray) throws ArrayException;

    int findLastIndexOf(CustomArray customArray, int num) throws ArrayException;

    int findFirstIndexOf(CustomArray customArray, int num) throws ArrayException;
}
