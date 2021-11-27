/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.server.service;

import com.dt.project.javafx.rmi.api.entity.chambre;
import com.dt.project.javafx.rmi.api.service.ChambreService;
import com.dt.project.javafx.rmi.server.utilities.DatabaseConnection;
import java.rmi.RemoteException;
import static java.rmi.server.RemoteServer.getClientHost;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bureau
 */
public class ChambreServiceImpl extends UnicastRemoteObject implements ChambreService {

    public ChambreServiceImpl() throws RemoteException {
    }

    @Override
    public chambre insertChambre(chambre chambre) throws RemoteException {
        try {
            System.out.print("\nClient " + getClientHost() + " request getPersonById() method...");
        } catch (ServerNotActiveException ex) {
        }

        PreparedStatement statement = null;

        String sql = "INSERT INTO `chambre`(`id`, `idStudent`, `nameStudent`,`idBlock`) VALUES (?,?,?,?)";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);
            statement.setInt(1, chambre.getId());
            statement.setInt(2, chambre.getIdStudent());
            statement.setString(3, chambre.getNameStudent());
            statement.setInt(4, chambre.getIdBlock());

            statement.executeUpdate();

            System.out.println("[successful]");
            return chambre;

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

    @Override
    public List<chambre> getChambreById(int id) throws RemoteException {
        try {
            System.out.print("\nClient " + getClientHost() + " request getPersonById() method...");
        } catch (ServerNotActiveException ex) {
        }

        PreparedStatement statement = null;

        String sql = "SELECT * FROM `chambre` WHERE `id`=" + id;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);

            List<chambre> ol;
            try (ResultSet result = statement.executeQuery(sql)) {
                ol = new ArrayList<>();
                while (result.next()) {
                    chambre chambre = new chambre();
                    chambre.setId(result.getInt(1));
                    chambre.setIdStudent(result.getInt(2));
                    chambre.setNameStudent(result.getString(3));
                    chambre.setIdBlock(result.getInt(4));
                    ol.add(chambre);
                }
            }

            System.out.println("[successful]");
            return ol;

        } catch (SQLException ex) {
            ex.printStackTrace();
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

    @Override
    public List<chambre> getChambreById(int id, int idB) throws RemoteException {
        try {
            System.out.print("\nClient " + getClientHost() + " request getPersonById() method...");
        } catch (ServerNotActiveException ex) {
        }

        PreparedStatement statement = null;

        String sql = "SELECT * FROM `chambre` WHERE `id`="+id+" and `idBlock`="+idB;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);

            List<chambre> ol;
            try (ResultSet result = statement.executeQuery(sql)) {
                ol = new ArrayList<>();
                while (result.next()) {
                    chambre chambre = new chambre();
                    chambre.setId(result.getInt(1));
                    chambre.setIdStudent(result.getInt(2));
                    chambre.setNameStudent(result.getString(3));
                    chambre.setIdBlock(result.getInt(4));
                    ol.add(chambre);
                }
            }

            System.out.println("[successful]");
            return ol;

        } catch (SQLException ex) {
            ex.printStackTrace();
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

    @Override
    public void deleteStudent(int id, int idStudent) throws RemoteException {
        try {
            System.out.print("\nClient " + getClientHost() + " request getPersonById() method...");
        } catch (ServerNotActiveException ex) {
        }

        PreparedStatement statement = null;

        String sql = "DELETE FROM `chambre` WHERE `id`=" + id + " and `idStudent`=" + idStudent;

        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);

            statement.executeUpdate();
            System.out.println("[successful]");
        } catch (SQLException ex) {
            System.out.println("[failed]");
            ex.printStackTrace();
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

    public static void main(String[] args) throws RemoteException {
        ChambreServiceImpl c = new ChambreServiceImpl();
        System.out.println(c.getChambreById(1, 1));
    }

    @Override
    public chambre getChambreByIdStudent(int idStudent) throws RemoteException {
        try {
            System.out.print("\nClient " + getClientHost() + " request getPersonById() method...");
        } catch (ServerNotActiveException ex) {
        }

        PreparedStatement statement = null;

        String sql = "SELECT * FROM `chambre` WHERE `idStudent`=" + idStudent;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);
            chambre chambre = null;
            try (ResultSet result = statement.executeQuery(sql)) {

                while (result.next()) {
                    chambre = new chambre();
                    chambre.setId(result.getInt(1));
                    chambre.setIdStudent(result.getInt(2));
                    chambre.setNameStudent(result.getString(3));
                    chambre.setIdBlock(result.getInt(4));

                }
            }

            System.out.println("[successful]");
            return chambre;

        } catch (SQLException ex) {
            ex.printStackTrace();
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
