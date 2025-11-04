package org.example.task.observer.impl;

import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.example.task.stats.ArrayStats;
import org.example.task.warehouse.CustomArrayWareHouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayObserverImplTest {

    private CustomArrayObserverImpl observer;
    private CustomArrayWareHouse wareHouse;

    @BeforeEach
    void setUp() {
        observer = new CustomArrayObserverImpl();
        wareHouse = CustomArrayWareHouse.getInstance();
    }

    @Test
    void testUpdate_AddsStatsToWarehouse() throws ArrayException {
        CustomArray customArray = new CustomArray(new int[]{1, 2, 3});
        int id = customArray.getId();

        observer.update(customArray);

        ArrayStats stats = wareHouse.getArrayStats(id);
        assertAll(
                () -> assertNotNull(stats),
                () -> assertEquals(1, stats.min()),
                () -> assertEquals(3, stats.max()),
                () -> assertEquals(2.0, stats.avg()),
                () -> assertEquals(6, stats.sum())
        );
    }

    @Test
    void testUpdate_WithExceptionHandledGracefully() {
        CustomArray brokenArray;
        try {
            brokenArray = new CustomArray(null);
        } catch (ArrayException e) {
            brokenArray = null;
        }

        CustomArray finalBrokenArray = brokenArray;
        assertThrows(NullPointerException.class, () -> observer.update(null));
    }
}
