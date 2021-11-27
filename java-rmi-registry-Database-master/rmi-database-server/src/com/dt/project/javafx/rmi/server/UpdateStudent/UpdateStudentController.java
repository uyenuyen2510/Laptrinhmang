/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.server.UpdateStudent;

import com.dt.project.javafx.rmi.api.entity.student;
import com.dt.project.javafx.rmi.server.StudentProgress.StudentProgressController;
import static com.dt.project.javafx.rmi.server.utilities.StudentRe.updateStudent;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Bureau
 */
public class UpdateStudentController implements Initializable {

    @FXML
    TextField txtName;
    @FXML
    TextField txtTel1;
    @FXML
    TextField txtTel2;
    @FXML
    TextField txtAddress;
    @FXML
    TextField txtNic;
    @FXML
    TextField txtPic;
    @FXML
    JFXDatePicker dtPkr;
    @FXML
    JFXRadioButton rdBtnMale;
    @FXML
    JFXRadioButton rdBtnFemale;

    @FXML
    Label lblAdmission;

    @FXML
    AnchorPane pnlMain;

    private File filePic;

    student student;

    @FXML
    StackPane updateStudentView;

    public UpdateStudentController() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        student = StudentProgressController.getSudent();
        txtName.setText(student.getName());
        txtTel1.setText(student.getTel1());
        txtTel2.setText(student.getTel2());
        txtAddress.setText(student.getAddress());
        txtNic.setText(student.getNic());
        txtPic.setText(student.getImg());
        dtPkr.setValue(student.getDob());

    }

    @FXML
    public void txtTel1Validation(KeyEvent evt) {
        if (txtTel1.getText().toCharArray().length == 11) {
            if (!txtTel1.getText().matches("\\d{3}-\\d{7}")) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        }
    }

    @FXML
    public void txtTel2Validation(KeyEvent evt) {
        if (txtTel2.getText().toCharArray().length == 11) {
            if (!txtTel2.getText().matches("\\d{3}-\\d{7}")) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        }
//        RegistrationCardController.number=txtNic.getText();
//        System.out.println(RegistrationCardController.number);
    }

    @FXML
    public void txtNicValidation(KeyEvent evt) {
        if (!txtNic.getText().matches("\\b\\d{9}[Vv]\\b")) {
            System.out.println("Wrong");
        } else {
            System.out.println("Correct");
        }
    }

    @FXML
    public void btnBrowseAction(ActionEvent actionEvent) {
        filePic = showOpenFile();
        if (filePic != null) {
            txtPic.setText(filePic.getAbsolutePath());
        }
    }

    public String gender() {
        String gender = null;
        if (rdBtnMale.isSelected()) {
            gender = rdBtnMale.getText();
        } else {
            gender = rdBtnFemale.getText();
        }
        return gender;
    }

    @FXML
    public void btnRegisterEvent(ActionEvent evt) {
        student = new student();
        student.setName(txtName.getText());
        student.setGender(gender());
        student.setDob(dtPkr.getValue());
        student.setAge(24);
        student.setNic(txtNic.getText());
        student.setTel1(txtTel1.getText());
        student.setTel2(txtTel2.getText());
        student.setAddress(txtAddress.getText());
        student.setImg(txtPic.getText());
        if (isFieldValid()) {
            updateStudent(student);

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
        if (txtName.getText() == null || txtName.getText().isEmpty()) {
            errorMessage += "No valid first name!\n";
        }

        if (dtPkr.getValue() == null) {
            errorMessage += "No valid birth date!\n";
        }

        if (txtNic.getText() == null || txtNic.getText().isEmpty()) {
            errorMessage += "No valid first name!\n";
        }

        if (txtTel1.getText() == null || txtTel1.getText().isEmpty()) {
            errorMessage += "No valid first name!\n";
        }

        if (txtTel2.getText() == null || txtTel2.getText().isEmpty()) {
            errorMessage += "No valid first name!\n";
        }

        if (txtAddress.getText() == null || txtAddress.getText().isEmpty()) {
            errorMessage += "No valid first name!\n";
        }

        if (txtPic.getText() == null || txtPic.getText().isEmpty()) {
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

    public File showOpenFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Student Photo");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG (*.png)", "*.png"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPEG (*.jpeg)", "*.jpeg"));
        return fileChooser.showOpenDialog(pnlMain.getScene().getWindow());
    }

}
