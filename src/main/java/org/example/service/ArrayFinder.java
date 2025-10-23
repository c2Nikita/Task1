package org.example.service;

import org.example.entity.CustomArray;
import org.example.exception.ArrayException;

public interface ArrayFinder {
    public int findMin(CustomArray customArray) throws ArrayException;
    public int findMax(CustomArray customArray) throws ArrayException;
    public int findLastIndexOf(CustomArray customArray, int num) throws ArrayException;
    public int findFirstIndexOf(CustomArray customArray,int num) throws ArrayException;
}
