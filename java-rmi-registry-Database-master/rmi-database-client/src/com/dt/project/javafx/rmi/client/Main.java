/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author dell
 */
public class Main extends Application {

    public static Registry registry;

    @Override
    public void start(Stage stage) throws Exception {

        registry = LocateRegistry.getRegistry("localhost", 8070);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/dt/project/javafx/rmi/client/login/login.fxml"));

        Parent root = loader.load();

        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);

        stage.setTitle("Database RMI");

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
