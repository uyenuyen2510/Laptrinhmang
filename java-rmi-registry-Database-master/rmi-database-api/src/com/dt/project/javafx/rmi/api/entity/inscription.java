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
public class inscription implements Externalizable {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final IntegerProperty idStudent = new SimpleIntegerProperty();
    private final ObjectProperty<LocalDate> Date_Res = new SimpleObjectProperty<>();
    private final StringProperty N_bac = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> Date_bac = new SimpleObjectProperty<>();
    private final StringProperty W_bac = new SimpleStringProperty();
    private final StringProperty N_ins_univ = new SimpleStringProperty();
//    private final StringProperty feliere = new SimpleStringProperty();
    private final StringProperty code = new SimpleStringProperty();
    private final StringProperty Anne = new SimpleStringProperty();

    public LocalDate getDate_Res() {
        return Date_Res.get();
    }

    public void setDate_Res(LocalDate value) {
        Date_Res.set(value);
    }

    public ObjectProperty Date_ResProperty() {
        return Date_Res;
    }

    public String getAnne() {
        return Anne.get();
    }

    public void setAnne(String value) {
        Anne.set(value);
    }

    public StringProperty AnneProperty() {
        return Anne;
    }

    public String getCode() {
        return code.get();
    }

    public void setCode(String value) {
        code.set(value);
    }

    public StringProperty codeProperty() {
        return code;
    }

//    public String getFeliere() {
//        return feliere.get();
//    }
//
//    public void setFeliere(String value) {
//        feliere.set(value);
//    }
//
//    public StringProperty feliereProperty() {
//        return feliere;
//    }

    public String getN_ins_univ() {
        return N_ins_univ.get();
    }

    public void setN_ins_univ(String value) {
        N_ins_univ.set(value);
    }

    public StringProperty N_ins_univProperty() {
        return N_ins_univ;
    }

    public String getW_bac() {
        return W_bac.get();
    }

    public void setW_bac(String value) {
        W_bac.set(value);
    }

    public StringProperty W_bacProperty() {
        return W_bac;
    }

    public LocalDate getDate_bac() {
        return Date_bac.get();
    }

    public void setDate_bac(LocalDate value) {
        Date_bac.set(value);
    }

    public ObjectProperty stringProperty() {
        return Date_bac;
    }

    public String getN_bac() {
        return N_bac.get();
    }

    public void setN_bac(String value) {
        N_bac.set(value);
    }

    public StringProperty N_bacProperty() {
        return N_bac;
    }

    public int getIdStudent() {
        return idStudent.get();
    }

    public void setIdStudent(int value) {
        idStudent.set(value);
    }

    public IntegerProperty idStudentProperty() {
        return idStudent;
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
        out.writeObject(getIdStudent());
        out.writeObject(getDate_Res());
        out.writeObject(getN_bac());
        out.writeObject(getDate_bac());
        out.writeObject(getW_bac());
        out.writeObject(getN_ins_univ());
//        out.writeObject(getFeliere());
        out.writeObject(getCode());
        out.writeObject(getAnne());

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setId(in.readInt());
        setIdStudent(in.readInt());
        setDate_Res((LocalDate) in.readObject());
        setN_bac((String) in.readObject());
        setDate_bac((LocalDate) in.readObject());
        setW_bac((String) in.readObject());
        setN_ins_univ((String) in.readObject());
//        setFeliere((String) in.readObject());
        setCode((String) in.readObject());
        setAnne((String) in.readObject());
    }

}
