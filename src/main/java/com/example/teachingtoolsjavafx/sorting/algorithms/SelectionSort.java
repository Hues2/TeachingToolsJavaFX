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
    }

    @Override
    public String definitionText() {
        return """
                Selection sort is an in-place comparison sorting algorithm. It has an O(n2) time complexity, which makes it inefficient on large lists, and generally performs worse than the similar insertion sort.



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
                }""";
    }
}
