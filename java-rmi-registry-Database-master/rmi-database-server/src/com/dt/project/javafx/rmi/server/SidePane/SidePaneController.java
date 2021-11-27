/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.server.SidePane;

import com.dt.project.javafx.rmi.server.Dashboard.DashboardController;
import static com.dt.project.javafx.rmi.server.login.LoginController.User;
import com.dt.project.javafx.rmi.server.utilities.admin;
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
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Bureau
 */
public class SidePaneController implements Initializable {

    admin admin;

    @FXML
    private StackPane root;
    @FXML
    private JFXButton btnReg;
    @FXML
    private JFXButton btnBlock;
    @FXML
    private JFXButton btnProf;
    @FXML
    private JFXButton btnEmp;
    @FXML
    private JFXButton btnUniv;
    @FXML
    private JFXButton btnHome;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if ("1".equals(User.getType())) {
            btnHome.setDisable(false);
            btnReg.setDisable(false);
            btnBlock.setDisable(false);
            btnProf.setDisable(false);
            btnEmp.setDisable(false);
            btnUniv.setDisable(false);
        }

        if ("2".equals(User.getType())) {
            btnHome.setDisable(false);
            btnReg.setDisable(false);
            btnBlock.setDisable(true);
            btnProf.setDisable(false);
            btnEmp.setDisable(true);
            btnUniv.setDisable(true);
        }

        if ("3".equals(User.getType())) {
            btnHome.setDisable(false);
            btnReg.setDisable(true);
            btnBlock.setDisable(true);
            btnProf.setDisable(false);
            btnEmp.setDisable(true);
            btnUniv.setDisable(true);
        }

    }

//    @FXML
//    void btnProEmp(ActionEvent event) {
//
//        try {
//            root = FXMLLoader.load(getClass().getResource("/com/dt/project/javafx/rmi/server/Employes/Employes.fxml"));
//            DashboardController.rootPane.getChildren().setAll(root);
//        } catch (IOException ex) {
//            Logger.getLogger(SidePaneController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        DashboardController.humburgAction(event);
//    }
    @FXML
    void btnProHome(ActionEvent event) {

        try {
            root = FXMLLoader.load(getClass().getResource("/com/dt/project/javafx/rmi/server/home/home.fxml"));
            DashboardController.rootPane.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(SidePaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        DashboardController.humburgAction(event);
    }

    @FXML
    void btnProUniv(ActionEvent event) {

        try {
            root = FXMLLoader.load(getClass().getResource("/com/dt/project/javafx/rmi/server/Univ/Univ.fxml"));
            DashboardController.rootPane.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(SidePaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        DashboardController.humburgAction(event);
    }

    @FXML
    void btnProAction(ActionEvent event) {

        try {
            root = FXMLLoader.load(getClass().getResource("/com/dt/project/javafx/rmi/server/StudentProgress/StudentProgress.fxml"));
            DashboardController.rootPane.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(SidePaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        DashboardController.humburgAction(event);
    }

    @FXML
    void btnBlock(ActionEvent event) {

        try {
            root = FXMLLoader.load(getClass().getResource("/com/dt/project/javafx/rmi/server/Block/block.fxml"));
            DashboardController.rootPane.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(SidePaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        DashboardController.humburgAction(event);
    }

    @FXML
    void btnRegAction(ActionEvent event) {

        try {
            root = FXMLLoader.load(getClass().getResource("/com/dt/project/javafx/rmi/server/RegisterStudent/RegisterStudent.fxml"));
            DashboardController.rootPane.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(SidePaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        DashboardController.humburgAction(event);

    }

    @FXML
    void btnReportsAction(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/com/dt/project/javafx/rmi/server/Reports/Reports.fxml"));
            DashboardController.rootPane.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(SidePaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        DashboardController.humburgAction(event);
    }

}
