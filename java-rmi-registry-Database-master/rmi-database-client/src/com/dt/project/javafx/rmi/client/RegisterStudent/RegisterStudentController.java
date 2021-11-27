/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.client.RegisterStudent;

import com.dt.project.javafx.rmi.api.entity.block;
import com.dt.project.javafx.rmi.api.entity.chambre;
import com.dt.project.javafx.rmi.api.entity.login;
import com.dt.project.javafx.rmi.api.entity.student;
import com.dt.project.javafx.rmi.api.service.BlockService;
import com.dt.project.javafx.rmi.api.service.ChambreService;
import com.dt.project.javafx.rmi.api.service.StudentService;
import com.dt.project.javafx.rmi.client.Main;
import com.dt.project.javafx.rmi.client.login.LoginController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Bureau
 */
public class RegisterStudentController implements Initializable {

    @FXML
    JFXComboBox<Integer> ch;

    login user;

    StudentService studentService;
    ChambreService chambreService;

    List<chambre> ListChambre;
    @FXML
    TableView<chambre> tableChambre;
    @FXML
    TableColumn<chambre, Integer> idC, idBlockC;
    @FXML
    TableColumn<chambre, Integer> idStudentC;
    @FXML
    TableColumn<chambre, String> nameStudentC;

    List<student> ListStudent;
    @FXML
    TableView<student> tableStudent;
    @FXML
    TableColumn<student, Integer> sidC, statuC;
    @FXML
    TableColumn<student, String> nameC;
    @FXML
    TableColumn<student, String> tel1C;
    @FXML
    TableColumn<student, String> tel2C;
    @FXML
    TableColumn<student, String> addressC;

    @FXML
    JFXTextField rechR;

    BlockService blockService;
    block block;

    @FXML
    Label txtnomBlock;
    @FXML
    Label txtnbrChambre;
    @FXML
    Label txtnbrPCCh;
    @FXML
    Label txtnbrChambreDis;
    @FXML
    Label txtnbrPlaceDis;
    @FXML
    Label isEvailble;
    int idBlock;

    @FXML
    JFXButton btnRem;

    public void nbrChambreDis() {

        txtnbrChambreDis.setText("");
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

    }

    @FXML
    public void add() throws RemoteException {
        if (index < 0) {
            return;
        }

        if (statuC.getCellData(index).equals(0)) {
            chambre chambre = new chambre();
            chambre.setId(ch.getValue());
            chambre.setIdStudent(sidC.getCellData(index));
            chambre.setNameStudent(nameC.getCellData(index));
            chambre.setIdBlock(idBlock);

            if (chambreService.getChambreByIdStudent(sidC.getCellData(index)) != null) {

                Notifications notify = Notifications.create()
                        .title("Student not add")
                        .text("Student is Reside in chambre" + (chambreService.getChambreByIdStudent(sidC.getCellData(index)).getId()))
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_RIGHT)
                        .darkStyle();
                notify.showInformation();

            } else {
                if (isEvailble.getText().equals(true)) {

                    chambreService.insertChambre(chambre);

                    Notifications notify = Notifications.create()
                            .title("Student add")
                            .text("Student has successfully add ")
                            .hideAfter(Duration.seconds(3))
                            .position(Pos.BOTTOM_RIGHT)
                            .darkStyle();
                    notify.showInformation();
                    studentService.setStatu(1, sidC.getCellData(index));
                    index = -1;
                } else {
                    Notifications notify = Notifications.create()
                            .title("Student not add")
                            .text("is plan")
                            .hideAfter(Duration.seconds(3))
                            .position(Pos.BOTTOM_RIGHT)
                            .darkStyle();
                    notify.showInformation();
                }
            }
        } else {
            Notifications notify = Notifications.create()
                    .title("Student not add")
                    .text("Studrent is reside in block" + chambreService.getChambreByIdStudent(sidC.getCellData(index)).getIdBlock())
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.BOTTOM_RIGHT)
                    .darkStyle();
            notify.showInformation();
        }

    }

    int index2 = -1;

    public void getSelectedItems2() {

        index2 = tableChambre.getSelectionModel().getSelectedIndex();

    }

    @FXML
    public void remove() throws RemoteException {
        if (index2 < 0) {
            return;
        }
        chambreService.deleteStudent(idC.getCellData(index2), idStudentC.getCellData(index2));
        Notifications notify = Notifications.create()
                .title("Student removed")
                .text("Student has successfully removed ")
                .hideAfter(Duration.seconds(3))
                .position(Pos.BOTTOM_RIGHT)
                .darkStyle();
        notify.showInformation();
        studentService.setStatu(0, sidC.getCellData(index));
        index2 = -1;
    }

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
            btnRem.setDisable(false);
        }
        if (user.getPrivilege() == 2) {
            btnRem.setDisable(true);
        }

        try {
            blockService = (BlockService) Main.registry.lookup("blockService");
            studentService = (StudentService) Main.registry.lookup("studentService");
            chambreService = (ChambreService) Main.registry.lookup("chambreService");

//           
            block = blockService.getBlockById(LoginController.getLogin().getIdBlock());
            idBlock = block.getId();
            txtnomBlock.setText(block.getNomBlock());
            txtnbrChambre.setText(block.getNbrChambre() + "");
            txtnbrPCCh.setText(block.getNbrPCCh() + "");

            ListStudent = studentService.getstudent();

            sidC.setCellValueFactory(new PropertyValueFactory<>("sid"));
            nameC.setCellValueFactory(new PropertyValueFactory<>("name"));
            tel1C.setCellValueFactory(new PropertyValueFactory<>("tel1"));
            tel2C.setCellValueFactory(new PropertyValueFactory<>("tel2"));
            addressC.setCellValueFactory(new PropertyValueFactory<>("address"));
            statuC.setCellValueFactory(new PropertyValueFactory<>("statu"));

            tableStudent.getItems().setAll(ListStudent);
            for (int i = 1; i <= Integer.parseInt(txtnbrChambre.getText()); i++) {
                ch.getItems().add(i);
            }

            ch.setValue(1);

            count();
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(RegisterStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void count() throws RemoteException {
        int j = 0;
        int nbr = Integer.parseInt(txtnbrChambre.getText());
        for (int i = 1; i <= nbr; i++) {
            if ((4 - chambreService.getChambreById(i, LoginController.getLogin().getIdBlock()).size()) > 0) {
                j++;
            }
        }
        txtnbrChambreDis.setText(j + "");
    }

    @FXML
    public void sel() throws RemoteException {
        int c;
        ListChambre = chambreService.getChambreById(ch.getValue(), LoginController.getLogin().getIdBlock());
        idC.setCellValueFactory(new PropertyValueFactory<>("id"));
        idBlockC.setCellValueFactory(new PropertyValueFactory<>("idBlock"));
        idStudentC.setCellValueFactory(new PropertyValueFactory<>("idStudent"));
        nameStudentC.setCellValueFactory(new PropertyValueFactory<>("nameStudent"));

        tableChambre.getItems().setAll(ListChambre);

        c = (4 - chambreService.getChambreById(ch.getValue(), LoginController.getLogin().getIdBlock()).size());

        System.out.println(chambreService.getChambreById(ch.getValue(), LoginController.getLogin().getIdBlock()).size());
        txtnbrPlaceDis.setText(c + "");
        if (c > 0) {
            isEvailble.setText("true");
        } else {
            isEvailble.setText("false");
        }

    }
}
