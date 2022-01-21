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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;

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

    private Timeline timeLine;
    private ArrayList<Bar[]> listOfLists;


    @FXML
    private Pane animationPane;
    @FXML
    private Button homeButton;
    @FXML
    private ChoiceBox choiceBox;
    @FXML
    private Slider speedSlider;
    @FXML
    private Button sortButton;
    @FXML
    private Button pauseButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button previousButton;
    @FXML
    private Button resetButton;


    private static SortingAlgorithm sortingAlgorithm;

    // This method runs and initialises all the FXML items
    @FXML
    private void initialize() {

        bars = RandomBars.getRandomBars(numberOfBars);
        animationPane.getChildren().addAll(Arrays.asList(bars));

        // Add all the sorting options
        choiceBox.getItems().add(new BubbleSort(bars));
        choiceBox.getSelectionModel().select(0);

        choiceBox.setConverter(new StringConverter<SortingAlgorithm>() {
            @Override
            public String toString(SortingAlgorithm sortingAlgorithm) {
                if (sortingAlgorithm == null){
                    return "";
                }else{
                    return sortingAlgorithm.getClass().getSimpleName();
                }
            }
            @Override
            public SortingAlgorithm fromString(String s) {
                return null;
            }
        });
        sortingAlgorithm = (SortingAlgorithm) choiceBox.getSelectionModel().getSelectedItem();
        sortingAlgorithm.sort();
        listOfLists = sortingAlgorithm.getSteps();
    }



    public SortingAnimationController(){}





    // This method runs when the sort button is clicked
    public void sortButton() throws InterruptedException {
//        sortingAlgorithm = (SortingAlgorithm) choiceBox.getSelectionModel().getSelectedItem();
//        sortingAlgorithm.sort();
        listOfLists = sortingAlgorithm.getSteps();
        System.out.println(listOfLists.size());
        // When the user starts to sort the list, make the home button disabled
        homeButton.setDisable(true);
        choiceBox.setDisable(true);
        speedSlider.setDisable(true);
        sortButton.setDisable(true);
        pauseButton.setDisable(false);
        nextButton.setDisable(true);
        previousButton.setDisable(true);
        resetButton.setDisable(true);


        timeLine = new Timeline(
                new KeyFrame(Duration.seconds(speedSlider.getValue()), (ActionEvent event) -> {
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
        timeLine.setCycleCount(listOfLists.size() - counter);
        timeLine.setOnFinished((ActionEvent e) -> {
            // Here the list is finished sorting
            counter = 0;
            homeButton.setDisable(false);
            sortButton.setDisable(true);
            pauseButton.setDisable(true);
        });
        timeLine.play();
    }



    public void pause(){
        timeLine.stop();
        sortButton.setDisable(false);
        nextButton.setDisable(false);
        previousButton.setDisable(false);
        homeButton.setDisable(false);
        resetButton.setDisable(false);
        pauseButton.setDisable(true);
        speedSlider.setDisable(false);
        choiceBox.setDisable(false);
    }

    public void next(){

        if (counter < listOfLists.size() - 1){
            sortButton.setDisable(false);
            nextButton.setDisable(false);
            previousButton.setDisable(false);
            homeButton.setDisable(false);
            resetButton.setDisable(false);
            pauseButton.setDisable(true);
            speedSlider.setDisable(false);
            choiceBox.setDisable(false);

            counter++;

            if (counter == listOfLists.size() - 1){
                nextButton.setDisable(true);
            }
            for (int i = 0; i < numberOfBars; i++) {
                listOfLists.get(counter)[i].setX(i * (animationPaneWidth / numberOfBars));
                listOfLists.get(counter)[i].setFill(Color.CRIMSON);
                RandomBars.setBarDimensions(listOfLists.get(counter)[i], bars.length);
            }
            animationPane.getChildren().clear();
            animationPane.getChildren().addAll(Arrays.asList(listOfLists.get(counter)));
        }else{
            sortButton.setDisable(false);
            nextButton.setDisable(false);
            previousButton.setDisable(true);
            homeButton.setDisable(false);
            resetButton.setDisable(false);
            pauseButton.setDisable(true);
            speedSlider.setDisable(false);
            choiceBox.setDisable(false);
        }

    }


    public void previous(){
        if (counter > 0){
            sortButton.setDisable(false);
            nextButton.setDisable(false);
            previousButton.setDisable(false);
            homeButton.setDisable(false);
            resetButton.setDisable(false);
            pauseButton.setDisable(true);
            speedSlider.setDisable(false);
            choiceBox.setDisable(false);

            counter--;
            if(counter == 0){
                previousButton.setDisable(true);
            }
            for (int i = 0; i < numberOfBars; i++) {
                listOfLists.get(counter)[i].setX(i * (animationPaneWidth / numberOfBars));
                listOfLists.get(counter)[i].setFill(Color.CRIMSON);
                RandomBars.setBarDimensions(listOfLists.get(counter)[i], bars.length);
            }
            animationPane.getChildren().clear();
            animationPane.getChildren().addAll(Arrays.asList(listOfLists.get(counter)));
        }else{
            sortButton.setDisable(false);
            nextButton.setDisable(false);
            previousButton.setDisable(true);
            homeButton.setDisable(false);
            resetButton.setDisable(false);
            pauseButton.setDisable(true);
            speedSlider.setDisable(false);
            choiceBox.setDisable(false);
        }

    }



    public void reset(){
        counter = 0;
        listOfLists = new ArrayList<>();
        Bar[] newBars = RandomBars.getRandomBars(numberOfBars);
        choiceBox = new ChoiceBox();
        choiceBox.getItems().add(new BubbleSort(newBars));
        choiceBox.getSelectionModel().select(0);
        sortingAlgorithm = (SortingAlgorithm) choiceBox.getSelectionModel().getSelectedItem();
        sortingAlgorithm.sort();
        listOfLists = sortingAlgorithm.getSteps();
        animationPane.getChildren().clear();
        animationPane.getChildren().addAll(Arrays.asList(newBars));
    }









    // Home button functionality
    @FXML
    protected void backHome(ActionEvent event) throws IOException {
        counter = 0;
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("welcome-screen.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
