package org.example.task.builder;

import org.example.task.builder.impl.CustomArrayBuilder;

public interface Builder {

    CustomArrayBuilder setArray(int[] array);

    CustomArrayBuilder setId(int id);
}
