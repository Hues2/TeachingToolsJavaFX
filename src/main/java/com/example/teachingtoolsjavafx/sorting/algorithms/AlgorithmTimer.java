package com.example.teachingtoolsjavafx.sorting.algorithms;

import java.text.DecimalFormat;

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
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        return (df.format((endTime - startTime) / 1000000) + "ms");
    }
}
