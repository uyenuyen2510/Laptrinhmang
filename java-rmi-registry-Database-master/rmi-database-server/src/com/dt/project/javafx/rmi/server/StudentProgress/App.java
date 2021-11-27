package com.dt.project.javafx.rmi.server.StudentProgress;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("StudentProgress.fxml"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
