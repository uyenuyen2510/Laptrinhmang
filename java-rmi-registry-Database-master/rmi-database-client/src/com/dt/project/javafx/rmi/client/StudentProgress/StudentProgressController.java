/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.client.StudentProgress;

import com.dt.project.javafx.rmi.api.entity.student;
import com.dt.project.javafx.rmi.api.service.StudentService;
import com.dt.project.javafx.rmi.client.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Bureau
 */
public class StudentProgressController implements Initializable {

    private StudentService studentService;

    List<student> ListStudent;
    @FXML
    TableView<student> tableStudent;
    @FXML
    TableColumn<student, Integer> sidC;
    @FXML
    TableColumn<student, String> nameC;
    @FXML
    TableColumn<student, String> genderC;
    @FXML
    TableColumn<student, String> nicC;
    @FXML
    TableColumn<student, LocalDate> dobC;
    @FXML
    TableColumn<student, Integer> ageC;
    @FXML
    TableColumn<student, String> tel1C;
    @FXML
    TableColumn<student, String> tel2C;
    @FXML
    TableColumn<student, String> addressC;
    @FXML
    TableColumn<student, String> imgC;

    @FXML
    JFXTextField rechR;

    @FXML
    TextField txtSearch;
    @FXML
    Label txtStudentName;
    @FXML
    Label txtAddress;
    @FXML
    Label txtDob;
    @FXML
    Label txtGender;
    @FXML
    Label txtNic;
    @FXML
    Label txtSTel;
    @FXML
    Label txtSTel1;
    @FXML
    JFXButton btnSearch;
    @FXML
    ImageView imgStudent;

    @FXML
    AnchorPane anchM;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            studentService = (StudentService) Main.registry.lookup("studentService");

            ListStudent = studentService.getstudent();

            sidC.setCellValueFactory(new PropertyValueFactory<>("sid"));
            nameC.setCellValueFactory(new PropertyValueFactory<>("name"));
            genderC.setCellValueFactory(new PropertyValueFactory<>("gender"));
            dobC.setCellValueFactory(new PropertyValueFactory<>("dob"));
            ageC.setCellValueFactory(new PropertyValueFactory<>("age"));
            nicC.setCellValueFactory(new PropertyValueFactory<>("nic"));
            tel1C.setCellValueFactory(new PropertyValueFactory<>("tel1"));
            tel2C.setCellValueFactory(new PropertyValueFactory<>("tel2"));
            addressC.setCellValueFactory(new PropertyValueFactory<>("address"));
            imgC.setCellValueFactory(new PropertyValueFactory<>("img"));

            tableStudent.getItems().setAll(studentService.getstudent());

        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(StudentProgressController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnSearchAction(ActionEvent event) {

    }

    @FXML
    public void rechercherR() {
        rechR.textProperty().addListener((Observable observable) -> {
            if (rechR.textProperty().get().isEmpty()) {
                boolean setAll = tableStudent.getItems().setAll(ListStudent);
                return;
            }
            ObservableList<student> tableE1 = FXCollections.observableArrayList();
            ObservableList<TableColumn<student, ?>> cols = tableStudent.getColumns();
            for (int i = 0; i < ListStudent.size(); i++) {
                for (int j = 0; j < cols.size(); j++) {
                    TableColumn col = cols.get(j);
                    String cellValue = col.getCellData(ListStudent.get(i)).toString();
                    cellValue = cellValue.toLowerCase();
                    if (cellValue.contains(rechR.getText().toLowerCase()) && cellValue.startsWith(rechR.getText().toLowerCase())) {
                        tableE1.add(ListStudent.get(i));
                        break;
                    }
                }
            }
            tableStudent.setItems(tableE1);
        });
    }

    int index = -1;

    public void getSelectedItems() {
        index = tableStudent.getSelectionModel().getSelectedIndex();

        if (index <= -1) {
            return;
        }

        txtStudentName.setText(nameC.getCellData(index));
        txtAddress.setText(addressC.getCellData(index));
        txtDob.setText(dobC.getCellData(index).toString());
        txtGender.setText(genderC.getCellData(index));
        txtNic.setText(nicC.getCellData(index));
        txtSTel.setText(tel1C.getCellData(index));
        txtSTel1.setText(tel2C.getCellData(index));
        imgStudent.setImage(new Image(imgC.getCellData(index)));

    }

}
