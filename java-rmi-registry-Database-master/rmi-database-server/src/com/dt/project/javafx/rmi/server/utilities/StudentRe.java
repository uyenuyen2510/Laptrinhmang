/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.server.utilities;

import com.dt.project.javafx.rmi.api.entity.student;
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
public class StudentRe {

    public static student insertPerson(student student) {
        PreparedStatement statement = null;

        String sql = "INSERT INTO `student`(`sid`, `name`, `gender`, `dob`, `age`, `nic`, `tel1`, `tel2`, `address`, `img`,'statu') VALUES (null,?,?,?,?,?,?,?,?,?,?)";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, student.getName());
            statement.setString(2, student.getGender());
            statement.setDate(3, Date.valueOf(student.getDob().toString()));
            statement.setInt(4, student.getAge());
            statement.setString(5, student.getNic());
            statement.setString(6, student.getTel1());
            statement.setString(7, student.getTel2());
            statement.setString(8, student.getAddress());
            statement.setString(9, student.getImg());
            statement.setInt(10, student.getStatu());

            statement.executeUpdate();

            try (ResultSet result = statement.getGeneratedKeys()) {
                if (result.next()) {
                    student.setSid(result.getInt(1));
                }
            }
            System.out.println("[successful]");
            return student;

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

    public static ObservableList<student> getstudent() {
        Statement statement = null;

        String sql = "SELECT * FROM `student`";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery(sql);

            ObservableList<student> ol = FXCollections.observableArrayList();

            while (result.next()) {
                student student = new student();
                student.setSid(result.getInt(1));
                student.setName(result.getString(2));
                student.setGender(result.getString(3));
                student.setDob(LocalDate.parse(result.getDate(4).toString()));
                student.setAge(24);
                student.setNic(result.getString(6));
                student.setTel1(result.getString(7));
                student.setTel2(result.getString(8));
                student.setAddress(result.getString(9));
                student.setImg(result.getString(10));
                student.setStatu(result.getInt(11));
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

    public static void updateStudent(student student) {

        PreparedStatement statement = null;

        String sql = "UPDATE `student` SET `name`=?,`gender`=?,`dob`=?,`age`=?,`nic`=?,`tel1`=?,`tel2`=?,`address`=?,`img`=? WHERE `sid`=?";

        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getGender());
            statement.setDate(3, Date.valueOf(student.getDob().toString()));
            statement.setLong(4, student.getAge());
            statement.setString(5, student.getNic());
            statement.setString(6, student.getTel1());
            statement.setString(7, student.getTel2());
            statement.setString(8, student.getAddress());
            statement.setString(9, student.getImg());
            statement.setLong(10, student.getSid());
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

    public static void deleteStudent(int id) {

        PreparedStatement statement = null;

        String sql = "DELETE FROM `student` WHERE `sid`=?";

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

    public static student getStudentById(int id) {

        PreparedStatement statement = null;

        String sql = "SELECT * FROM `student` WHERE `sid`=?";

        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);

            statement.setLong(1, id);

            ResultSet result = statement.executeQuery();

            student student = null;
            if (result.next()) {
                student = new student();
                student.setSid(result.getInt(1));
                student.setName(result.getString(2));
                student.setGender(result.getString(3));
                student.setDob(LocalDate.parse(result.getDate(4).toString()));
                student.setAge(24);
                student.setNic(result.getString(6));
                student.setTel1(result.getString(7));
                student.setTel2(result.getString(8));
                student.setAddress(result.getString(9));
                student.setImg(result.getString(10));
                student.setStatu(result.getInt(11));
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

    public static void main(String[] args) {

    }
}
