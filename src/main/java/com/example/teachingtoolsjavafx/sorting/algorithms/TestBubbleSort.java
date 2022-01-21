//package com.example.teachingtoolsjavafx.sorting.algorithms;
//
//import com.example.teachingtoolsjavafx.bars.Bar;
//
//import java.util.ArrayList;
//
//public class TestBubbleSort{
//    public Bar[] randomBars;
//    private int currentIndex = 0;
//    private int traversingIndex = 1;
//    private Bar[] list;
//    private ArrayList<Bar[]> listOfLists = new ArrayList<>();
//
//
//
//    public void sort() {
//        while (currentIndex < randomBars.length) {
//            while (traversingIndex < randomBars.length - currentIndex) {
//                if (randomBars[traversingIndex - 1].getSize() >= randomBars[traversingIndex].getSize()) {
//                    // The previous bar is bigger, so the swap function is called:
//                    swap(traversingIndex - 1, traversingIndex);
//                }
//                traversingIndex++;
//
//                // Add the new random bars l;ist to the liist of lists
//                // Even if a bar has not swapped, it will be added, as this is a step in the algorithm that
//                // needs to be displayed
//                list = new Bar[randomBars.length];
//                for (int i = 0; i < list.length; i++) {
//                    list[i] = randomBars[i];
//                }
//                listOfLists.add(list);
//
//            }
//            traversingIndex = 1;
//            currentIndex++;
//        }
//    }
//}
