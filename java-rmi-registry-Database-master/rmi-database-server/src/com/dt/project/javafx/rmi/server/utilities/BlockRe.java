/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.server.utilities;

import com.dt.project.javafx.rmi.api.entity.block;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Bureau
 */
public class BlockRe {

    public static block insertBlock(block block) {
        PreparedStatement statement = null;

        String sql = "INSERT INTO `block`(`id`, `nomBlock`, `nbrChambre`, `nbrPCCh`) VALUES (null,?,?,?)";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, block.getNomBlock());
            statement.setInt(2, block.getNbrChambre());
            statement.setInt(3, block.getNbrPCCh());

            statement.executeUpdate();

            try (ResultSet result = statement.getGeneratedKeys()) {
                if (result.next()) {
                    block.setId(result.getInt(1));
                }
            }
            System.out.println("[successful]");
            return block;

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

    public static ObservableList<block> getBlock() {
        Statement statement = null;

        String sql = "SELECT * FROM `block`";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery(sql);

            ObservableList<block> ol = FXCollections.observableArrayList();

            while (result.next()) {
                block block = new block();
                block.setId(result.getInt(1));
                block.setNomBlock(result.getString(2));
                block.setNbrChambre(result.getInt(3));
                block.setNbrPCCh(result.getInt(4));
                ol.add(block);
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

    public static void updateBlock(block block) {

        PreparedStatement statement = null;

        String sql = "UPDATE `block` SET `nomBlock`=?,`nbrChambre`=?,`nbrPCCh`=? WHERE `id`=?";

        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);
            statement.setString(1, block.getNomBlock());
            statement.setInt(2, block.getNbrChambre());
            statement.setInt(3, block.getNbrPCCh());
            statement.setInt(4, block.getId());
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

    public static void deleteBlock(int id) {

        PreparedStatement statement = null;

        String sql = "DELETE FROM `block` WHERE `id`=?";

        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);

            statement.setLong(1, id);

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

    public static block getStudentById(int id) {

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

    public static void main(String[] args) {
        System.out.println(getStudentById(1).getNbrChambre());
    }
}
