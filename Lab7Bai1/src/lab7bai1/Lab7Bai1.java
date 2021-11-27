/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7bai1;

import java.net.*;
import java.net.InetAddress;

/**
 *
 * @author Cao Trinh
 */
public class Lab7Bai1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("Hello. My name is " + address.getHostName() + " and my IP adress is " + address.getHostAddress());
        }
        catch (UnknownHostException e) 
        {
        System.out.println("I don't know my own name and address.");
        }
    }
    
}
