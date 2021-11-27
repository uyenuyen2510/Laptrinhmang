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
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Bureau
 */
public class chambre implements Externalizable {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final IntegerProperty idStudent = new SimpleIntegerProperty();
    private final StringProperty nameStudent = new SimpleStringProperty();
    private final IntegerProperty idBlock = new SimpleIntegerProperty();

    public int getIdBlock() {
        return idBlock.get();
    }

    public void setIdBlock(int value) {
        idBlock.set(value);
    }

    public IntegerProperty idBlockProperty() {
        return idBlock;
    }

    public String getNameStudent() {
        return nameStudent.get();
    }

    public void setNameStudent(String value) {
        nameStudent.set(value);
    }

    public StringProperty nameStudentProperty() {
        return nameStudent;
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
        out.writeInt(getIdBlock());
        out.writeInt(getIdStudent());
        out.writeObject(getNameStudent());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setId(in.readInt());
        setIdBlock(in.readInt());
        setIdStudent(in.readInt());
        setNameStudent((String) in.readObject());
    }

}
