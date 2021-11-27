/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.api.service;

import com.dt.project.javafx.rmi.api.entity.student;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Bureau
 */
public interface StudentService extends Remote {

    List<student> getstudent() throws RemoteException;
    
    void setStatu(int st,int id) throws RemoteException;

//    String getNameStudent(int id) throws RemoteException;

    public void aff() throws RemoteException;

}
