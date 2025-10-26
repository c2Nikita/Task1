package org.example.task.service;

import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;

public interface ArrayFinder {

    int findMin(CustomArray customArray) throws ArrayException;

    int findMax(CustomArray customArray) throws ArrayException;

    int findLastIndexOf(CustomArray customArray, int num) throws ArrayException;

    int findFirstIndexOf(CustomArray customArray, int num) throws ArrayException;
}
