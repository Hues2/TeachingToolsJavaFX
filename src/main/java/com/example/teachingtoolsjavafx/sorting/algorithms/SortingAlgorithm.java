package com.example.teachingtoolsjavafx.sorting.algorithms;

import com.example.teachingtoolsjavafx.bars.Bar;

import java.util.ArrayList;

public interface SortingAlgorithm {
     void sort();
     void swap(int indexA, int indexB);
     ArrayList<Bar[]> getSteps();
}
