package org.example.task.entity;

import org.example.task.exception.ArrayException;

import java.util.Arrays;

public class CustomArray {

    private int[] array;

    public CustomArray(int lenght) throws ArrayException {
        if (lenght <= 0) {
            throw new ArrayException("Bad array lenght");
        }

        array = new int[lenght];
    }

    public CustomArray(int[] array) throws ArrayException {
        if (array == null) {
            throw new ArrayException("Bad array for create");
        }

        this.array = array.clone();
    }

    public int[] getArray() {
        return array.clone();
    }

    public void setArray(int[] array){
        this.array = array.clone();
    }

    public int getLenght() {
        return array.length;
    }

    public void setElement(int index, int value) throws ArrayException {
        if (index >= array.length || index < 0) {
            throw new ArrayException("array out of bounds");
        }

        array[index] = value;
    }

    public int getElement(int index) throws ArrayException {
        if (index >= array.length || index < 0) {
            throw new ArrayException("array out of bounds");
        }

        return array[index];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Array data: [");
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
            if (i != array.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
// todo hashcode and equals