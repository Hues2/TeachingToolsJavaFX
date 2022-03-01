package com.example.teachingtoolsjavafx.sorting.algorithms;

import com.example.teachingtoolsjavafx.bars.Bar;
import com.example.teachingtoolsjavafx.controllers.ThirdTabController;

import java.util.ArrayList;

public abstract class SortingAlgorithm {
     public Bar[] randomBars;
     public ArrayList<Bar[]> listOfLists = new ArrayList<>();
     public abstract void sort();
     public void swap(int indexA, int indexB){
          Bar tempBar = randomBars[indexA];
          randomBars[indexA] = randomBars[indexB];
          randomBars[indexB] = tempBar;
     }


     public ArrayList<Bar[]> getSteps(){
          return listOfLists;
     }

     public abstract String definitionText();
     public ThirdTabController thirdTabController = new ThirdTabController();

     public AlgorithmTimer timer = new AlgorithmTimer();
     public String getTotalTime(){
          return timer.getTotalTimeInMS();
     }
}
