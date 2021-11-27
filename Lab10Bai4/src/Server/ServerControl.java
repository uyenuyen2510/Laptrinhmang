/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Client.User;
import com.sun.jdi.connect.spi.Connection;
import java.beans.Statement;
import java.io.*;
import java.net.*;

/**
 *
 * @author CaoTrung
 */
public class ServerControl {

    private ServerView view;
    private Connection con;
    private DatagramSocket myServer;
    private int ServerPort = 5555;
    private DatagramPacket receivePacket = null;

    public ServerControl(ServerView view) {
        this.view = view;
        getDBConnection("usermanagement", "root", "12345678");
        openServer(ServerPort);
        view.showMessage("UDP Server is running...");
        while (true) {
            listenning();
        }
    }

    private void getDBConnection(String dbName, String username, String password) {
        String dbUrl = "jdbc:mysql://localhost:3306/" + dbName;
        String dbClass = "com.mysql.jdbc.Driver";
        try {
            Class.forName(dbClass);
            con = DriverManager.getConnection(dbUrl, username, password);
        } catch (Exception e) {
            view.showMessage(e.getStackTrace().toString());
        }
    }

    private void openServer(int portNumber) {
        try {
            myServer = new DatagramSocket(portNumber);
        } catch (IOException e) {
            view.showMessage(e.toString());
        }
    }

    private void listenning() {
        User user = receiveData();
        String result = "false";
        if (checkUser(user)) {
            result = "ok";
        }
        sendData(result);
    }

    private void sendData(String result) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(result);
            oos.flush();
            InetAddress IPAddress = receivePacket.getAddress();
            int ClientPort = receivePacket.getPort();
            byte[] sendData = baos.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(sendData,
                    sendData.length, IPAddress, ClientPort);
            myServer.send(sendPacket);
        } catch (Exception ex) {
            view.showMessage(ex.getStackTrace().toString());
        }
    }

    private User receiveData() {
        User user = null;
        try {
            byte[] receiveData = new byte[1024];
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            myServer.receive(receivePacket);
            ByteArrayInputStream bais = new ByteArrayInputStream(receiveData);
            ObjectInputStream ois = new ObjectInputStream(bais);
            user = (User) ois.readObject();
        } catch (Exception ex) {
            view.showMessage(ex.getStackTrace().toString());
        }
        return user;
    }

    private boolean checkUser(User user) {
        String query = "Select * FROM users WHERE username ='"
                + user.getUserName() + "' AND password ='" + user.getPassword() + "'";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            view.showMessage(e.getStackTrace().toString());
        }
        return false;
    }
}
