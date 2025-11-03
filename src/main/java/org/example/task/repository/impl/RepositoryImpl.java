package org.example.task.repository.impl;

import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.example.task.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements Repository {
    private static RepositoryImpl instance;

    private final List<CustomArray> arrays = new ArrayList<>();

    private RepositoryImpl() {}

    public static RepositoryImpl getInstance() {
        if(instance == null) {
            instance = new RepositoryImpl();
        }

        return instance;
    }

    @Override
    public void addArray(CustomArray customArray) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("Bad entity to add");
        }

        arrays.add(customArray);
    }

    @Override
    public void deleteArray(CustomArray customArray) throws ArrayException {
        if (customArray == null) {
            throw new ArrayException("Bad entity to delete");
        }

        arrays.remove(customArray);
    }

    @Override
    public CustomArray getArrayById(int id) {
        return arrays.get(id);
    }
}