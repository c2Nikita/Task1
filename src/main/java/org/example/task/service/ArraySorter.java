package org.example.task.service;

import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;

public interface ArraySorter {

    public void quickSort(CustomArray customArray) throws ArrayException;

    public void insertionSort(CustomArray customArray) throws ArrayException;

    public void selectionSort(CustomArray customArray) throws ArrayException;
}
