package org.example.task.repository;

import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.example.task.specification.Specification;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static Repository instance;

    private final List<CustomArray> arrays = new ArrayList<>();

    private Repository() {}

    public static Repository getInstance() {
        if(instance == null) {
            instance = new Repository();
        }

        return instance;
    }

    public void add(CustomArray customArray) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("Bad entity to add");
        }

        arrays.add(customArray);
    }

    public void remove(CustomArray customArray) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("Bad entity to delete");
        }

        arrays.remove(customArray);
    }

    public List<CustomArray> query(Specification specification) {
        List<CustomArray> list = arrays.stream().filter(specification::specify).toList();
        return list;
    }
}