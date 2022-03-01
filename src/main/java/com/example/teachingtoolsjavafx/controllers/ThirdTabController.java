package com.example.teachingtoolsjavafx.controllers;

import java.util.ArrayList;

// This class handles the logic for the 3rd tab
public class ThirdTabController {

    private StringBuilder stringBuilder = new StringBuilder();
    private final ArrayList<StringBuilder> stepExplanations = new ArrayList<>();


    public void setSwappedStringBuilder(int firstNum, int secondNum){
        if (firstNum == secondNum){
            this.stringBuilder = new StringBuilder("\nThe current bar has the value of " + firstNum + ", which is equal to the compared bar, so " +
                    "the default method is to swap them anyway.\n");
        }else if (firstNum < secondNum){
            this.stringBuilder = new StringBuilder("\nThe current bar value is " + firstNum + " and the value of the bar that it is comparing it to is " +
                    secondNum + ". As it is smaller, the bars will swap.\n");
        }else{
            this.stringBuilder = new StringBuilder("\nThe current bar value is " + firstNum + " and the value of the bar that it is comparing it to is " +
                    secondNum + ". As it is bigger, the bars will swap.\n");
        }

        stepExplanations.add(this.stringBuilder);
    }

    public void setNotSwappedStringBuilder(int firstNum, int secondNum){
        this.stringBuilder = new StringBuilder("\nThe current bar value is " + firstNum + " and the value of the bar that it is comparing it to is " +
                secondNum + ". As it is smaller, the bars will NOT swap.\n");
        stepExplanations.add(this.stringBuilder);
    }


    public String getExplanation(int index){
        if (index == stepExplanations.size()){
            return null;
        }
        return stepExplanations.get(index).toString();
    }
}
