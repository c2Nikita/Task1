package org.example.task.service;

import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;

import java.util.OptionalInt;

public interface ArrayFinder {

    int findMin(CustomArray customArray) throws ArrayException;

    int findMax(CustomArray customArray) throws ArrayException;

    OptionalInt findLastIndexOf(CustomArray customArray, int num) throws ArrayException;

    OptionalInt findFirstIndexOf(CustomArray customArray, int num) throws ArrayException;
}
