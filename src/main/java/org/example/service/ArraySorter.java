package org.example.service;

import org.example.entity.CustomArray;
import org.example.exception.ArrayException;

public interface ArraySorter {

    public void quickSort(CustomArray customArray) throws ArrayException;

    public void insertionSort(CustomArray customArray) throws ArrayException;

    public void selectionSort(CustomArray customArray) throws ArrayException;
}
