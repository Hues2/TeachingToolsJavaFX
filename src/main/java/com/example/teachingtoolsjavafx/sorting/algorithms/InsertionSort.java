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
        list = new Bar[randomBars.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = randomBars[i];
        }
        listOfLists.add(list);
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

    @Override
    public String definitionText() {
        return "Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time. It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.\n" +
                "\n" +
                "\n" +
                "\n" +
                "PSEUDO CODE:\n" +
                "\n" +
                "i ← 1\n" +
                "while i < length(A)\n" +
                "    j ← i\n" +
                "    while j > 0 and A[j-1] > A[j]\n" +
                "        swap A[j] and A[j-1]\n" +
                "        j ← j - 1\n" +
                "    end while\n" +
                "    i ← i + 1\n" +
                "end while";
    }
}
