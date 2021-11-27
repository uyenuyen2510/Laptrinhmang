/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.server.Block;

import com.dt.project.javafx.rmi.api.entity.block;
import static com.dt.project.javafx.rmi.server.login.LoginController.User;
import com.dt.project.javafx.rmi.server.utilities.BlockRe;
import static com.dt.project.javafx.rmi.server.utilities.HistoriqueRe.insertHistorique;
import com.dt.project.javafx.rmi.server.utilities.historiqueR;
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
public class BlockController implements Initializable {

    @FXML
    JFXTextField rech;

    ObservableList<block> ListBlock;

    @FXML
    TableView<block> tableBlock;
    @FXML
    TableColumn<block, Integer> idC;
    @FXML
    TableColumn<block, String> nomBlockC;
    @FXML
    TableColumn<block, Integer> nbrChambreC;
    @FXML
    TableColumn<block, Integer> nbrPCChC;

    @FXML
    TextField nomBlock;
    @FXML
    TextField nbrChambre;
    @FXML
    TextField nbrPCCh;

    @FXML
    public void rechercher() {
        rech.textProperty().addListener((Observable observable) -> {
            if (rech.textProperty().get().isEmpty()) {
                tableBlock.setItems(ListBlock);
                return;
            }
            ObservableList<block> tableE1 = FXCollections.observableArrayList();
            ObservableList<TableColumn<block, ?>> cols = tableBlock.getColumns();
            for (int i = 0; i < ListBlock.size(); i++) {
                for (int j = 0; j < cols.size(); j++) {
                    TableColumn col = cols.get(j);
                    String cellValue = col.getCellData(ListBlock.get(i)).toString();
                    cellValue = cellValue.toLowerCase();
                    if (cellValue.contains(rech.getText().toLowerCase()) && cellValue.startsWith(rech.getText().toLowerCase())) {
                        tableE1.add(ListBlock.get(i));
                        break;
                    }
                }
            }
            tableBlock.setItems(tableE1);
        });
    }

    int index = -1;

    public void getSelectedItems() {
        index = tableBlock.getSelectionModel().getSelectedIndex();

        if (index <= -1) {
            return;
        }

        nomBlock.setText(nomBlockC.getCellData(index));
        nbrChambre.setText(nbrChambreC.getCellData(index).toString());
        nbrPCCh.setText(nbrPCChC.getCellData(index).toString());

    }

    @FXML
    public void ajouter() {
        block block = new block();
        block.setNomBlock(nomBlock.getText());
        block.setNbrChambre(Integer.parseInt(nbrChambre.getText()));
        block.setNbrPCCh(Integer.parseInt(nbrPCCh.getText()));
        ListBlock.add(BlockRe.insertBlock(block));
        Notifications notify = Notifications.create()
                .title("Block Add")
                .text("Block has successfully add ")
                .hideAfter(Duration.seconds(3))
                .position(Pos.BOTTOM_RIGHT)
                .darkStyle();
        notify.showInformation();
        insertHistorique(new historiqueR(0, User.getId(), "127.0.0.1", User.getUsername() + " has Block" + nomBlock.getText() + " Add", LocalDate.now()));
        clear();

    }

    @FXML
    public void clear() {
        nomBlock.setText("");
        nbrChambre.setText("");
        nbrPCCh.setText("");
        index = -1;
    }

    @FXML
    public void modifier() {
        if (index <= -1) {
            return;
        }
        block block = new block();
        block.setId(idC.getCellData(index));
        block.setNomBlock(nomBlock.getText());
        block.setNbrChambre(Integer.parseInt(nbrChambre.getText()));
        block.setNbrPCCh(Integer.parseInt(nbrPCCh.getText()));
        BlockRe.updateBlock(block);
        ListBlock.set(index, block);
        index = -1;
        Notifications notify = Notifications.create()
                .title("Block update")
                .text("Block has successfully update ")
                .hideAfter(Duration.seconds(3))
                .position(Pos.BOTTOM_RIGHT)
                .darkStyle();
        notify.showInformation();
        insertHistorique(new historiqueR(0, User.getId(), "127.0.0.1", User.getUsername() + " has Block" + nomBlock.getText() + " update", LocalDate.now()));
        clear();

    }

    @FXML
    public void supprimer() {
        if (index <= -1) {
            return;
        }
        BlockRe.deleteBlock(idC.getCellData(index));
        ListBlock.remove(index);
        index = -1;
        Notifications notify = Notifications.create()
                .title("Block removed")
                .text("Block has successfully removed ")
                .hideAfter(Duration.seconds(3))
                .position(Pos.BOTTOM_RIGHT)
                .darkStyle();
        notify.showInformation();
        insertHistorique(new historiqueR(0, User.getId(), "127.0.0.1", User.getUsername() + " has Block" + nomBlock.getText() + " removed", LocalDate.now()));
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListBlock = BlockRe.getBlock();
        idC.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomBlockC.setCellValueFactory(new PropertyValueFactory<>("nomBlock"));
        nbrChambreC.setCellValueFactory(new PropertyValueFactory<>("nbrChambre"));
        nbrPCChC.setCellValueFactory(new PropertyValueFactory<>("nbrPCCh"));

        tableBlock.setItems(ListBlock);
    }

}
