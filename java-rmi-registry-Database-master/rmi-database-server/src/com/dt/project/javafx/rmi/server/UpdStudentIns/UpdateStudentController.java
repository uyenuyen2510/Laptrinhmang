/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.server.UpdStudentIns;

import com.dt.project.javafx.rmi.api.entity.inscription;
import com.dt.project.javafx.rmi.server.StudentProgress.StudentProgressController;
import com.dt.project.javafx.rmi.server.utilities.InscriptionRe;
import static com.dt.project.javafx.rmi.server.utilities.UnivRe.getUniv;
import static com.dt.project.javafx.rmi.server.utilities.UnivRe.getUnivById;
import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Bureau
 */
public class UpdateStudentController implements Initializable {

    inscription inscription;

    @FXML
    TextField N_bac;
    @FXML
    TextField N_ins_univ;
    @FXML
    JFXDatePicker Date_bac;
    @FXML
    ComboBox<String> W_bac;
    @FXML
    ComboBox<String> code;
    @FXML
    ComboBox<String> Anne;
    @FXML
    Label univ;
    @FXML
    Label Date_Ins;

    @FXML
    Label lblAdmission;

    @FXML
    AnchorPane pnlMain;

    @FXML
    StackPane updateStudentView;

    public UpdateStudentController() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inscription = StudentProgressController.getInscription();
        
        N_bac.setText(inscription.getN_bac());

        Date_bac.setValue(inscription.getDate_bac());

        N_ins_univ.setText(inscription.getN_ins_univ());

        Date_Ins.setText(inscription.getDate_Res().toString());

        for (int i = 1; i <= 48; i++) {
            W_bac.getItems().add(i + "");
        }
        W_bac.setValue("1");
        Anne.getItems().addAll("1 anne", "2 anne", "3 anne", "master 1", "master 2", "doctora");
        Anne.setValue("1 anne");

        code.getItems().addAll(getUniv());

    }

    @FXML
    public void univSname() {
        univ.setText(getUnivById(code.getValue()));
    }

//    @FXML
//    public void txtNicValidation(KeyEvent evt) {
//        if (!txtNic.getText().matches("\\b\\d{9}[Vv]\\b")) {
//            System.out.println("Wrong");
//        } else {
//            System.out.println("Correct");
//        }
//    }
    @FXML
    public void btnRegisterEvent(ActionEvent evt) {
        inscription.setN_bac(N_bac.getText());
        inscription.setDate_bac(Date_bac.getValue());
        inscription.setW_bac(W_bac.getValue());
        inscription.setN_ins_univ(N_ins_univ.getText());
        inscription.setCode(code.getValue());
        inscription.setAnne(Anne.getValue());

        if (isFieldValid()) {
            InscriptionRe.updateInscription(inscription);

            Notifications notify = Notifications.create()
                    .title("student Update")
                    .text(" student successfully  Update")
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.BOTTOM_RIGHT)
                    .darkStyle();
            notify.showInformation();
        }

//        StudentProgressController.getUpdateStudentView().close;
    }

    private boolean isFieldValid() {
        String errorMessage = "";
        if (N_bac.getText() == null || N_bac.getText().isEmpty()) {
            errorMessage += "No valid first name!\n";
        }

        if (Date_bac.getValue() == null) {
            errorMessage += "No valid birth date!\n";
        }

        if (N_ins_univ.getText() == null || N_ins_univ.getText().isEmpty()) {
            errorMessage += "No valid first name!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }

}
