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
public class block implements Externalizable {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty nomBlock = new SimpleStringProperty();
    private final IntegerProperty nbrChambre = new SimpleIntegerProperty();
    private final IntegerProperty nbrPCCh = new SimpleIntegerProperty();

    public int getNbrPCCh() {
        return nbrPCCh.get();
    }

    public void setNbrPCCh(int value) {
        nbrPCCh.set(value);
    }

    public IntegerProperty nbrPCChProperty() {
        return nbrPCCh;
    }

    public int getNbrChambre() {
        return nbrChambre.get();
    }

    public void setNbrChambre(int value) {
        nbrChambre.set(value);
    }

    public IntegerProperty nbrChambreProperty() {
        return nbrChambre;
    }

    public String getNomBlock() {
        return nomBlock.get();
    }

    public void setNomBlock(String value) {
        nomBlock.set(value);
    }

    public StringProperty nomBlockProperty() {
        return nomBlock;
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
        out.writeObject(getNomBlock());
        out.writeInt(getNbrChambre());
        out.writeInt(getNbrPCCh());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setId(in.readInt());
        setNomBlock((String) in.readObject());
        setNbrChambre(in.readInt());
        setNbrPCCh(in.readInt());
    }

}
