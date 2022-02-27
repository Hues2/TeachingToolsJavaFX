package com.example.teachingtoolsjavafx.controllers;

import com.example.teachingtoolsjavafx.bars.Bar;

import java.util.ArrayList;

// This class handles the logic for the 3rd tab
public class ThirdTabController {

    private StringBuilder stringBuilder = new StringBuilder();
    private ArrayList<StringBuilder> stepExplanations = new ArrayList<>();


    public void setSwappedStringBuilder(int firstNum, int secondNum){
        this.stringBuilder = new StringBuilder("\n" + firstNum + " will swap with " + secondNum + "\n");
        stepExplanations.add(this.stringBuilder);
    }

    public void setNotSwappedStringBuilder(int firstNum, int secondNum){
        this.stringBuilder = new StringBuilder("\n" + firstNum + " will NOT swap with " + secondNum + "\n");
        stepExplanations.add(this.stringBuilder);
    }


    public String getExplanation(int index){
        if (index == stepExplanations.size()){
            return null;
        }
        return stepExplanations.get(index).toString();
    }
}
