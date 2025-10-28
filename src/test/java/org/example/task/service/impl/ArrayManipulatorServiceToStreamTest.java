package org.example.task.service.impl;


import org.example.task.service.ArrayManipulator;
import org.example.task.service.ArrayManipulatorTest;

class ArrayManipulatorServiceToStreamTest extends ArrayManipulatorTest {
    @Override
    protected ArrayManipulator getManipulator() {
        return new ArrayManipulatorServiceToStream();
    }
}
