package com.example.teachingtoolsjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(Main.class.getResource("welcome-screen.fxml"));
        Scene scene = new Scene(root, 550, 350);
        stage.setTitle("Teaching Tools");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
