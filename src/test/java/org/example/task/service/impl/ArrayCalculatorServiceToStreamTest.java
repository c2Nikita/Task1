package org.example.task.service.impl;

import org.example.task.service.ArrayCalculator;
import org.example.task.service.ArrayCalculatorTest;

public class ArrayCalculatorServiceToStreamTest extends ArrayCalculatorTest {
    @Override
    protected ArrayCalculator getCalculator() {
        return new ArrayCalculatorServiceToStream();
    }
}
