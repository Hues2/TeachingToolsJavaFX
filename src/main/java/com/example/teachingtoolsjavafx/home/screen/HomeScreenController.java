package com.example.teachingtoolsjavafx.home.screen;

import com.example.teachingtoolsjavafx.Main;
import com.example.teachingtoolsjavafx.sorting.algorithms.SortingAnimationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


public class HomeScreenController{

    @FXML
    private Button pathingAlgorithmsButton;

    // This method will take the user to the sorting algorithms scene
    @FXML
    protected void goToSortingAlgorithms(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("sorting-algorithm-screen.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    // There is no pathing algorithm implemented yet, so it just changes the name of the button;
    @FXML
    protected void goToPathingAlgorithms(){
        pathingAlgorithmsButton.setText("Not Available");
    }
}

