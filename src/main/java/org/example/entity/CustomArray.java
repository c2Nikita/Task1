package org.example.entity;

import java.util.Arrays;

public class CustomArray {
    private int[] array;

    public CustomArray(int lenght){
        array = new int[lenght];
    }

    public int[] getArray() {
        return array.clone();
    }
    public int getLenght(){
        return array.length;
    }
    public void setElement(int index, int value){
        array[index] = value;
    }
    public int getElement(int index){
        return array[index];
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("Array data: [");
        for(int i = 0; i < array.length; i++){
            stringBuilder.append(array[i]);
            if(i != array.length-1){
                stringBuilder.append(", ");
            }

        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}
