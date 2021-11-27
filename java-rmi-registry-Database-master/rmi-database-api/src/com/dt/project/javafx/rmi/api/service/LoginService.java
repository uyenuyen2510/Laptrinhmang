/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.api.service;

import com.dt.project.javafx.rmi.api.entity.login;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Bureau
 */
public interface LoginService extends Remote {

    public login Login(String username, String password) throws RemoteException;
    login getUser() throws RemoteException;
}
