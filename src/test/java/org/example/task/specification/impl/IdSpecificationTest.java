package org.example.task.specification.impl;

import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdSpecificationTest {

    @Test
    void testSpecify() throws ArrayException {
        CustomArray array = new CustomArray(new int[]{1, 2, 3});

        IdSpecification matchSpec = new IdSpecification(1);
        IdSpecification notMatchSpec = new IdSpecification(2);

        assertAll(
                () -> assertTrue(matchSpec.specify(array), "ID 1 must match"),
                () -> assertFalse(notMatchSpec.specify(array), "ID 2 must not match")
        );
    }
}
