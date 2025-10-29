package org.example.task.warehouse.impl;

import org.example.task.entity.ArrayStats;
import org.example.task.entity.CustomArray;
import org.example.task.warehouse.WareHouse;

import java.util.HashMap;

public class WareHouseImpl implements WareHouse {
    private final HashMap<Integer, ArrayStats> stats = new HashMap<>();
    private static WareHouseImpl instance;

    private WareHouseImpl() {

    }
    WareHouseImpl getInstance() {
        if(instance == null){
            instance = new WareHouseImpl();
        }
        return instance;
    }

    @Override
    public void update(CustomArray array) {

    }

    @Override
    public ArrayStats getStats(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }
}
