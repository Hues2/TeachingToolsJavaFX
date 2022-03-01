package com.example.teachingtoolsjavafx.sorting.algorithms;

public class AlgorithmTimer {
    private double startTime;
    private double endTime;

    public void setStart(double startTime){
        this.startTime = startTime;
    }

    public void setEndTime(double endTime){
        this.endTime = endTime;
    }

    public String getTotalTimeInMS(){
        return (((endTime - startTime) / 1000000) + "ms");
    }
}
