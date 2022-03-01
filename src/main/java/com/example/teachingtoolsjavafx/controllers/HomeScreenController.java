package com.example.teachingtoolsjavafx.controllers;

import com.example.teachingtoolsjavafx.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


public class HomeScreenController{


    // This method will take the user to the sorting algorithms scene
    @FXML
    protected void goToSortingAlgorithms(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("sorting-algorithm-screen.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Sorting Algorithms");
        stage.setResizable(false);
        stage.show();
    }

    // Add more algorithm types here
}

