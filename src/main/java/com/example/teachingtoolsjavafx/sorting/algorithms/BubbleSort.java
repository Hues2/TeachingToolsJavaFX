package com.example.teachingtoolsjavafx.sorting.algorithms;

import com.example.teachingtoolsjavafx.bars.Bar;
import java.util.ArrayList;


public class BubbleSort implements SortingAlgorithm {
    private Bar[] randomBars;
    private int currentIndex = 0;
    private int traversingIndex = 1;
    private Bar[] list;
    private ArrayList<Bar[]> listOfLists = new ArrayList<>();



    public BubbleSort(Bar[] randomBars){
        this.randomBars = randomBars;
        list = new Bar[randomBars.length];
        System.arraycopy(randomBars, 0, list, 0, list.length);
        listOfLists.add(list);
    }

    @Override
    // This method sorts the list using insertion sort
    public void sort(){

        while (currentIndex < randomBars.length) {
            while (traversingIndex < randomBars.length - currentIndex) {
                if (randomBars[traversingIndex - 1].getSize() >= randomBars[traversingIndex].getSize()) {
                    // The previous bar is bigger, so the swap function is called:
                    swap(traversingIndex - 1, traversingIndex);
                }
                traversingIndex++;

                // Add the new random bars list to the list of lists
                // Even if a bar has not swapped, it will be added, as this is a step in the algorithm that
                // needs to be displayed
                list = new Bar[randomBars.length];
                System.arraycopy(randomBars, 0, list, 0, list.length);
                listOfLists.add(list);

            }
            traversingIndex = 1;
            currentIndex++;
        }
    }

    @Override
    public void swap(int indexA, int indexB){
        Bar tempBar = randomBars[indexA];
        randomBars[indexA] = randomBars[indexB];
        randomBars[indexB] = tempBar;
    }


    @Override
    public ArrayList<Bar[]> getSteps(){
        return listOfLists;
    }

    @Override
    public String definitionText(){
        return "Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order. The pass through the list is repeated until the list is sorted. The algorithm, which is a comparison sort, is named for the way smaller or larger elements \"bubble\" to the top of the list.\n" +
                "\n" +
                "\n" +
                "\n" +
                "PSEUDO CODE:\n" +
                "\n" +
                "bubbleSort(A : list of sortable items)\n" +
                "    n := length(A)\n" +
                "    repeat\n" +
                "        swapped := false\n" +
                "        for i := 1 to n-1 inclusive do\n" +
                "            /* if this pair is out of order */\n" +
                "            if A[i-1] > A[i] then\n" +
                "                /* swap them and remember something changed */\n" +
                "                swap(A[i-1], A[i])\n" +
                "                swapped := true\n" +
                "            end if\n" +
                "        end for\n" +
                "    until not swapped\n" +
                "end";
    }
}
