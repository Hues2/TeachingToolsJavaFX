package com.example.teachingtoolsjavafx.sorting.algorithms;

import com.example.teachingtoolsjavafx.Main;
import com.example.teachingtoolsjavafx.bars.Bar;
import com.example.teachingtoolsjavafx.bars.RandomBars;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class SortingAnimationController {

    public static final int gapBetweenBars = 10;
    public static int heightOfHBox = 75;
    public static int numberOfBars = 30;
    public static int animationPaneWidth = 672;
    public static int animationPaneHeight = 625;
    private Bar[] bars;
    private static int counter = 0;

    @FXML
    private Pane animationPane;


    public SortingAnimationController(){
        bars = RandomBars.getRandomBars(numberOfBars);

    }

    @FXML
    private void initialize() {
        animationPane.getChildren().addAll(Arrays.asList(bars));
    }




    public void sortButton() throws InterruptedException {
        BubbleSort bubbleSort = new BubbleSort(bars);
        ArrayList<Bar[]> listOfLists = bubbleSort.getSteps();

        Timeline timeLine = new Timeline(
                new KeyFrame(Duration.seconds(0.01), (ActionEvent event) -> {
                    for (int i = 0; i < numberOfBars; i++) {
                        listOfLists.get(counter)[i].setX(i * (animationPaneWidth / numberOfBars));
                        listOfLists.get(counter)[i].setFill(Color.CRIMSON);
                        RandomBars.setBarDimensions(listOfLists.get(counter)[i], bars.length);
                    }
                    animationPane.getChildren().clear();
                    animationPane.getChildren().addAll(Arrays.asList(listOfLists.get(counter)));
                    counter++;
                })
        );
        timeLine.setCycleCount(listOfLists.size());
        timeLine.setOnFinished((ActionEvent e) -> {
            counter = 0;
        });
        timeLine.play();
    }












//    public void sortButton() throws InterruptedException {
//        BubbleSort bubbleSort = new BubbleSort(bars);
//        ArrayList<Bar[]> listOfLists = bubbleSort.getSteps();
//        for (int i = 0; i < listOfLists.get(2).length; i++) {
//            System.out.println(listOfLists.get(2)[i].getSize());
//        }
//
//        ArrayList<Transition> listOfTransitions = new ArrayList<>();
//
//
//        while (counter <= listOfLists.size() - 1){
//            for (int i = 0; i < listOfLists.get(counter).length; i++) {
//                listOfLists.get(counter)[i].setX(i * (animationPaneWidth / numberOfBars));
//                listOfLists.get(counter)[i].setFill(Color.CRIMSON);
//                RandomBars.setBarDimensions(listOfLists.get(counter)[i], bars.length);
//            }
//
//
//            ParallelTransition transition = new ParallelTransition();
//            transition = colourBar(listOfLists.get(counter), Color.AQUA);
//
//            listOfTransitions.add(transition);
//            counter++;
//            System.out.println("Another Loop Finished");
//            System.out.println(listOfTransitions.size());
//        }
//
//
//        SequentialTransition sq = new SequentialTransition();
//
//        sq.getChildren().addAll(listOfTransitions);
//
//
//        sq.setOnFinished(e -> {
//            System.out.println("Finished Sequential Transition");
//        });
//
//        sq.play();
//
//
//    }



    ParallelTransition colourBar(Bar[] listOfBars, Color colour){
        ParallelTransition parallelTransition = new ParallelTransition();

        for (int i = 0; i < listOfBars.length; i++) {
            FillTransition fillTransition = new FillTransition();
            fillTransition.setShape(listOfBars[i]);
            fillTransition.setToValue(colour);
            fillTransition.setDuration(Duration.millis(100));
            parallelTransition.getChildren().add(fillTransition);
        }
        return parallelTransition;
    }








    // Home button functionality
    @FXML
    protected void backHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("welcome-screen.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
