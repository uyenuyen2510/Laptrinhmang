/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.api.service;

import com.dt.project.javafx.rmi.api.entity.chambre;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Bureau
 */
public interface ChambreService extends Remote {

    chambre insertChambre(chambre chambre) throws RemoteException;

    void deleteStudent(int id, int idStudent) throws RemoteException;

    List<chambre> getChambreById(int id) throws RemoteException;

    List<chambre> getChambreById(int id, int idB) throws RemoteException;

    chambre getChambreByIdStudent(int idStudent) throws RemoteException;

}
