package com.example.teachingtoolsjavafx.controllers;

import com.example.teachingtoolsjavafx.Main;
import com.example.teachingtoolsjavafx.bars.Bar;
import com.example.teachingtoolsjavafx.bars.RandomBars;
import com.example.teachingtoolsjavafx.sorting.algorithms.BubbleSort;
import com.example.teachingtoolsjavafx.sorting.algorithms.InsertionSort;
import com.example.teachingtoolsjavafx.sorting.algorithms.SortingAlgorithm;
import javafx.animation.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private static SortingAlgorithm sortingAlgorithm;
    private List<SortingAlgorithm> listOfAlgorithms;
    private int indexOfCombo = 0;
    public static Color barColour = Color.LIGHTSEAGREEN;

    
    @FXML
    private Pane animationPane;
    @FXML
    private Button homeButton;
    @FXML
    private ComboBox<SortingAlgorithm> comboBox;
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
    @FXML
    private Label algorithmLabel;
    @FXML
    private ComboBox<Integer> numberOfBarsComboBox;
    @FXML
    private TextArea tab1TextArea;
    @FXML
    private TextArea tab2TextArea;
    @FXML
    private ColorPicker colourPicker;



    // This method runs and initialises all the FXML items
    @FXML
    private void initialize() {
        barColour = colourPicker.getValue();
        newListButtons();
        bars = new Bar[numberOfBars];
        bars = RandomBars.getRandomBars(numberOfBars);

        listOfAlgorithms = new ArrayList<>();
        listOfAlgorithms.add(new BubbleSort(bars));
        listOfAlgorithms.add(new InsertionSort(bars));

        // Adds all the possible algorithms to the combo box
        setUpAlgorithmsComboBox();

        // Adds all the possible options to the number of bars combo box
        setUpNumberOfBarsComboBox();
        numberOfBars = numberOfBarsComboBox.getSelectionModel().getSelectedItem();

        sortingAlgorithm = comboBox.getSelectionModel().getSelectedItem();
        sortingAlgorithm.sort();
        listOfLists = sortingAlgorithm.getSteps();
        animationPane.getChildren().addAll(Arrays.asList(listOfLists.get(counter)));
        algorithmLabel.setText(sortingAlgorithm.getClass().getSimpleName());
        setUpTab1TextArea();
        tab2TextArea.appendText(getList());

    }


    private void setUpAlgorithmsComboBox(){
        comboBox.setItems(FXCollections.observableArrayList(listOfAlgorithms));
        comboBox.getSelectionModel().select(indexOfCombo);

        comboBox.setConverter(new StringConverter<>() {
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
    }

    private void setUpNumberOfBarsComboBox(){
        numberOfBarsComboBox.getItems().add(10);
        numberOfBarsComboBox.getItems().add(30);
        numberOfBarsComboBox.getItems().add(50);
        numberOfBarsComboBox.getItems().add(60);
        numberOfBarsComboBox.getSelectionModel().select(1);
    }

    private void setUpTab1TextArea(){
        tab1TextArea.setText(sortingAlgorithm.definitionText());
    }



    // This method gets the list to be printed out on the second tab
    private String getList(){
        StringBuilder list = new StringBuilder("\nStep " + counter + ":");
        list.append("\n[");
        for (Bar bar : listOfLists.get(counter)) {
            list.append(" ").append(bar.getSize()).append(",");
        }
        list.append("]\n");
        return list.toString();
    }


    // This method runs when the sort button is clicked
    public void sortButton(){
        homeButton.setDisable(true);
        comboBox.setDisable(true);
        speedSlider.setDisable(true);
        sortButton.setDisable(true);
        pauseButton.setDisable(false);
        nextButton.setDisable(true);
        previousButton.setDisable(true);
        resetButton.setDisable(true);
        comboBox.setDisable(true);
        numberOfBarsComboBox.setDisable(true);

        setUpTimeLine();

    }


    public void setUpTimeLine(){
        timeLine = new Timeline(
                new KeyFrame(Duration.seconds(speedSlider.getValue()), (ActionEvent event) -> {
                    setNewPositionsAndRepaint();
                    tab2TextArea.appendText(getList());
                    counter++;
                })
        );
        timeLine.setCycleCount(listOfLists.size() - counter);
        timeLine.setOnFinished((ActionEvent e) -> {
            // Here the list is finished sorting
            counter--;
            homeButton.setDisable(false);
            sortButton.setDisable(true);
            pauseButton.setDisable(true);
            resetButton.setDisable(false);
            previousButton.setDisable(false);
            nextButton.setDisable(true);
            comboBox.setDisable(false);
            numberOfBarsComboBox.setDisable(false);
        });
        timeLine.play();
    }


    public void pause(){
        timeLine.stop();
        enableAllExceptPauseButton();
    }

    public void next(){
        if (counter < listOfLists.size() - 1){
            enableAllExceptPauseButton();

            counter++;

            if (counter == listOfLists.size() - 1){
                nextButton.setDisable(true);
                previousButton.setDisable(false);
            }
            setNewPositionsAndRepaint();
            tab2TextArea.appendText(getList());
        }else{
            sortButton.setDisable(false);
            nextButton.setDisable(false);
            previousButton.setDisable(true);
            homeButton.setDisable(false);
            resetButton.setDisable(false);
            pauseButton.setDisable(true);
            speedSlider.setDisable(false);
            comboBox.setDisable(false);
            numberOfBarsComboBox.setDisable(false);
        }
    }


    public void previous(){
        if (counter > 0){
            enableAllExceptPauseButton();

            counter--;

            setNewPositionsAndRepaint();
            tab2TextArea.appendText(getList());
        }
        if (counter == 0){
            newListButtons();
        }
    }

    private void setNewPositionsAndRepaint(){
        for (int i = 0; i < numberOfBars; i++) {
            listOfLists.get(counter)[i].setX(i * (animationPaneWidth / numberOfBars));
            listOfLists.get(counter)[i].setFill(barColour);
            RandomBars.setBarDimensions(listOfLists.get(counter)[i], bars.length);
        }
        animationPane.getChildren().clear();
        animationPane.getChildren().addAll(Arrays.asList(listOfLists.get(counter)));
    }

    // This method is called when the algorithm is changed in the combo box
    // And also when the New Bars button is clicked
    public void reset(){
        animationPane.getChildren().clear();
        listOfLists = new ArrayList<>();
        counter = 0;
        barColour = colourPicker.getValue();
        numberOfBars = numberOfBarsComboBox.getSelectionModel().getSelectedItem();
        bars = RandomBars.getRandomBars(numberOfBars);
        indexOfCombo = comboBox.getSelectionModel().getSelectedIndex();
        if (indexOfCombo == 0){
            sortingAlgorithm = new BubbleSort(bars);
        }else if (indexOfCombo == 1){
            sortingAlgorithm = new InsertionSort(bars);
        }
        sortingAlgorithm.sort();
        listOfLists = sortingAlgorithm.getSteps();
        animationPane.getChildren().addAll(Arrays.asList(listOfLists.get(0)));
        algorithmLabel.setText(sortingAlgorithm.getClass().getSimpleName());

        // Change the tabs text areas
        setUpTab1TextArea();
        tab2TextArea.clear();
        tab2TextArea.appendText(getList());

        // Set up the buttons to be disabled or enabled
        newListButtons();
    }


    // This method changes the colour of the bars
    // It doesn't change the position of any bar, just the colour
    public void changeColour(){
        barColour = colourPicker.getValue();
        for (Bar[] listOfBars : listOfLists) {
            for (int j = 0; j < numberOfBars; j++) {
                listOfBars[j].setFill(SortingAnimationController.barColour);
            }
        }
        animationPane.getChildren().clear();
        animationPane.getChildren().addAll(Arrays.asList(listOfLists.get(0)));
    }


    // Home button functionality
    @FXML
    protected void backHome(ActionEvent event) throws IOException {
        reset();
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("welcome-screen.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    // Enables and disables buttons for specific situations
    private void newListButtons(){
        sortButton.setDisable(false);
        nextButton.setDisable(false);
        previousButton.setDisable(true);
        homeButton.setDisable(false);
        resetButton.setDisable(false);
        pauseButton.setDisable(true);
        speedSlider.setDisable(false);
        comboBox.setDisable(false);
        numberOfBarsComboBox.setDisable(false);
    }

    private void enableAllExceptPauseButton(){
        sortButton.setDisable(false);
        nextButton.setDisable(false);
        previousButton.setDisable(false);
        homeButton.setDisable(false);
        resetButton.setDisable(false);
        pauseButton.setDisable(true);
        speedSlider.setDisable(false);
        comboBox.setDisable(false);
        numberOfBarsComboBox.setDisable(false);
    }

}
