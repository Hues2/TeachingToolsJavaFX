package com.example.teachingtoolsjavafx.sorting.algorithms;

import com.example.teachingtoolsjavafx.bars.Bar;

public class BubbleSort extends SortingAlgorithm {
    private int currentIndex = 0;
    private int traversingIndex = 1;
    private Bar[] list;


    public BubbleSort(Bar[] randomBars){
        this.randomBars = randomBars;
        list = new Bar[randomBars.length];
        System.arraycopy(randomBars, 0, list, 0, list.length);
        listOfLists.add(list);
    }

    @Override
    // This method sorts the list using bubble sort
    public void sort(){
        timer.startTime = System.nanoTime();
        while (currentIndex < randomBars.length) {
            while (traversingIndex < randomBars.length - currentIndex) {
                if (randomBars[traversingIndex - 1].getSize() >= randomBars[traversingIndex].getSize()) {
                    // The previous bar is bigger, so the swap function is called:
                    swap(traversingIndex - 1, traversingIndex);
                    thirdTabController.setSwappedStringBuilder(randomBars[traversingIndex].getSize(), randomBars[traversingIndex - 1].getSize());
                }else{
                    // Here it didn't swap the numbers
                    thirdTabController.setNotSwappedStringBuilder(randomBars[traversingIndex - 1].getSize(), randomBars[traversingIndex].getSize());

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
        timer.endTime = System.nanoTime();
    }

//    @Override
//    public String getTotalTime() {
//        return timer.getTotalTimeInMS();
//    }

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
