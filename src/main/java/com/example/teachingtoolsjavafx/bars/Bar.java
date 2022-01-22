package com.example.teachingtoolsjavafx.bars;

import javafx.scene.shape.Rectangle;

public class Bar extends Rectangle {

    private int size;

    Bar(int x){
        this.size = x;
    }

    public int getSize(){
        return this.size;
    }


}
