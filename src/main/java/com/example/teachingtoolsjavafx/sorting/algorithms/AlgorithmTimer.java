package com.example.teachingtoolsjavafx.sorting.algorithms;

public class AlgorithmTimer {
    public double startTime;
    public double endTime;

    public String getTotalTimeInMS(){
        return (((endTime - startTime) / 1000000) + "ms");
    }
}
