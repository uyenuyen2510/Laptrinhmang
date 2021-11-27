/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.server.service;

import com.dt.project.javafx.rmi.api.entity.login;
import com.dt.project.javafx.rmi.api.service.LoginService;
import com.dt.project.javafx.rmi.server.utilities.DatabaseConnection;
import java.rmi.RemoteException;
import static java.rmi.server.RemoteServer.getClientHost;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bureau
 */
public class LoginServiceImpl extends UnicastRemoteObject implements LoginService {

    public LoginServiceImpl() throws RemoteException {
    }

    login user;

    @Override
    public login getUser() {
        return user;
    }

    @Override
    public login Login(String username, String password) throws RemoteException {
        try {
            System.out.print("\nClient " + getClientHost() + " request getPersonById() method...");
        } catch (ServerNotActiveException ex) {
        }

        PreparedStatement statement = null;

        String sql = "SELECT * FROM `users` WHERE `username`=? and `password`=?";

        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);

            statement.setString(1, username);
            statement.setString(2, password);

            login login;
            try (ResultSet result = statement.executeQuery()) {
                login = null;
                if (result.next()) {
                    login = new login();

                    login.setUsername(result.getString("username"));
                    login.setPassword(result.getString("password"));
                    login.setPrivilege(result.getInt("privilege"));
                    login.setIdBlock(result.getInt("idBlock"));
                }
            }
            System.out.println("[successful]");
            user = login;
            return login;
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

    public static void main(String[] args) throws RemoteException {
        LoginServiceImpl impl = new LoginServiceImpl();
        System.out.println(impl.Login("aS", "aS").getIdBlock());
    }

}
