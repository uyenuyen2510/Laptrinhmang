/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.client.SidePane;

import com.dt.project.javafx.rmi.api.entity.login;
import com.dt.project.javafx.rmi.api.service.LoginService;
import com.dt.project.javafx.rmi.client.Dashboard.DashboardController;
import com.dt.project.javafx.rmi.client.login.LoginController;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Bureau
 */
public class SidePaneController implements Initializable {

    private AnchorPane dash;

    @FXML
    JFXButton btnReg;
    @FXML
    JFXButton btnprof;
    @FXML
    JFXButton btnHome;

    login user;

    LoginService loginService;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user = LoginController.getLogin();
        if (user.getPrivilege() == 1) {
            btnHome.setDisable(false);
            btnReg.setDisable(false);
            btnprof.setDisable(false);
        }
        if (user.getPrivilege() == 2) {
            btnHome.setDisable(false);
            btnReg.setDisable(false);
            btnprof.setDisable(false);
        }
    }

    @FXML
    void btnProHome(ActionEvent event) {

        try {
            dash = FXMLLoader.load(getClass().getResource("/com/dt/project/javafx/rmi/client/Home/home.fxml"));
            DashboardController.rootPane.getChildren().setAll(dash);
        } catch (IOException ex) {
            Logger.getLogger(SidePaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        DashboardController.humburgAction(event);
    }

    @FXML
    void btnProAction(ActionEvent event) {

        try {
            dash = FXMLLoader.load(getClass().getResource("/com/dt/project/javafx/rmi/client/StudentProgress/StudentProgress.fxml"));
            DashboardController.rootPane.getChildren().setAll(dash);
        } catch (IOException ex) {
            Logger.getLogger(SidePaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        DashboardController.humburgAction(event);
    }

    @FXML
    void btnRegAction(ActionEvent event) {

        try {
            dash = FXMLLoader.load(getClass().getResource("/com/dt/project/javafx/rmi/client/RegisterStudent/RegisterStudent.fxml"));
            DashboardController.rootPane.getChildren().setAll(dash);
        } catch (IOException ex) {
            Logger.getLogger(SidePaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        DashboardController.humburgAction(event);

    }

    @FXML
    void btnReportsAction(ActionEvent event) {
        try {
            dash = FXMLLoader.load(getClass().getResource("/com/dt/project/javafx/rmi/client/Reports/Reports.fxml"));
            DashboardController.rootPane.getChildren().setAll(dash);
        } catch (IOException ex) {
            Logger.getLogger(SidePaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        DashboardController.humburgAction(event);
    }

}
