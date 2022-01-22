package com.example.teachingtoolsjavafx.sorting.algorithms;

import com.example.teachingtoolsjavafx.bars.Bar;
import java.util.ArrayList;


public class InsertionSort implements SortingAlgorithm{

    public Bar[] randomBars;
    private int currentIndex = 0;
    private int traversingIndex = 1;
    private Bar[] list;
    private ArrayList<Bar[]> listOfLists = new ArrayList<>();

    public InsertionSort(Bar[] randomBars){
        this.randomBars = randomBars;
    }


    @Override
    public void sort() {
        while (currentIndex < randomBars.length) {
            traversingIndex = currentIndex;
            while (traversingIndex > 0 && randomBars[traversingIndex].getSize() < randomBars[traversingIndex - 1].getSize()) {
                swap(traversingIndex, traversingIndex - 1);
                traversingIndex--;
                list = new Bar[randomBars.length];
                for (int i = 0; i < list.length; i++) {
                    list[i] = randomBars[i];
                }
                listOfLists.add(list);
            }
            currentIndex++;
        }
    }

    @Override
    public void swap(int indexA, int indexB) {
        Bar tempBar = randomBars[indexA];
        randomBars[indexA] = randomBars[indexB];
        randomBars[indexB] = tempBar;
    }

    @Override
    public ArrayList<Bar[]> getSteps() {
        return listOfLists;
    }
}
