package com.example.teachingtoolsjavafx.sorting.algorithms;

import com.example.teachingtoolsjavafx.bars.Bar;

public class InsertionSort extends SortingAlgorithm{

    private int currentIndex = 0;

    public InsertionSort(Bar[] randomBars){
        this.randomBars = randomBars;
        list = new Bar[randomBars.length];
        System.arraycopy(randomBars, 0, list, 0, list.length);
        listOfLists.add(list);
    }


    @Override
    public void sort() {
        timer.setStart(System.nanoTime());
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
        timer.setEndTime(System.nanoTime());
    }

    @Override
    public String definitionText() {
        return """
                Formal Definition:
                
                Insertion sort is the sorting mechanism where the sorted array is built having one item at a time. The array elements are compared with each other sequentially and then arranged simultaneously in some particular order.\s


                Informal Definition:
                
                This algorithm creates a sorted sub-array one element at a time. It gets an element from the unsorted sub-array and "inserts" it into the correct position within the sorted sub-array.
                
                

                PSEUDO CODE:

                INSERTION-SORT(A)
                   for i = 1 to n
                   	key ← A [i]
                    	j ← i – 1
                  	 while j > = 0 and A[j] > key
                   		A[j+1] ← A[j]
                   		j ← j – 1
                   	End while\s
                   	A[j+1] ← key
                  End for\s
                  
                  
                Definition and pseudocode provided by InterviewBit, https://www.interviewbit.com/tutorial/quicksort-algorithm/
  
                  """;
    }
}
