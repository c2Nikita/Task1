package org.example.task.observer;

import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;

public interface CustomArrayObserver {
    void update(CustomArray customArray);
}
