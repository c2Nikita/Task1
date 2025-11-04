package org.example.task.specification.impl;

import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumLessThanSpecificationTest {

    private CustomArray smallArray;
    private CustomArray bigArray;

    @BeforeEach
    void setUp() throws ArrayException {
        smallArray = new CustomArray(new int[]{1, 2, 3});
        bigArray = new CustomArray(new int[]{10, 20, 30});
    }

    @Test
    void testSpecify() {
        var spec = new SumLessThanSpecification(10);
        assertAll(
                () -> assertTrue(spec.specify(smallArray)),
                () -> assertFalse(spec.specify(bigArray))
        );
    }
}
