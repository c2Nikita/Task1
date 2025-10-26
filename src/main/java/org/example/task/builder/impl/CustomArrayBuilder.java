package org.example.task.builder.impl;

import org.example.task.builder.Builder;
import org.example.task.entity.CustomArray;

public class CustomArrayBuilder implements Builder {

    private int[] array;

    @Override
    public CustomArrayBuilder setArray(int[] array) {
        this.array = array;
        return this;
    }

    public CustomArray build() {
        return new CustomArray(array);
    }
}
