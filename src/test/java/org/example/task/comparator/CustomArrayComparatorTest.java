package org.example.task.comparator;

import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayComparatorTest {

    private List<CustomArray> arrays;

    @BeforeEach
    void setUp() throws ArrayException {
        arrays = new ArrayList<>();
        arrays.add(new CustomArray(new int[]{10, 20, 30}));
        arrays.add(new CustomArray(new int[]{1, 2, 3}));
        arrays.add(new CustomArray(new int[]{5, 5}));
    }

    @Test
    void testCompareById() {
        arrays.sort(CustomArrayComparator.BY_ID);
        assertAll(
                () -> assertArrayEquals(new int[]{10, 20, 30}, arrays.get(0).getArray()),
                () -> assertArrayEquals(new int[]{1, 2, 3}, arrays.get(1).getArray()),
                () -> assertArrayEquals(new int[]{5, 5}, arrays.get(2).getArray())
        );
    }

    @Test
    void testCompareByLength() {
        arrays.sort(CustomArrayComparator.BY_LENGTH);
        assertAll(
                () -> assertArrayEquals(new int[]{5, 5}, arrays.get(0).getArray()),
                () -> assertArrayEquals(new int[]{10, 20, 30}, arrays.get(1).getArray()),
                () -> assertArrayEquals(new int[]{1, 2, 3}, arrays.get(2).getArray())
        );
    }

    @Test
    void testCompareBySum() {
        arrays.sort(CustomArrayComparator.BY_SUM);
        assertAll(
                () -> assertArrayEquals(new int[]{1, 2, 3}, arrays.get(0).getArray()),
                () -> assertArrayEquals(new int[]{5, 5}, arrays.get(1).getArray()),
                () -> assertArrayEquals(new int[]{10, 20, 30}, arrays.get(2).getArray())
        );
    }
}
