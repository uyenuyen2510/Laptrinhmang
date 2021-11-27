/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.server.service;

import com.dt.project.javafx.rmi.api.entity.student;
import com.dt.project.javafx.rmi.api.service.StudentService;
import com.dt.project.javafx.rmi.server.utilities.DatabaseConnection;
import java.rmi.RemoteException;
import static java.rmi.server.RemoteServer.getClientHost;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bureau
 */
public class StudentServiceImpl extends UnicastRemoteObject implements StudentService {

    public StudentServiceImpl() throws RemoteException {
    }

    @Override
    public List<student> getstudent() throws RemoteException {
        try {
            System.out.print("\nClient " + getClientHost() + " request getPersonById() method...");
        } catch (ServerNotActiveException ex) {
        }
        Statement statement = null;

        String sql = "SELECT * FROM `student`";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);

            List<student> ol;
            try (ResultSet result = statement.executeQuery(sql)) {
                ol = new ArrayList<>();
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
            }

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

    @Override
    public void aff() throws RemoteException {
        System.out.println("klcxmlwcksdm,vklsd");
    }

    public static void main(String[] args) throws RemoteException {
        StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
        studentServiceImpl.setStatu(1, 10);
    }

//    @Override
//    public String getNameStudent(int id) throws RemoteException {
//        try {
//            System.out.print("\nClient " + getClientHost() + " request getPersonById() method...");
//        } catch (ServerNotActiveException ex) {
//        }
//
//        PreparedStatement statement = null;
//
//        String sql = "SELECT  `name` FROM `student` WHERE `sid`=?";
//
//        try {
//            statement = DatabaseConnection.getConnection().prepareStatement(sql);
//
//            statement.setInt(1, id);
//
//            ResultSet result = statement.executeQuery();
//
//            String name = null;
//            if (result.next()) {
//                name = result.getString(1);
//
//            }
//
//            result.close();
//            System.out.println("[successful]");
//            return name;
//        } catch (SQLException ex) {
//            System.out.println("[failed]");
//            ex.printStackTrace();
//            return null;
//        } finally {
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//            }
//            try {
//                //Sorry, I forgot to close the connection to the database :D
//                DatabaseConnection.getConnection().close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
    @Override
    public void setStatu(int st, int id) throws RemoteException {
        try {
            System.out.print("\nClient " + getClientHost() + " request getPersonById() method...");
        } catch (ServerNotActiveException ex) {
        }

        PreparedStatement statement = null;

        String sql = "UPDATE `student` SET `statu`="+st+ " WHERE `sid`="+id;

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
    
   
}
