package org.example.task.service;

import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;

import java.util.function.IntPredicate;

public interface ArrayManipulator {

    void replaceByCondition(CustomArray customArray, IntPredicate condition, int newValue) throws ArrayException;
}
