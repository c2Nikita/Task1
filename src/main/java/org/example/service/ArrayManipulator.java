package org.example.service;

import org.example.entity.CustomArray;
import org.example.exception.ArrayException;

import java.util.function.IntPredicate;

public interface ArrayManipulator {
    public void replaceByCondition(CustomArray customArray, IntPredicate condition, int newValue) throws ArrayException;
}
