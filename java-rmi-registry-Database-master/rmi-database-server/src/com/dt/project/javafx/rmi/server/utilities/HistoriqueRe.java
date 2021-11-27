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

/**
 *
 * @author Bureau
 */
public class HistoriqueRe {

    public static historiqueR insertHistorique(historiqueR historiqueR) {
        PreparedStatement statement = null;

        String sql = "INSERT INTO `historique`(`id`, `idUser`, `ip`, `trav`, `Dat_trav`) VALUES (null,?,?,?,?)";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, historiqueR.getIdUser());
            statement.setString(2, historiqueR.getIp());
            statement.setString(3, historiqueR.getTrav());
            statement.setDate(4, Date.valueOf(historiqueR.getDat_trav().toString()));

            statement.executeUpdate();

            try (ResultSet result = statement.getGeneratedKeys()) {
                if (result.next()) {
                    historiqueR.setId(result.getInt(1));
                }
            }
            System.out.println("[successful]");
            return historiqueR;

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
