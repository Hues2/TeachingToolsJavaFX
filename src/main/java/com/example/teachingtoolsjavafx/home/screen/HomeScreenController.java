package com.example.teachingtoolsjavafx.home.screen;

import com.example.teachingtoolsjavafx.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class HomeScreenController{

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button pathingAlgorithmsButton;

    // This method will take the user to the sorting algorithms scene
    @FXML
    protected void goToSortingAlgorithms(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("sorting-algorithm-screen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    // There is no pathing algorithm implemented yet, so it just changes the name of the button;
    @FXML
    protected void goToPathingAlgorithms(){
        pathingAlgorithmsButton.setText("Not Available");
    }
}


//// This class is the home screen
//public class HomeScreen extends BorderPane {
//    public static final int WINDOW_WIDTH = 550;
//    public static final int WINDOW_HEIGHT = 350;
//
//
//    private Pane welcomeScreen;
//    private Label welcomeText;
//    private HBox rowOfButtons;
//    private Button sortingAlgorithmsButton;
//    private Button pathingAlgorithmsButton;
//
//
//
//    public HomeScreen(){
//        // Create the panels, buttons, etc...
//        this.welcomeScreen = new Pane();
//        this.rowOfButtons = new HBox();
//        this.welcomeText = new Label();
//        welcomeText.setFont(new Font(20));
//        welcomeText.setText("Welcome to Teaching Tools");
//        welcomeText.setTextFill(Color.WHITE);
//
//
//        // Position the items
//        this.setCenter(welcomeScreen);
//        this.setBottom(rowOfButtons);
//
//        // Align the items
//        rowOfButtons.setAlignment(Pos.CENTER);
//
//
//
//        // Create all the button options and add the buttons to the VBox
//        this.sortingAlgorithmsButton = new Button("Sorting Algorithms");
//        this.pathingAlgorithmsButton = new Button("Pathing Algorithms");
//        rowOfButtons.getChildren().add(sortingAlgorithmsButton);
//        rowOfButtons.getChildren().add(pathingAlgorithmsButton);
//
//        for(Node n : rowOfButtons.getChildren()){
//            rowOfButtons.setMargin(n, new Insets(50, 50, 100, 50));
//        }
//
//    }

//}
