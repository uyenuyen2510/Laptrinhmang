/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.server.charts.linechart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LineChart.fxml"));

        Parent root = loader.load();

        stage.setScene(new Scene(root));

        stage.initStyle(StageStyle.UNDECORATED);

        stage.show();

    }

    @Override
    public void stop() throws Exception {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
