/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.server.login;

import com.dt.project.javafx.rmi.server.utilities.AdminRe;
import static com.dt.project.javafx.rmi.server.utilities.HistoriqueRe.insertHistorique;
import com.dt.project.javafx.rmi.server.utilities.admin;
import com.dt.project.javafx.rmi.server.utilities.historiqueR;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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

    @FXML
    private Label lblDate, lblTime;

    @FXML
    AnchorPane root;

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;

    public static admin User;

    @FXML
    JFXButton btnLogin;

    public static admin getUser() {
        return User;
    }

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
        initClock();

        root.setOnKeyReleased(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {

            }
        });
    }

    @FXML
    public void onLogin(ActionEvent actionEvent) throws RemoteException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/dt/project/javafx/rmi/server/Dashboard/Dashboard.fxml"));
            Parent root1;
            root1 = (Parent) fxmlLoader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UNDECORATED);
            String user = username.getText();
            String pass = password.getText();

            User = AdminRe.Login(user, pass);

            if (User == null) {
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
            } else {
                ((Node) (actionEvent.getSource())).getScene().getWindow().hide();

                stage.show();
                Notifications notify = Notifications.create()
                        .title("User Logged In")
                        .text(username.getText() + " has successfully logged in")
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_RIGHT)
                        .darkStyle();
                notify.showInformation();
                insertHistorique(new historiqueR(0, User.getId(), "127.0.0.1", username.getText() + " has logged in", LocalDate.now()));
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    double x = 0, y = 0;

    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    void dragged(MouseEvent event) {

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    public void initClock() { // initialize Clock
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            lblDate.setText(dateFormat.format(date));
            dateFormat = new SimpleDateFormat("HH:mm:ss");
            lblTime.setText(dateFormat.format(date));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

}
