package org.example.task.service.impl;

import org.example.task.service.ArrayCalculator;
import org.example.task.service.ArrayCalculatorTest;


class ArrayCalculatorServiceTest extends ArrayCalculatorTest {
    @Override
    protected ArrayCalculator getCalculator() {
        return new ArrayCalculatorService();
    }
}