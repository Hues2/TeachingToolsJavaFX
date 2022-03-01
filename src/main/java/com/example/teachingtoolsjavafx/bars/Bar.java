package com.example.teachingtoolsjavafx.bars;

import javafx.scene.shape.Rectangle;

public class Bar extends Rectangle {

    private final int size;

    Bar(int barSize){
        this.size = barSize;
    }

    public int getSize(){
        return this.size;
    }


}
