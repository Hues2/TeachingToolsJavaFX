package com.example.teachingtoolsjavafx.sorting.algorithms;

import com.example.teachingtoolsjavafx.bars.Bar;

public class InsertionSort extends SortingAlgorithm{

    private int currentIndex = 0;
    //private Bar[] list;

    public InsertionSort(Bar[] randomBars){
        this.randomBars = randomBars;
        list = new Bar[randomBars.length];
        System.arraycopy(randomBars, 0, list, 0, list.length);
        listOfLists.add(list);
    }


    @Override
    public void sort() {
        timer.startTime = System.nanoTime();
        while (currentIndex < randomBars.length) {
            int traversingIndex = currentIndex;
            while (traversingIndex > 0 && randomBars[traversingIndex].getSize() < randomBars[traversingIndex - 1].getSize()) {
                swap(traversingIndex, traversingIndex - 1);
                thirdTabController.setSwappedStringBuilder(randomBars[traversingIndex - 1].getSize(), randomBars[traversingIndex].getSize());
                traversingIndex--;
                list = new Bar[randomBars.length];
                System.arraycopy(randomBars, 0, list, 0, list.length);
                listOfLists.add(list);
            }
            currentIndex++;
        }
        timer.endTime = System.nanoTime();
    }

    @Override
    public String definitionText() {
        return """
                Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time. It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.



                PSEUDO CODE:

                i ← 1
                while i < length(A)
                    j ← i
                    while j > 0 and A[j-1] > A[j]
                        swap A[j] and A[j-1]
                        j ← j - 1
                    end while
                    i ← i + 1
                end while""";
    }

}
