package com.example.teachingtoolsjavafx.bars;

import com.example.teachingtoolsjavafx.sorting.algorithms.SortingAnimationController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Bar extends Rectangle {

    private int size;

    Bar(int x){
        this.size = x;
    }

    public int getSize(){
        return this.size;
    }


}
