package com.example.teachingtoolsjavafx.controllers;

import java.util.ArrayList;

// This class handles the logic for the 3rd tab
public class ThirdTabController {
    public StringBuilder stringBuilder = new StringBuilder();
    public final ArrayList<StringBuilder> stepExplanations = new ArrayList<>();

    public void addStep(){
        stepExplanations.add(stringBuilder);
    }

    public String getExplanation(int index){
        if (index == stepExplanations.size()){
            return null;
        }
        return stepExplanations.get(index).toString();
    }
}
