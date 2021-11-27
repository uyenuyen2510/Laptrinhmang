/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.server.utilities;

import static java.rmi.server.RemoteServer.getClientHost;
import java.rmi.server.ServerNotActiveException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bureau
 */
public class AdminRe {

    public static admin Login(String username, String password) {

        PreparedStatement statement = null;

        String sql = "SELECT * FROM `admin` WHERE `username`=? and `password`=?";

        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);

            statement.setString(1, username);
            statement.setString(2, password);

            admin admin;
            try (ResultSet result = statement.executeQuery()) {
                admin = null;
                if (result.next()) {
                    admin = new admin(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
                }
            }
            System.out.println("[successful]");
            return admin;
        } catch (SQLException ex) {
            System.out.println("[failed]");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
            try {
                //Sorry, I forgot to close the connection to the database :D
                DatabaseConnection.getConnection().close();
            } catch (SQLException ex) {
            }
        }
    }

}
