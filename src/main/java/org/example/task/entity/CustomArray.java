package org.example.task.entity;

import org.example.task.exception.ArrayException;

import java.util.Arrays;

public class CustomArray {

    private int[] array;
    private int id;

    private CustomArray() {

    }
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

    public CustomArray(int[] array,int id) throws ArrayException {
        if (array == null || array.length == 0) {
            throw new ArrayException("Bad array for create");
        }

        this.id = id;
        this.array = array.clone();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    private void valitadeIndex(int index) throws ArrayException {
        if (index >= array.length || index < 0) {
            throw new ArrayException("array out of bounds");
        }
    }

    public void setElement(int index, int value) throws ArrayException {
        valitadeIndex(index);
        array[index] = value;
    }

    public int getElement(int index) throws ArrayException {
        valitadeIndex(index);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomArray customArray = (CustomArray) o;
        return Arrays.equals(this.array,customArray.array) && this.id == customArray.id;
    }

    @Override
    public int hashCode(){
        int result = 7;
        result = 17 * result + id;

        for(int num : array) {
            result = result * 17 + num;
        }

        return result;
    }

    public static  Builder builder() {
        return new CustomArray().new Builder();
    }

    public class Builder {
        private int[] array;
        private int id;

        private Builder() {

        }

        public Builder setId(int id) {
            CustomArray.this.id = id;

            return this;
        }

        public Builder setArray(int[] array) {
            this.array = array.clone();
            CustomArray.this.array = array.clone();

            return this;
        }

        public CustomArray build() throws ArrayException {
            return new CustomArray(array,id);
        }


    }
}
