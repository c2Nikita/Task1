package org.example.entity;

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
    // realize toString method
}
