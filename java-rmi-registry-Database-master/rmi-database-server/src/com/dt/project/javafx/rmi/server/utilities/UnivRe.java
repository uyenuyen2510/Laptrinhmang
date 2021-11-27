/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.server.utilities;

import com.dt.project.javafx.rmi.api.entity.inscription;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Bureau
 */
public class UnivRe {

    public static void main(String[] args) {
        univ univ = new univ("E11", "mi");
        updateUniv(univ);
    }

    public static void deleteUniv(String id) {

        PreparedStatement statement = null;

        String sql = "DELETE FROM `univ` WHERE `code`=?";

        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);

            statement.setString(1, id);

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

    public static univ insertUniv(univ univ) {
        PreparedStatement statement = null;

        String sql = "INSERT INTO `univ`(`code`, `name`) VALUES ('" + univ.getCode() + "','" + univ.getName() + "')";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.executeUpdate();

            System.out.println("[successful]");
            return univ;

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

    public static void updateUniv(univ univ) {

        PreparedStatement statement = null;

        String sql = "UPDATE `univ` SET `name`='" + univ.getName() + "' WHERE `code`='" + univ.getCode() + "'";

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

    public static ObservableList<univ> getUnivA() {
        Statement statement = null;

        String sql = "SELECT * FROM `univ`";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery(sql);

            ObservableList<univ> ol = FXCollections.observableArrayList();

            while (result.next()) {
                univ univ = new univ(result.getString(1), result.getString(2));

                ol.add(univ);
            }
            result.close();
            System.out.println("[successful]");
            return ol;

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

    public static String getUnivById(String id) {

        PreparedStatement statement = null;

        String sql = "SELECT  `name` FROM `univ` WHERE `code`=?";

        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);

            statement.setString(1, id);

            ResultSet result = statement.executeQuery();

            String name = null;
            if (result.next()) {
                name = result.getString(1);
            }

            result.close();
            System.out.println("[successful]");
            return name;
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

    public static ObservableList<String> getUniv() {
        Statement statement = null;

        String sql = "SELECT `code` FROM `univ`";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery(sql);

            ObservableList<String> ol = FXCollections.observableArrayList();

            while (result.next()) {

                ol.add(result.getString(1));
            }
            result.close();
            System.out.println("[successful]");
            return ol;

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
