package org.example.task.repository;

import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;

public interface Repository {

    void addArray(CustomArray customArray) throws ArrayException;

    void deleteArray(CustomArray customArray) throws ArrayException;

    CustomArray getArrayById(int id);
}
