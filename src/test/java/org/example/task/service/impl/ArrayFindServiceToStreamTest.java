package org.example.task.service.impl;


import org.example.task.service.ArrayFinder;
import org.example.task.service.ArrayFinderTest;

class ArrayFindServiceToStreamTest extends ArrayFinderTest {
    @Override
    protected ArrayFinder getFinder() {
        return new ArrayFindServiceToStream();
    }
}
