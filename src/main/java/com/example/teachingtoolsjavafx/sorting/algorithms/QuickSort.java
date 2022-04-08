package com.example.teachingtoolsjavafx.sorting.algorithms;

import com.example.teachingtoolsjavafx.bars.Bar;

public class QuickSort extends SortingAlgorithm{

    public QuickSort(Bar[] randomBars){
        this.randomBars = randomBars;
        list = new Bar[randomBars.length];
        System.arraycopy(randomBars, 0, list, 0, list.length);
        listOfLists.add(list);
    }


    @Override
    public void sort() {
        timer.setStart(System.nanoTime());
        recursiveSort(randomBars, 0, randomBars.length - 1);
        timer.setEndTime(System.nanoTime());
    }

    int partition(Bar[] randomBars, int low, int high) {
        int pivot = randomBars[high].getSize();
        int i = (low-1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (randomBars[j].getSize() <= pivot) {
                i++;

                swap(i,j);
                thirdTabController.setSwappedStringBuilder(randomBars[i].getSize(),randomBars[j].getSize());
                list = new Bar[randomBars.length];
                System.arraycopy(randomBars, 0, list, 0, list.length);
                listOfLists.add(list);
            }
        }

        swap(i + 1, high);
        thirdTabController.setSwappedStringBuilder(randomBars[i + 1].getSize(), randomBars[high].getSize());
        list = new Bar[randomBars.length];
        System.arraycopy(randomBars, 0, list, 0, list.length);
        listOfLists.add(list);

        return i+1;
    }

    void recursiveSort(Bar[] randomBars, int low, int high) {
        if (low < high) {
            int midIndex = partition(randomBars, low, high);

            recursiveSort(randomBars, low, midIndex-1);
            recursiveSort(randomBars, midIndex+1, high);
        }
    }

    @Override
    public String definitionText() {
        return """
                 The Quick Sort is one of the most efficient sorting algorithms and is based on the splitting of an array (partition) into smaller ones and swapping (exchange) based on the comparison with 'pivot' element selected.



                PSEUDO CODE:

                QuickSort(arr[], low, high)
                 {
                     if (low < high)
                     {
                         // pivot_index is partitioning index, arr[pivot_index] is now at correct place in sorted array
                         pivot_index = partition(arr, low, high);
                 
                         quickSort(arr, low, pivot_index - 1);  // Before pivot_index
                         quickSort(arr, pivot_index + 1, high); // After pivot_index
                     }
                 }
                 
                 Definition and pseudocode provided by InterviewBit, https://www.interviewbit.com/tutorial/quicksort-algorithm/
                 """;
    }
}
