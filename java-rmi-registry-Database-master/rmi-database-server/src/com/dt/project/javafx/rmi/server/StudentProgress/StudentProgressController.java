/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.server.StudentProgress;

import com.dt.project.javafx.rmi.api.entity.inscription;
import com.dt.project.javafx.rmi.api.entity.student;
import static com.dt.project.javafx.rmi.server.login.LoginController.User;
import static com.dt.project.javafx.rmi.server.utilities.HistoriqueRe.insertHistorique;
import com.dt.project.javafx.rmi.server.utilities.InscriptionRe;
import com.dt.project.javafx.rmi.server.utilities.StudentRe;
import com.dt.project.javafx.rmi.server.utilities.historiqueR;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class StudentProgressController implements Initializable {

    public static student getSudent() {
        return student;
    }

    public static inscription getInscription() {
        return inscription;
    }

    @FXML
    private StackPane root;

    static student student;

    static inscription inscription;

    private ObservableList<student> ListStudent;
    @FXML
    private TableView<student> tableStudent;
    @FXML
    private TableColumn<student, Integer> sidC, ageC, statuC;
    @FXML
    private TableColumn<student, String> nameC, genderC, tel1C, nicC, tel2C, addressC, imgC;
    @FXML
    private TableColumn<student, LocalDate> dobC;

    private ObservableList<inscription> ListInscription;
    @FXML
    private TableView<inscription> tableInscription;
    @FXML
    private TableColumn<inscription, Integer> idC, idStudentC;
    @FXML
    private TableColumn<inscription, String> N_bacC, W_bacC, N_ins_univC, feliereC, codeC, AnneC;
    @FXML
    private TableColumn<inscription, LocalDate> Date_ResC, Date_bacC;

    @FXML
    private JFXTextField rechR;

    @FXML
    private TextField txtSearch;
    @FXML
    private Label txtStudentName, txtAddress, txtDob, txtGender, txtNic, txtSTel, txtSTel1;

    @FXML
    private JFXButton btnSearch;
    @FXML
    private JFXButton btndel1;
    @FXML
    private JFXButton btndel2;
    @FXML
    private JFXButton btnub1;
    @FXML
    private JFXButton btnub2;
    @FXML
    private JFXButton btnadd;
    @FXML
    private ImageView imgStudent;

    @FXML
    private AnchorPane anchM;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if ("1".equals(User.getType())) {
            btnadd.setVisible(true);
            btnub1.setVisible(true);
            btnub2.setVisible(true);
            btndel1.setVisible(true);
            btndel2.setVisible(true);
        }
        if ("2".equals(User.getType())) {
            btnadd.setVisible(true);
            btnub1.setVisible(true);
            btnub2.setVisible(true);
            btndel1.setVisible(false);
            btndel2.setVisible(false);
        }
        if ("3".equals(User.getType())) {
            btnadd.setVisible(false);
            btnub1.setVisible(false);
            btnub2.setVisible(false);
            btndel1.setVisible(false);
            btndel2.setVisible(false);
        }

        root.setOnKeyReleased(e -> {
            if (e.getCode().equals(KeyCode.ESCAPE)) {
                updateStudentDialog.close();
            }
        });

        ListStudent = StudentRe.getstudent();
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
        statuC.setCellValueFactory(new PropertyValueFactory<>("statu"));

        tableStudent.setItems(ListStudent);

        idC.setCellValueFactory(new PropertyValueFactory<>("id"));
        idStudentC.setCellValueFactory(new PropertyValueFactory<>("idStudent"));
        Date_ResC.setCellValueFactory(new PropertyValueFactory<>("Date_Res"));
        N_bacC.setCellValueFactory(new PropertyValueFactory<>("N_bac"));
        Date_bacC.setCellValueFactory(new PropertyValueFactory<>("Date_bac"));
        W_bacC.setCellValueFactory(new PropertyValueFactory<>("W_bac"));
        N_ins_univC.setCellValueFactory(new PropertyValueFactory<>("N_ins_univ"));
//        feliereC.setCellValueFactory(new PropertyValueFactory<>("feliere"));
        codeC.setCellValueFactory(new PropertyValueFactory<>("code"));
        AnneC.setCellValueFactory(new PropertyValueFactory<>("Anne"));

    }

    @FXML
    private void btnSearchAction(ActionEvent event) {

    }

    @FXML
    public void rechercherR() {
        rechR.textProperty().addListener((Observable observable) -> {
            if (rechR.textProperty().get().isEmpty()) {
                tableStudent.setItems(ListStudent);
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

    JFXDialog updateStudentDialog;
    StackPane updateStudentView = null;

    @FXML
    public void ubdateStudent() {
        if (index <= -1) {
            return;
        }

        try {
            updateStudentView = FXMLLoader.load(getClass().getResource("/com/dt/project/javafx/rmi/server/UpdateStudent/UpdateStudent.fxml"));
        } catch (IOException ioe) {
        }
        updateStudentDialog = new JFXDialog(root, updateStudentView, JFXDialog.DialogTransition.TOP);
        updateStudentDialog.show();

        updateStudentDialog.setOnKeyReleased(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                tableStudent.setItems(StudentRe.getstudent());
            }
        });

    }

    @FXML

    public void InsStudentIns() {
        if (index <= -1) {
            return;
        }

        try {
            updateStudentView = FXMLLoader.load(getClass().getResource("/com/dt/project/javafx/rmi/server/InsStudent/InsStudent.fxml"));
        } catch (IOException ioe) {
        }
        updateStudentDialog = new JFXDialog(root, updateStudentView, JFXDialog.DialogTransition.TOP);
        updateStudentDialog.show();

        updateStudentDialog.setOnDialogClosed(e -> {
            tableInscription.setItems(InscriptionRe.getInscriptionByIdStudent(sidC.getCellData(index)));
        });
    }

    @FXML
    public void UpdStudentIns() {
        if (index2 <= -1) {
            return;
        }

        try {
            updateStudentView = FXMLLoader.load(getClass().getResource("/com/dt/project/javafx/rmi/server/UpdStudentIns/UpdStudentIns.fxml"));
        } catch (IOException ioe) {
        }
        updateStudentDialog = new JFXDialog(root, updateStudentView, JFXDialog.DialogTransition.TOP);
        updateStudentDialog.show();

        updateStudentDialog.setOnDialogClosed(e -> {
            tableInscription.setItems(InscriptionRe.getInscriptionByIdStudent(sidC.getCellData(index)));
        });
    }

    @FXML
    public void deleteStudent() {
        if (index < 0) {
            return;
        }
        StudentRe.deleteStudent(sidC.getCellData(index));
        ListStudent.remove(index);
        Notifications notify = Notifications.create()
                .title("Student removed")
                .text("Student has successfully removed ")
                .hideAfter(Duration.seconds(3))
                .position(Pos.BOTTOM_RIGHT)
                .darkStyle();
        notify.showInformation();
        insertHistorique(new historiqueR(0, User.getId(), "127.0.0.1", User.getUsername() + "student" + student.getSid() + "successfully  removed", LocalDate.now()));
        index = -1;

    }

    @FXML
    public void deleteStudentIns() {
        if (index2 < 0) {
            return;
        }
        InscriptionRe.deleteInscription(idC.getCellData(index2));
        Notifications notify = Notifications.create()
                .title("Student removed")
                .text("Student has successfully removed ")
                .hideAfter(Duration.seconds(3))
                .position(Pos.BOTTOM_RIGHT)
                .darkStyle();
        notify.showInformation();
        index2 = -1;
        insertHistorique(new historiqueR(0, User.getId(), "127.0.0.1", User.getUsername() + "student" + student.getSid() + "successfully  removed", LocalDate.now()));
    }

    int index = -1;

    public void getSelectedItems() {
        index = tableStudent.getSelectionModel().getSelectedIndex();

        if (index <= -1) {
            return;
        }

        ListInscription = InscriptionRe.getInscriptionByIdStudent(sidC.getCellData(index));
        tableInscription.setItems(ListInscription);

        txtStudentName.setText(nameC.getCellData(index));
        txtAddress.setText(addressC.getCellData(index));
        txtDob.setText(dobC.getCellData(index).toString());
        txtGender.setText(genderC.getCellData(index));
        txtNic.setText(nicC.getCellData(index));
        txtSTel.setText(tel1C.getCellData(index));
        txtSTel1.setText(tel2C.getCellData(index));
        imgStudent.setImage(new Image(imgC.getCellData(index)));

        student = new student();
        student.setSid(sidC.getCellData(index));
        student.setName(txtStudentName.getText());
        student.setGender(genderC.getCellData(index));
        student.setAge(24);
        student.setDob(LocalDate.parse(dobC.getCellData(index).toString()));
        student.setNic(txtNic.getText());
        student.setTel1(tel1C.getCellData(index));
        student.setTel2(tel2C.getCellData(index));
        student.setAddress(addressC.getCellData(index));
        student.setImg(imgC.getCellData(index));
    }

    int index2 = -1;

    public void getSelectedItems2() {
        index2 = tableInscription.getSelectionModel().getSelectedIndex();
        if (index2 <= -1) {
            return;
        }

        inscription = new inscription();
        inscription.setId(idC.getCellData(index2));
        inscription.setIdStudent(idStudentC.getCellData(index2));
        inscription.setDate_Res(LocalDate.parse(Date_ResC.getCellData(index).toString()));
        inscription.setN_bac(N_bacC.getCellData(index2));
        inscription.setDate_bac(LocalDate.parse(Date_bacC.getCellData(index).toString()));
        inscription.setW_bac(W_bacC.getCellData(index2));
        inscription.setN_ins_univ(N_ins_univC.getCellData(index2));
        inscription.setCode(codeC.getCellData(index2));
        inscription.setAnne(AnneC.getCellData(index2));

    }

}
