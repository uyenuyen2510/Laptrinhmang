/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.server;

import com.dt.project.javafx.rmi.server.service.BlockServiceImpl;
import com.dt.project.javafx.rmi.server.service.ChambreServiceImpl;
import com.dt.project.javafx.rmi.server.service.LoginServiceImpl;
import com.dt.project.javafx.rmi.server.service.StudentServiceImpl;
import com.dt.project.javafx.rmi.server.utilities.DatabaseConnection;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        DatabaseConnection.getConnection();

        //You can setting the hosname IP address on your source code
        System.setProperty("java.rmi.server.hostname", "localhost");

        Registry registry = LocateRegistry.createRegistry(8070);

        LoginServiceImpl loginService = new LoginServiceImpl();
        StudentServiceImpl studentService = new StudentServiceImpl();
        BlockServiceImpl blockServiceImpl = new BlockServiceImpl();
        ChambreServiceImpl chambreServiceImpl = new ChambreServiceImpl();

        registry.bind("loginService", loginService);
        registry.bind("studentService", studentService);
        registry.bind("blockService", blockServiceImpl);
        registry.bind("chambreService", chambreServiceImpl);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/dt/project/javafx/rmi/server/login/login.fxml"));

        Parent root = loader.load();

        stage.setScene(new Scene(root));

        stage.initStyle(StageStyle.UNDECORATED);

        stage.setTitle("Database RMI");

        stage.show();

        System.out.println("Server is running");
    }

    @Override
    public void stop() throws Exception {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
