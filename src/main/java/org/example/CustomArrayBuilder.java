package org.example;

import org.example.entity.CustomArray;

public class CustomArrayBuilder implements Builder{
    private int lenght;
    @Override
    public CustomArrayBuilder setLenght(int lenght){
        this.lenght = lenght;
        return this;
    }

    public CustomArray build(){
        return new CustomArray(lenght);
    }

}
