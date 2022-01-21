package com.example.teachingtoolsjavafx.sorting.algorithms;

import com.example.teachingtoolsjavafx.bars.Bar;
import java.util.ArrayList;

public abstract class SortingAlgorithm{
    public abstract void sort();
    public abstract void swap(int indexA, int indexB);
    public abstract ArrayList<Bar[]> getSteps();
}

