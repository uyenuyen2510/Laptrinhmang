/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab8bai5;

import java.net.*;
import java.io.*;

/**
 *
 * @author CaoTrung
 */
public class Lab8Bai5 {

    public final static int echoPort = 7;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        ServerSocket theServerSocket;
        Socket theConnectionSocket;
        BufferedReader in;
        PrintWriter out;
        try {
            theServerSocket = new ServerSocket(echoPort);
            System.out.println("EchoServer ready at port " + echoPort);
            while (true) {
                theConnectionSocket = theServerSocket.accept();
                try {
                    System.out.println("Request arrived!");
                    in = new BufferedReader(new InputStreamReader(theConnectionSocket.getInputStream()));
                    out = new PrintWriter(theConnectionSocket.getOutputStream(), true);
                    while (true) {
                        String readText = in.readLine();
                        out.println(readText);
                    }
                } catch (IOException e) {
                    theConnectionSocket.close();
                }
            }
        } catch (IOException e) {
        }
    }

}
