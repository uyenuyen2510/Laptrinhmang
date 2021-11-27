/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.client.login;

import com.dt.project.javafx.rmi.api.entity.login;
import com.dt.project.javafx.rmi.api.service.LoginService;
import com.dt.project.javafx.rmi.client.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Bureau
 */
public class LoginController implements Initializable {

    private LoginService loginService;

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;

    private Main main;

    static login login;

    static login login2;

    @FXML
    JFXButton btnLogin;

    @FXML
    public void Close(MouseEvent mouseEvent) {
        try {
            ((Stage) (((ImageView) mouseEvent.getSource()).getScene().getWindow())).close();
        } catch (Exception e) {

        }
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loginService = (LoginService) Main.registry.lookup("loginService");
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void onLogin(ActionEvent actionEvent) throws RemoteException {
        String user = username.getText();
        String pass = password.getText();
        login = loginService.Login(user, pass);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/dt/project/javafx/rmi/client/Dashboard/Dashboard.fxml"));

            Parent root1;
            root1 = (Parent) fxmlLoader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UNDECORATED);

            if (null != login) {
                ((Node) (actionEvent.getSource())).getScene().getWindow().hide();

                stage.show();
                Notifications notify = Notifications.create()
                        .title("User Logged In")
                        .text(username.getText() + " has successfully logged in")
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_RIGHT)
                        .darkStyle();
                notify.showInformation();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.getDialogPane().getStyleClass().add("dialog-pane");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.setTitle("Login Error!");
                alert.setHeaderText("Login Failed!");
                alert.setContentText("Username/Password does not match");
                username.setText("");
                password.setText("");
                username.requestFocus();
                alert.showAndWait();
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static login getLogin() {
        return login;
    }

}
