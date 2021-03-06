package com.example.teachingtoolsjavafx.bars;

import com.example.teachingtoolsjavafx.controllers.SortingAnimationController;
import java.util.Random;

public class RandomBars {

    // The numberOfBars will be determined by the spinner
    // The default number is 30
    public static Bar[] getRandomBars(int numberOfBars){
        Bar[] listOfBars = new Bar[numberOfBars];
        Random randomNumber = new Random();

        for (int i = 0; i < numberOfBars; i++) {
            listOfBars[i] = new Bar(1 + randomNumber.nextInt(numberOfBars));
            // A bar is a rectangle, so it has the method .setX and setFill
            listOfBars[i].setX(i * (SortingAnimationController.animationPaneWidth / numberOfBars));
            listOfBars[i].setFill(SortingAnimationController.barColour);
            setBarDimensions(listOfBars[i], listOfBars.length);
        }
        return listOfBars;
    }

    public static void setBarDimensions(Bar bar, int numberOfBars) {
        bar.setWidth(SortingAnimationController.animationPaneWidth / numberOfBars -
                SortingAnimationController.gapBetweenBars);
        bar.setHeight(((SortingAnimationController.animationPaneHeight - SortingAnimationController.heightOfHBox)
                / numberOfBars) * bar.getSize());
    }

}
