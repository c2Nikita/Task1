package org.example.task.service.impl;


import org.example.task.service.ArrayManipulator;
import org.example.task.service.ArrayManipulatorTest;

class ArrayManipulatorServiceTest extends ArrayManipulatorTest {
    @Override
    protected ArrayManipulator getManipulator() {
        return new ArrayManipulatorService();
    }
}