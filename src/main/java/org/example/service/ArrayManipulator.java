package org.example.service;

import org.example.entity.CustomArray;
import org.example.exception.ArrayException;

import java.util.function.IntPredicate;

public interface ArrayManipulator {

    void replaceByCondition(CustomArray customArray, IntPredicate condition, int newValue) throws ArrayException;
}
