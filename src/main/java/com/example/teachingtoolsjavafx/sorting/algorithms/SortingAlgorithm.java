package com.example.teachingtoolsjavafx.sorting.algorithms;

import com.example.teachingtoolsjavafx.bars.Bar;
import com.example.teachingtoolsjavafx.controllers.ThirdTabController;

import java.util.ArrayList;

public abstract class SortingAlgorithm {
     public abstract void sort();
     abstract void swap(int indexA, int indexB);
     public abstract ArrayList<Bar[]> getSteps();
     public abstract String definitionText();
     public ThirdTabController thirdTabController = new ThirdTabController();

}
