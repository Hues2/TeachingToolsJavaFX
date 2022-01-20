package com.example.teachingtoolsjavafx.sorting.algorithms;

import com.example.teachingtoolsjavafx.bars.Bar;
import com.example.teachingtoolsjavafx.bars.RandomBars;

import java.util.ArrayList;
import java.util.Random;

public class BubbleSort{

    public Bar[] randomBars;
    private int currentIndex = 0;
    private int traversingIndex = 1;
    public Bar[] list = new Bar[SortingAnimationController.numberOfBars];
    public ArrayList<Bar[]> listOfLists = new ArrayList<Bar[]>();


    BubbleSort(){
        this.randomBars = RandomBars.getRandomBars(SortingAnimationController.numberOfBars);
        sort();
    }


    // This method sorts the list using insertion sort
    public void sort(){
        while (currentIndex < randomBars.length) {
            while (traversingIndex < randomBars.length) {
                if (randomBars[traversingIndex - 1].getSize() >= randomBars[traversingIndex].getSize()) {
                    // The previous bar is bigger, so the swap function is called:
                    swap(traversingIndex - 1, traversingIndex);
                }
                traversingIndex++;
                list = randomBars;
                listOfLists.add(list);
            }
            traversingIndex = 1;
            currentIndex++;
        }
    }


    public void swap(int indexA, int indexB){
        Bar tempBar = randomBars[indexA];
        randomBars[indexA] = randomBars[indexB];
        randomBars[indexB] = tempBar;
    }


    public Bar[] getBars(){
        return randomBars;
    }




}
