package org.example.task.specification.impl;

import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsValueSpecificationTest {

    private CustomArray array;

    @BeforeEach
    void setUp() throws ArrayException {
        array = new CustomArray(new int[]{5, 10, 15});
    }

    @Test
    void testSpecify() {
        var spec1 = new ContainsValueSpecification(10);
        var spec2 = new ContainsValueSpecification(99);
        assertAll(
                () -> assertTrue(spec1.specify(array)),
                () -> assertFalse(spec2.specify(array))
        );
    }
}
