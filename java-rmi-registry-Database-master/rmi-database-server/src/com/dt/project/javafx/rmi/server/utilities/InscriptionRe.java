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
public class InscriptionRe {

    public static void main(String[] args) {
        for (UnivStat univStat : UnivStat()) {
            System.out.println(univStat.getCode());
        }
    }

    public static ObservableList<UnivStat> UnivStat() {
        Statement statement = null;

        String sql = "SELECT `code`,`Date_Res`,COUNT(*) from inscription GROUP by `Date_Res`,code";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery(sql);

            ObservableList<UnivStat> ol = FXCollections.observableArrayList();

            while (result.next()) {
                UnivStat UnivStat = new UnivStat();
                UnivStat.setCode(result.getString(1));
                UnivStat.setDate_Res(LocalDate.parse(result.getDate(2).toString()));
                UnivStat.setCount(result.getInt(3));

                ol.add(UnivStat);
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

    public static inscription insertInscription(inscription inscription) {
        PreparedStatement statement = null;

        String sql = "INSERT INTO `inscription`(`id`, `idStudent`, `Date_Res`, `N_bac`, `Date_bac`, `W_bac`, `N_ins_univ`, `code`, `Anne`) VALUES (null,?,?,?,?,?,?,?,?)";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, inscription.getIdStudent());
            statement.setDate(2, Date.valueOf(inscription.getDate_Res().toString()));
            statement.setString(3, inscription.getN_bac());
            statement.setDate(4, Date.valueOf(inscription.getDate_bac().toString()));
            statement.setString(5, inscription.getW_bac());
            statement.setString(6, inscription.getN_ins_univ());
//            statement.setString(7, inscription.getFeliere());
            statement.setString(7, inscription.getCode());
            statement.setString(8, inscription.getAnne());

            statement.executeUpdate();

            try (ResultSet result = statement.getGeneratedKeys()) {
                if (result.next()) {
                    inscription.setId(result.getInt(1));
                }
            }
            System.out.println("[successful]");
            return inscription;

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

    public static ObservableList<inscription> getInscription() {
        Statement statement = null;

        String sql = "SELECT * FROM `inscription`";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery(sql);

            ObservableList<inscription> ol = FXCollections.observableArrayList();

            while (result.next()) {
                inscription student = new inscription();
                student.setId(result.getInt(1));
                student.setIdStudent(result.getInt(2));
                student.setDate_Res(LocalDate.parse(result.getDate(3).toString()));
                student.setN_bac(result.getString(4));
                student.setDate_bac(LocalDate.parse(result.getDate(5).toString()));
                student.setW_bac(result.getString(6));
                student.setN_ins_univ(result.getString(7));
//                student.setFeliere(result.getString(8));
                student.setCode(result.getString(8));
                student.setAnne(result.getString(9));
                ol.add(student);
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

    public static void updateInscription(inscription inscription) {

        PreparedStatement statement = null;

        String sql = "UPDATE `inscription` SET `idStudent`=?,`Date_Res`=?,`N_bac`=?,`Date_bac`=?,`W_bac`=?,`N_ins_univ`=?,`code`=?,`Anne`=? WHERE `id`=?";

        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);
            statement.setInt(1, inscription.getIdStudent());
            statement.setDate(2, Date.valueOf(inscription.getDate_Res().toString()));
            statement.setString(3, inscription.getN_bac());
            statement.setDate(4, Date.valueOf(inscription.getDate_bac().toString()));
            statement.setString(5, inscription.getW_bac());
            statement.setString(6, inscription.getN_ins_univ());
//            statement.setString(7, inscription.getFeliere());
            statement.setString(7, inscription.getCode());
            statement.setString(8, inscription.getAnne());
            statement.setInt(9, inscription.getId());
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

    public static void deleteInscription(int id) {

        PreparedStatement statement = null;

        String sql = "DELETE FROM `inscription` WHERE `id`=?";

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

    public static inscription getInscriptionById(int id) {

        PreparedStatement statement = null;

        String sql = "SELECT * FROM `inscription` WHERE `id`=?";

        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);

            statement.setLong(1, id);

            ResultSet result = statement.executeQuery();

            inscription student = null;
            if (result.next()) {
                student = new inscription();
                student.setId(result.getInt(1));
                student.setIdStudent(result.getInt(2));
                student.setDate_Res(LocalDate.parse(result.getDate(3).toString()));
                student.setN_bac(result.getString(4));
                student.setDate_bac(LocalDate.parse(result.getDate(5).toString()));
                student.setW_bac(result.getString(6));
                student.setN_ins_univ(result.getString(7));
//                student.setFeliere(result.getString(8));
                student.setCode(result.getString(8));
                student.setAnne(result.getString(9));
            }

            result.close();
            System.out.println("[successful]");
            return student;
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

    public static ObservableList<inscription> getInscriptionByIdStudent(int id) {

        PreparedStatement statement = null;

        String sql = "SELECT * FROM `inscription` WHERE `idStudent`=" + id;

        ObservableList<inscription> ol = FXCollections.observableArrayList();

        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                inscription student = new inscription();
                student.setId(result.getInt(1));
                student.setIdStudent(result.getInt(2));
                student.setDate_Res(LocalDate.parse(result.getDate(3).toString()));
                student.setN_bac(result.getString(4));
                student.setDate_bac(LocalDate.parse(result.getDate(5).toString()));
                student.setW_bac(result.getString(6));
                student.setN_ins_univ(result.getString(7));
//                student.setFeliere(result.getString(8));
                student.setCode(result.getString(8));
                student.setAnne(result.getString(9));
                ol.add(student);
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

  

}
