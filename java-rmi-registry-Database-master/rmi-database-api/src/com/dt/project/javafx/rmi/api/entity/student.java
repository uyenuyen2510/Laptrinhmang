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
public class student implements Externalizable {

    private final IntegerProperty sid = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> dob = new SimpleObjectProperty<>();
    private final IntegerProperty age = new SimpleIntegerProperty();
    private final StringProperty nic = new SimpleStringProperty();
    private final StringProperty tel1 = new SimpleStringProperty();
    private final StringProperty tel2 = new SimpleStringProperty();
    private final StringProperty address = new SimpleStringProperty();
    private final StringProperty gender = new SimpleStringProperty();
    private final StringProperty img = new SimpleStringProperty();
    private final IntegerProperty statu = new SimpleIntegerProperty();

    public int getStatu() {
        return statu.get();
    }

    public void setStatu(int value) {
        statu.set(value);
    }

    public IntegerProperty statuProperty() {
        return statu;
    }

    public String getImg() {
        return img.get();
    }

    public void setImg(String value) {
        img.set(value);
    }

    public StringProperty imgProperty() {
        return img;
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String value) {
        gender.set(value);
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String value) {
        address.set(value);
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getTel2() {
        return tel2.get();
    }

    public void setTel2(String value) {
        tel2.set(value);
    }

    public StringProperty tel2Property() {
        return tel2;
    }

    public String getTel1() {
        return tel1.get();
    }

    public void setTel1(String value) {
        tel1.set(value);
    }

    public StringProperty tel1Property() {
        return tel1;
    }

    public String getNic() {
        return nic.get();
    }

    public void setNic(String value) {
        nic.set(value);
    }

    public StringProperty nicProperty() {
        return nic;
    }

    public int getAge() {
        return age.get();
    }

    public void setAge(int value) {
        age.set(value);
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public LocalDate getDob() {
        return dob.get();
    }

    public void setDob(LocalDate value) {
        dob.set(value);
    }

    public ObjectProperty dobProperty() {
        return dob;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public int getSid() {
        return sid.get();
    }

    public void setSid(int value) {
        sid.set(value);
    }

    public IntegerProperty sidProperty() {
        return sid;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(getSid());
        out.writeObject(getName());
        out.writeObject(getDob());
        out.writeInt(getAge());
        out.writeObject(getNic());
        out.writeObject(getTel1());
        out.writeObject(getTel2());
        out.writeObject(getAddress());
        out.writeObject(getGender());
        out.writeObject(getImg());
        out.writeInt(getStatu());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setSid(in.readInt());
        setName((String) in.readObject());
        setDob((LocalDate) in.readObject());
        setAge(in.readInt());
        setNic((String) in.readObject());
        setTel1((String) in.readObject());
        setTel2((String) in.readObject());
        setAddress((String) in.readObject());
        setGender((String) in.readObject());
        setImg((String) in.readObject());
        setStatu(in.readInt());
    }

}
