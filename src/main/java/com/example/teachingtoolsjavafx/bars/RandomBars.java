package com.example.teachingtoolsjavafx.bars;

import com.example.teachingtoolsjavafx.sorting.algorithms.SortingAnimationController;
import javafx.scene.paint.Color;

import java.util.Random;

public class RandomBars {

    // The numberOfBars will be determined by the spinner
    // For now it is default to 30
    public static Bar[] getRandomBars(int numberOfBars){
        Bar[] listOfBars = new Bar[numberOfBars];
        Random randomNumber = new Random();

        for (int i = 0; i < numberOfBars; i++) {
            listOfBars[i] = new Bar(1 + randomNumber.nextInt(numberOfBars));
            // A bar is a rectangle, so it has the method .setX and setFill
            listOfBars[i].setX(i * (SortingAnimationController.animationPaneWidth / numberOfBars));
            listOfBars[i].setFill(Color.CRIMSON);
            setBarDimensions(listOfBars[i], listOfBars.length);
        }
        return listOfBars;
    }

    private static void setBarDimensions(Bar bar, int n) {
        bar.setWidth(SortingAnimationController.animationPaneWidth / n -
                SortingAnimationController.gapBetweenBars);
        bar.setHeight(((SortingAnimationController.animationPaneHeight - SortingAnimationController.heightOfHBox)
                / n) * bar.getSize());
    }

}
