package com.example.teachingtoolsjavafx.sorting.algorithms;

import com.example.teachingtoolsjavafx.bars.Bar;

public class BubbleSort extends SortingAlgorithm {
    private int currentIndex = 0;
    private int traversingIndex = 1;


    public BubbleSort(Bar[] randomBars){
        this.randomBars = randomBars;
        list = new Bar[randomBars.length];
        System.arraycopy(randomBars, 0, list, 0, list.length);
        listOfLists.add(list);
    }

    @Override
    // This method sorts the list using bubble sort
    public void sort(){
        timer.setStart(System.nanoTime());
        while (currentIndex < randomBars.length) {
            while (traversingIndex < randomBars.length - currentIndex) {
                if (randomBars[traversingIndex - 1].getSize() >= randomBars[traversingIndex].getSize()) {
                    bubbleSwapped(randomBars[traversingIndex].getSize(), randomBars[traversingIndex - 1].getSize());
                    // The previous bar is bigger, so the swap function is called:
                    swap(traversingIndex - 1, traversingIndex);
                }else{
                    // Here it didn't swap the numbers
                    bubbleNotSwapped(randomBars[traversingIndex].getSize(), randomBars[traversingIndex - 1].getSize());

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
        timer.setEndTime(System.nanoTime());
    }


    @Override
    public String definitionText(){
        return """
                Formal Definition:
                
                Bubble sort, also referred to as comparison sort, is a simple sorting algorithm that repeatedly goes through the list, compares adjacent elements and swaps them if they are in the wrong order.

                
                Informal Definition:
                
                This algorithm checks if the current element in the list is bigger than the next element. If it is bigger, then they will swap, and it repeats this process until the biggest element is at the end of the list, and then it repeats the whole process until the whole list is sorted.
                
                

                PSEUDO CODE:

                bubbleSort( Arr[], totat_elements)
                  \s
                   for i = 0 to total_elements - 1 do:
                      swapped = false
                		
                      for j = 0 to total_elements - i - 2 do:
                     \s
                         /* compare the adjacent elements */  \s
                         if Arr[j] > Arr[j+1] then
                            /* swap them */
                            swap(Arr[j], Arr[j+1])		\s
                            swapped = true
                         end if
                        \s
                      end for
                     \s
                      /*if no number was swapped that means\s
                      array is sorted now, break the loop.*/
                     \s
                      if(not swapped) then
                         break
                      end if
                     \s
                   end for
                  \s
                end
                
                
                Definition and pseudocode provided by InterviewBit, https://www.interviewbit.com/tutorial/quicksort-algorithm/

                """;
    }

    private void bubbleSwapped(int traversing, int beforeTraversing) {
        if (traversing == beforeTraversing){
            this.stringBuilder = new StringBuilder("\nThe current bar has a size of " + beforeTraversing + ", which is the" +
                    " same size as the adjacent bar. The default action for this scenario is to swap the bars anyway.\n");
        }else{
            this.stringBuilder = new StringBuilder("\nThe current bar has a size of " + beforeTraversing + ", which is bigger" +
                    " than the adjacent bar, which has a size of " + traversing + ", therefore they will swap\n");
        }
        addStep();
    }

    private void bubbleNotSwapped(int traversing, int beforeTraversing) {
        this.stringBuilder = new StringBuilder("\nThe current bar has a size of " + beforeTraversing + ", which is smaller" +
                " than the adjacent bar, which has a size of " + traversing + ", therefore they will NOT swap\n");
        addStep();
    }

    @Override
    public void addStep() {
        stepExplanations.add(this.stringBuilder);
    }
}
