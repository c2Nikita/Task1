package org.example.task.warehouse;

import org.example.task.stats.ArrayStats;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomArrayWareHouseTest {

    @Test
    void testSingleton() {
        CustomArrayWareHouse first = CustomArrayWareHouse.getInstance();
        CustomArrayWareHouse second = CustomArrayWareHouse.getInstance();
        assertSame(first, second);
    }

    @Test
    void testPutAndGet() {
        CustomArrayWareHouse warehouse = CustomArrayWareHouse.getInstance();
        ArrayStats stats = new ArrayStats(1, 10, 5.5, 22);

        warehouse.put(1, stats);
        ArrayStats result = warehouse.getArrayStats(1);

        assertEquals(stats, result);
    }

    @Test
    void testRemove() {
        CustomArrayWareHouse warehouse = CustomArrayWareHouse.getInstance();
        ArrayStats stats = new ArrayStats(2, 8, 4.0, 20);

        warehouse.put(2, stats);
        warehouse.removeArrayStats(2);

        assertNull(warehouse.getArrayStats(2));
    }
}
