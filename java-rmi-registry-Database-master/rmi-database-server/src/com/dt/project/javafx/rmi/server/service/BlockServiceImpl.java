/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.server.service;

import com.dt.project.javafx.rmi.api.entity.block;
import com.dt.project.javafx.rmi.api.service.BlockService;
import com.dt.project.javafx.rmi.server.utilities.DatabaseConnection;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bureau
 */
public class BlockServiceImpl extends UnicastRemoteObject implements BlockService {

    public BlockServiceImpl() throws RemoteException {
    }

    @Override
    public block getBlockById(int id) throws RemoteException {
        try {
            System.out.print("\nClient " + getClientHost() + " request getPersonById() method...");
        } catch (ServerNotActiveException ex) {
        }

        PreparedStatement statement = null;

        String sql = "SELECT * FROM `block` WHERE `id`=?";

        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);

            statement.setLong(1, id);

            ResultSet result = statement.executeQuery();

            block block = null;
            if (result.next()) {
                block = new block();
                block.setId(result.getInt(1));
                block.setNomBlock(result.getString(2));
                block.setNbrChambre(result.getInt(3));
                block.setNbrPCCh(result.getInt(4));
            }

            result.close();
            System.out.println("[successful]");
            return block;
        } catch (SQLException ex) {
            System.out.println("[failed]");
            ex.printStackTrace();
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            try {
                //Sorry, I forgot to close the connection to the database :D
                DatabaseConnection.getConnection().close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
