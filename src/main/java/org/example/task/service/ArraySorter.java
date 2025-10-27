package org.example.task.service;

import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;

public interface ArraySorter {

    void quickSort(CustomArray customArray) throws ArrayException;

    void insertionSort(CustomArray customArray) throws ArrayException;

    void selectionSort(CustomArray customArray) throws ArrayException;
}
