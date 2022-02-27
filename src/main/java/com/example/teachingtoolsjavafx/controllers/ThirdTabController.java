package com.example.teachingtoolsjavafx.controllers;

import com.example.teachingtoolsjavafx.bars.Bar;

import java.util.ArrayList;

// This class handles the logic for the 3rd tab
public class ThirdTabController {

    public ArrayList<Integer> bars = new ArrayList<>();
    public boolean swapped = false;
    public int indexOfSwappedNumber;

    public String stepExplanation() {
        StringBuilder list;
        if (swapped){
            list = new StringBuilder("\n" + bars.get(0) + " is swapped with " + bars.get(1) + "\n");
        }else{
            list = new StringBuilder("\n" + bars.get(0) + " is NOT swapped with " + bars.get(1) + "\n");
        }
        return list.toString();
    }
}
