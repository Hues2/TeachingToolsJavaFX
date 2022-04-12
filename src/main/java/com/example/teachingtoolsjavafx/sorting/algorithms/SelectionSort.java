package com.example.teachingtoolsjavafx.sorting.algorithms;

import com.example.teachingtoolsjavafx.bars.Bar;

public class SelectionSort extends SortingAlgorithm {
    private int currentIndex = 0;

    public SelectionSort(Bar[] randomBars){
        this.randomBars = randomBars;
        list = new Bar[randomBars.length];
        System.arraycopy(randomBars, 0, list, 0, list.length);
        listOfLists.add(list);
    }

    @Override
    public void sort() {
        timer.setStart(System.nanoTime());
        while (currentIndex < randomBars.length - 1){
            int traversingIndex = currentIndex + 1;
            int min = currentIndex;
            while (traversingIndex < randomBars.length){
                if (randomBars[traversingIndex].getSize() < randomBars[currentIndex].getSize()){
                    min = traversingIndex;
                    selectionSwapped(randomBars[currentIndex].getSize(), randomBars[min].getSize());
                    swap(currentIndex, min);
                }else{
                    selectionNotSwapped(randomBars[min].getSize(), randomBars[traversingIndex].getSize());
                }
                list = new Bar[randomBars.length];
                System.arraycopy(randomBars, 0, list, 0, list.length);
                listOfLists.add(list);
                traversingIndex++;
            }
            currentIndex++;
        }
        timer.setEndTime(System.nanoTime());
    }

    private void selectionSwapped(int min, int traversing) {
        this.stringBuilder = new StringBuilder("\nThe current minimum bar size is " + min + ", however, the bar size that it is being compared to is " + traversing + ", as this is smaller, the bars will swap\n");
        addStep();
    }

    private void selectionNotSwapped(int min, int traversing) {
        if (min == traversing){
            this.stringBuilder = new StringBuilder("\nThe current minimum bar size is " + min + ", and the bar size that" +
                    " it is being compared to is " + traversing + ", as they are the same size, the bars will NOT swap\n");
        }else{
            this.stringBuilder = new StringBuilder("\nThe current minimum bar size is " + min + ", and the bar size that" +
                    " it is being compared to is " + traversing + ", as this is bigger, the bars will NOT swap\n");
        }
        addStep();
    }


    @Override
    public String definitionText() {
        return """
                (When two bars turn green, that means they are swapping positions. If two bars don't flash green, that means that there are no bars swapping in that instance.)
                
                
                Formal Definition:
                
                The Selection sort divides the array into two parts: sorted and unsorted. The left part is sorted subarray and the right part is unsorted subarray. Initially, sorted subarray is empty and unsorted array is the complete given array.


                Informal Definition:
                
                The selection sort compares the current number to the others in the list, if the current number is bigger than the one that it is being compared to, then they will swap positions. This way it creates a sorted subarray on the left, until the whole list is sorted.



                PSEUDO CODE:

                SelectionSort {
                   list  : array of items
                   n     : size of list
                                
                   for i = 1 to n - 1
                   /* set current element as minimum*/
                      min = i   \s
                 \s
                      /* check the element to be minimum */
                                
                      for j = i+1 to n\s
                         if list[j] < list[min] then
                            min = j;
                         end if
                      end for
                                
                      /* swap the minimum element with the current element*/
                      if indexMin != i  then
                         swap list[min] and list[i]
                      end if
                   end for
                }
                
                
                Definition and pseudocode provided by InterviewBit, https://www.interviewbit.com/tutorial/quicksort-algorithm/

                """;
    }
}
