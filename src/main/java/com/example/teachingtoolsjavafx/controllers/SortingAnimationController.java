package com.example.teachingtoolsjavafx.controllers;

import com.example.teachingtoolsjavafx.Main;
import com.example.teachingtoolsjavafx.bars.Bar;
import com.example.teachingtoolsjavafx.bars.RandomBars;
import com.example.teachingtoolsjavafx.sorting.algorithms.*;
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
import java.util.*;


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
    private SecondTabController secondTabController;
    private ThirdTabController thirdTabController;
    private ButtonController buttonController;



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
    private TextArea tab3TextArea;
    @FXML
    private ColorPicker colourPicker;
    @FXML
    private Label timerLabel;



    // This method runs and initialises all the FXML items
    @FXML
    private void initialize() {
        buttonController = new ButtonController(homeButton, comboBox, speedSlider, sortButton,
                pauseButton, nextButton, previousButton, resetButton, numberOfBarsComboBox);
        barColour = colourPicker.getValue();
        buttonController.newListButtons();
        bars = new Bar[numberOfBars];
        bars = RandomBars.getRandomBars(numberOfBars);

        listOfAlgorithms = new ArrayList<>();
        listOfAlgorithms.add(new BubbleSort(bars));
        listOfAlgorithms.add(new InsertionSort(bars));
        listOfAlgorithms.add(new SelectionSort(bars));
        listOfAlgorithms.add(new QuickSort(bars));

        // Adds all the possible algorithms to the combo box
        setUpAlgorithmsComboBox();

        // Adds all the possible options to the number of bars combo box
        setUpNumberOfBarsComboBox();
        numberOfBars = numberOfBarsComboBox.getSelectionModel().getSelectedItem();

        sortingAlgorithm = comboBox.getSelectionModel().getSelectedItem();

        // This method calls the sort method of the algorithm, displays the bars at index 'counter' and sets the text.
        sortAndDisplay();
        setUpTab1TextArea();
        secondTabController = new SecondTabController(listOfLists);
        thirdTabController = sortingAlgorithm;
        tab2TextArea.appendText(secondTabController.getList(counter));
        tab3TextArea.appendText(thirdTabController.getExplanation(counter));

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

    // Possibilities of number of bars
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
                    // When timeline.stop() is called in the pause button action
                    // it pauses this action event
                    setNewPositionsAndRepaint();

                    tab2TextArea.appendText(secondTabController.getList(counter));

                    if (!(sortingAlgorithm instanceof QuickSort)){
                        if (thirdTabController.getExplanation(counter) != null){
                            tab3TextArea.appendText(thirdTabController.getExplanation(counter));
                        }
                    }

                    counter++;
                })
        );

        // The timeline action event will run the same amount of times as steps of the algorithm are left
        timeLine.setCycleCount(listOfLists.size() - counter);
        // It will only be finished when it has reached the max cycle count
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



    @SuppressWarnings("IntegerDivisionInFloatingPointContext")
    private void setNewPositionsAndRepaint(){
        for (int i = 0; i < numberOfBars; i++) {
            listOfLists.get(counter)[i].setX(i * (animationPaneWidth / numberOfBars));
            listOfLists.get(counter)[i].setFill(barColour);
            RandomBars.setBarDimensions(listOfLists.get(counter)[i], bars.length);
        }

        // Get the difference between the current list of bars vs the next one
        for (int i = 0; i < numberOfBars; i++) {
            if (counter > 0 && counter != listOfLists.size() - 1){
                if (listOfLists.get(counter)[i] != listOfLists.get(counter + 1)[i]){
                    listOfLists.get(counter)[i].setFill(Color.GREEN);
                }
            }
        }

        animationPane.getChildren().clear();
        animationPane.getChildren().addAll(Arrays.asList(listOfLists.get(counter)));
    }


    public void pause(){
        timeLine.stop();
        buttonController.enableAllExceptPauseButton();
    }

    public void next(){
        if (counter < listOfLists.size() - 1){
            buttonController.enableAllExceptPauseButton();

            counter++;

            if (counter == listOfLists.size() - 1){
                nextButton.setDisable(true);
                previousButton.setDisable(false);
            }
            setNewPositionsAndRepaint();
            tab2TextArea.appendText(secondTabController.getList(counter));
            if (!(sortingAlgorithm instanceof QuickSort)){
                if (thirdTabController.getExplanation(counter) != null){
                    tab3TextArea.appendText(thirdTabController.getExplanation(counter));
                }
            }


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
            buttonController.enableAllExceptPauseButton();

            counter--;

            setNewPositionsAndRepaint();
            tab2TextArea.appendText(secondTabController.getList(counter));
            if (!(sortingAlgorithm instanceof QuickSort)) {
                tab3TextArea.appendText(thirdTabController.getExplanation(counter));
            }

        }
        if (counter == 0){
            buttonController.newListButtons();
        }
    }


    /*
     This method is called when the algorithm is changed in the combo box,
     when the New Bars button is clicked,
     and when the back home button is clicked
     */
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
        } else if (indexOfCombo == 2){
            sortingAlgorithm = new SelectionSort(bars);
        }else if (indexOfCombo == 3){
            sortingAlgorithm = new QuickSort(bars);
        }

        sortAndDisplay();
        // Change the tabs text areas
        secondTabController = new SecondTabController(listOfLists);
        thirdTabController = sortingAlgorithm;

        setUpTab1TextArea();

        tab2TextArea.clear();
        tab2TextArea.appendText(secondTabController.getList(counter));

        tab3TextArea.clear();
        if (!(sortingAlgorithm instanceof QuickSort)){
            tab3TextArea.appendText(thirdTabController.getExplanation(counter));
        }else{
            tab3TextArea.setText("Yet to be implemented for this algorithm, as it uses recursion.");
        }


        // Set up the buttons to be disabled or enabled
        buttonController.newListButtons();
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


    private void sortAndDisplay(){
        sortingAlgorithm.sort();
        timerLabel.setText("Sorted in: " + sortingAlgorithm.getTotalTime());
        listOfLists = sortingAlgorithm.getSteps();
        animationPane.getChildren().addAll(Arrays.asList(listOfLists.get(counter)));
        algorithmLabel.setText(sortingAlgorithm.getClass().getSimpleName());
    }
}
