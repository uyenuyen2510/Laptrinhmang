/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.server.Univ;

import static com.dt.project.javafx.rmi.server.login.LoginController.User;
import static com.dt.project.javafx.rmi.server.utilities.HistoriqueRe.insertHistorique;
import com.dt.project.javafx.rmi.server.utilities.UnivRe;
import com.dt.project.javafx.rmi.server.utilities.historiqueR;
import com.dt.project.javafx.rmi.server.utilities.univ;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Bureau
 */
public class UnivController implements Initializable {

    @FXML
    JFXTextField rech;

    ObservableList<univ> ListUniv;

    @FXML
    TableView<univ> tableUniv;
    @FXML
    TableColumn<univ, String> codeC;
    @FXML
    TableColumn<univ, String> nameC;

    @FXML
    TextField namUniv;
    @FXML
    TextField code;

    @FXML
    public void rechercher() {
        rech.textProperty().addListener((Observable observable) -> {
            if (rech.textProperty().get().isEmpty()) {
                tableUniv.setItems(ListUniv);
                return;
            }
            ObservableList<univ> tableE1 = FXCollections.observableArrayList();
            ObservableList<TableColumn<univ, ?>> cols = tableUniv.getColumns();
            for (int i = 0; i < ListUniv.size(); i++) {
                for (int j = 0; j < cols.size(); j++) {
                    TableColumn col = cols.get(j);
                    String cellValue = col.getCellData(ListUniv.get(i)).toString();
                    cellValue = cellValue.toLowerCase();
                    if (cellValue.contains(rech.getText().toLowerCase()) && cellValue.startsWith(rech.getText().toLowerCase())) {
                        tableE1.add(ListUniv.get(i));
                        break;
                    }
                }
            }
            tableUniv.setItems(tableE1);
        });
    }

    int index = -1;

    public void getSelectedItems() {
        index = tableUniv.getSelectionModel().getSelectedIndex();

        if (index <= -1) {
            return;
        }

        namUniv.setText(nameC.getCellData(index));
        code.setText(codeC.getCellData(index));

    }

    @FXML
    public void ajouter() {
        if (code.getText().isEmpty()) {
            return;
        }
        if (namUniv.getText().isEmpty()) {
            return;
        }
        univ univ = new univ(code.getText(), namUniv.getText());

        ListUniv.add(UnivRe.insertUniv(univ));
        Notifications notify = Notifications.create()
                .title("Block Add")
                .text("Block has successfully add ")
                .hideAfter(Duration.seconds(3))
                .position(Pos.BOTTOM_RIGHT)
                .darkStyle();
        notify.showInformation();
        insertHistorique(new historiqueR(0, User.getId(), "127.0.0.1", User.getUsername() + " has Block" + namUniv.getText() + " Add", LocalDate.now()));
        clear();

    }

    @FXML
    public void clear() {
        namUniv.setText("");
        code.setText("");
        index = -1;
    }

    @FXML
    public void modifier() {
        if (index <= -1) {
            return;
        }
        univ univ = new univ(codeC.getCellData(index), namUniv.getText());
        UnivRe.updateUniv(univ);
        ListUniv.set(index, univ);
        index = -1;
        Notifications notify = Notifications.create()
                .title("Block update")
                .text("Block has successfully update ")
                .hideAfter(Duration.seconds(3))
                .position(Pos.BOTTOM_RIGHT)
                .darkStyle();
        notify.showInformation();
        insertHistorique(new historiqueR(0, User.getId(), "127.0.0.1", User.getUsername() + " has Block" + namUniv.getText() + " update", LocalDate.now()));
        clear();

    }

    @FXML
    public void supprimer() {
        if (index <= -1) {
            return;
        }
        UnivRe.deleteUniv(codeC.getCellData(index));
        ListUniv.remove(index);
        index = -1;
        Notifications notify = Notifications.create()
                .title("Block removed")
                .text("Block has successfully removed ")
                .hideAfter(Duration.seconds(3))
                .position(Pos.BOTTOM_RIGHT)
                .darkStyle();
        notify.showInformation();
        insertHistorique(new historiqueR(0, User.getId(), "127.0.0.1", User.getUsername() + " has Block" + namUniv.getText() + " removed", LocalDate.now()));
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListUniv = UnivRe.getUnivA();
        codeC.setCellValueFactory(new PropertyValueFactory<>("code"));
        nameC.setCellValueFactory(new PropertyValueFactory<>("name"));

        tableUniv.setItems(ListUniv);
    }

}
