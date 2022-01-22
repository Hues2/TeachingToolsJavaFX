module com.example.teachingtoolsjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.teachingtoolsjavafx to javafx.fxml;
    exports com.example.teachingtoolsjavafx;
    exports com.example.teachingtoolsjavafx.sorting.algorithms;
    opens com.example.teachingtoolsjavafx.sorting.algorithms to javafx.fxml;
    exports com.example.teachingtoolsjavafx.controllers;
    opens com.example.teachingtoolsjavafx.controllers to javafx.fxml;
}