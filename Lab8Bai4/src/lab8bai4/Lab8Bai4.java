/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab8bai4;

import java.net.*;
import java.io.*;
import java.util.Date;

/**
 *
 * @author CaoTrung
 */
public class Lab8Bai4 {

    public final static int daytimePort = 13;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServerSocket theServerSocket;
        Socket theConnectionSocket;
        PrintWriter out;
        try {
            theServerSocket = new ServerSocket(daytimePort);
            System.out.println("TimeServer ready at port " + daytimePort);
            try {
                while (true) {
                    theConnectionSocket = theServerSocket.accept();
                    System.out.println("Request arrived!");
                    out = new PrintWriter(theConnectionSocket.getOutputStream(), true);
                    out.println(new Date());
                    theConnectionSocket.close();
                }
            } catch (IOException e) {
                theServerSocket.close();
                InterruptedException(e);
            }
        } catch (IOException e) {
            InterruptedException(e);
        }

    }
