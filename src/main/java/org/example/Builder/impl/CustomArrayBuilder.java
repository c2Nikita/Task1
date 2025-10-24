package org.example.Builder.impl;

import org.example.Builder.Builder;
import org.example.entity.CustomArray;

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
