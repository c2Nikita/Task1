package org.example.task.warehouse;

import org.example.task.entity.ArrayStats;
import org.example.task.entity.CustomArray;

public interface WareHouse {

    void update(CustomArray array);

    ArrayStats getStats(int id);

    public void remove(int id);
}
