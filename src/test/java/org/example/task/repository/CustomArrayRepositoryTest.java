package org.example.task.repository;

import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.example.task.specification.CustomArraySpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayRepositoryTest {

    private CustomArrayRepository repository;

    @BeforeEach
    void setUp() {
        repository = CustomArrayRepository.getInstance();
    }

    @Test
    void testAddAndRemove() throws ArrayException {
        CustomArray array = new CustomArray(new int[]{1, 2, 3});
        repository.add(array);
        assertTrue(repository.sort(Comparator.comparingInt(CustomArray::getId)).contains(array));

        repository.remove(array);
        assertFalse(repository.sort(Comparator.comparingInt(CustomArray::getId)).contains(array));
    }

    @Test
    void testAddNullThrowsException() {
        assertThrows(ArrayException.class, () -> repository.add(null));
    }

    @Test
    void testRemoveNullThrowsException() {
        assertThrows(ArrayException.class, () -> repository.remove(null));
    }

    @Test
    void testSort() throws ArrayException {
        CustomArray a1 = new CustomArray(new int[]{1, 2});
        CustomArray a2 = new CustomArray(new int[]{10, 20, 30});
        repository.add(a1);
        repository.add(a2);

        List<CustomArray> sorted = repository.sort(Comparator.comparingInt(arr -> arr.getArray().length));
        assertEquals(a1, sorted.get(0));
        assertEquals(a2, sorted.get(1));

        repository.remove(a1);
        repository.remove(a2);
    }

    @Test
    void testQuery() throws ArrayException {
        CustomArray a1 = new CustomArray(new int[]{1, 2, 3});
        CustomArray a2 = new CustomArray(new int[]{5, 5, 5});
        repository.add(a1);
        repository.add(a2);

        CustomArraySpecification hasFive = arr -> {
            for (int num : arr.getArray()) {
                if (num == 5) return true;
            }
            return false;
        };

        List<CustomArray> result = repository.query(hasFive);
        assertEquals(1, result.size());
        assertTrue(result.contains(a2));

        repository.remove(a1);
        repository.remove(a2);
    }
}
