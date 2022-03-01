package com.example.teachingtoolsjavafx.controllers;

import com.example.teachingtoolsjavafx.sorting.algorithms.SortingAlgorithm;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ButtonController {
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
    private ComboBox<Integer> numberOfBarsComboBox;

    public ButtonController(Button homeButton, ComboBox<SortingAlgorithm> comboBox, Slider speedSlider, Button sortButton, Button pauseButton, Button nextButton, Button previousButton, Button resetButton, ComboBox<Integer> numberOfBarsComboBox) {
        this.homeButton = homeButton;
        this.comboBox = comboBox;
        this.speedSlider = speedSlider;
        this.sortButton = sortButton;
        this.pauseButton = pauseButton;
        this.nextButton = nextButton;
        this.previousButton = previousButton;
        this.resetButton = resetButton;
        this.numberOfBarsComboBox = numberOfBarsComboBox;
    }


    // Enables and disables buttons for specific situations
    public void newListButtons(){
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

    public void enableAllExceptPauseButton(){
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
