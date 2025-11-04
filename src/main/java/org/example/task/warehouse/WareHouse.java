package org.example.task.warehouse;

import org.example.task.stats.ArrayStats;
import org.example.task.entity.CustomArray;
import org.example.task.observer.Observer;

import java.util.HashMap;

public class WareHouse implements Observer {
    private final HashMap<Integer, ArrayStats> stats = new HashMap<>();
    private static WareHouse instance;
    private int sum;
    private int max;
    private int min;
    private int avg;

    private WareHouse() {

    }

    public WareHouse getInstance() {
        if(instance == null){
            instance = new WareHouse();
        }
        return instance;
    }

    @Override
    public void update(CustomArray array) {

    }

    public ArrayStats getStats(int id) {
        return null;
    }

    public void remove(int id) {

    }

}
