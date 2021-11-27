/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.api.entity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Bureau
 */
public class historique implements Externalizable {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final IntegerProperty idUser = new SimpleIntegerProperty();
    private final StringProperty ip = new SimpleStringProperty();
    private final StringProperty trav = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> Dat_trav = new SimpleObjectProperty<>();

    public LocalDate getDat_trav() {
        return Dat_trav.get();
    }

    public void setDat_trav(LocalDate value) {
        Dat_trav.set(value);
    }

    public ObjectProperty Dat_travProperty() {
        return Dat_trav;
    }

    public String getTrav() {
        return trav.get();
    }

    public void setTrav(String value) {
        trav.set(value);
    }

    public StringProperty travProperty() {
        return trav;
    }

    public String getIp() {
        return ip.get();
    }

    public void setIp(String value) {
        ip.set(value);
    }

    public StringProperty ipProperty() {
        return ip;
    }

    public int getIdUser() {
        return idUser.get();
    }

    public void setIdUser(int value) {
        idUser.set(value);
    }

    public IntegerProperty idUserProperty() {
        return idUser;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(getId());
        out.writeInt(getIdUser());
        out.writeObject(getIp());
        out.writeObject(getTrav());
        out.writeObject(getDat_trav());

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setId(in.readInt());
        setIdUser(in.readInt());
        setIp((String) in.readObject());
        setTrav((String) in.readObject());
        setDat_trav((LocalDate) in.readObject());

    }

}
