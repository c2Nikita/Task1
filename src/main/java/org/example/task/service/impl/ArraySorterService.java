package org.example.task.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.example.task.service.ArraySorter;

public class ArraySorterService implements ArraySorter {

    public static final Logger logger = LogManager.getLogger(ArraySorterService.class);

    public void quickSort(CustomArray customArray) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("Array is empty");
        }

        int[] array = customArray.getArray();
        quickSortRecursive(array, 0, array.length - 1);
        customArray.setArray(array);
        logger.info("Array sorted using QuickSort");
    }

    private void quickSortRecursive(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSortRecursive(array, low, pivotIndex - 1);
            quickSortRecursive(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    @Override
    public void insertionSort(CustomArray customArray) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("empty array");
        }
        int[] array = customArray.getArray();
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        customArray.setArray(array);
        logger.info("Array sorted using InsertionSort");
    }

    @Override
    public void selectionSort(CustomArray customArray) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("empty array");
        }
        int[] array = customArray.getArray();
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
        customArray.setArray(array);
        logger.info("Array sorted using SelectionSort");
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
