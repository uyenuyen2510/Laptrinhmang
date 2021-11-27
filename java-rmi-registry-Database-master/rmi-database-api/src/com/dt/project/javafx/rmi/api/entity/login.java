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
public class login implements Externalizable {

    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final IntegerProperty privilege = new SimpleIntegerProperty();
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
    

    public int getPrivilege() {
        return privilege.get();
    }

    public void setPrivilege(int value) {
        privilege.set(value);
    }

    public IntegerProperty privilegeProperty() {
        return privilege;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String value) {
        password.set(value);
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String value) {
        username.set(value);
    }

    public StringProperty usernameProperty() {
        return username;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getUsername());
        out.writeObject(getPassword());
        out.writeInt(getPrivilege());
        out.writeInt(getIdBlock());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setUsername((String) in.readObject());
        setPassword((String) in.readObject());
        setPrivilege(in.readInt());
        setIdBlock(in.readInt());
    }

}
