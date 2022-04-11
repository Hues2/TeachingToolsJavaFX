package com.example.teachingtoolsjavafx.sorting.algorithms;

import com.example.teachingtoolsjavafx.bars.Bar;

public class SelectionSort extends SortingAlgorithm{
    private int currentIndex = 0;
    private int traversingIndex;

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
            traversingIndex = currentIndex + 1;
            int min = currentIndex;
            while (traversingIndex < randomBars.length){
                if (randomBars[traversingIndex].getSize() < randomBars[currentIndex].getSize()){
                    min = traversingIndex;
                    swap(currentIndex, min);
                    thirdTabController.setSwappedStringBuilder(randomBars[currentIndex].getSize(), randomBars[min].getSize());
                }else{
                    thirdTabController.setNotSwappedStringBuilder(randomBars[currentIndex].getSize(), randomBars[min].getSize());
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

    @Override
    public String definitionText() {
        return """
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
