/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.api.service;

import com.dt.project.javafx.rmi.api.entity.block;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Bureau
 */
public interface BlockService extends Remote {

    public block getBlockById(int id) throws RemoteException;
}
