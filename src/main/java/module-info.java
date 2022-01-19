module com.example.teachingtoolsjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.teachingtoolsjavafx to javafx.fxml;
    exports com.example.teachingtoolsjavafx;
    exports com.example.teachingtoolsjavafx.home.screen;
    opens com.example.teachingtoolsjavafx.home.screen to javafx.fxml;
}