/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7bai2;
import java.net.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Cao Trinh
 */
public class Lab7Bai2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
        InetAddress[] addr = InetAddress.getAllByName("www.microsoft.com");
        for (int i = 0; i < addr.length; i++)
        {
        System.out.println (addr[i]);
        }
        }
        catch (UnknownHostException ex)
        {
        System.out.println("Could not find www.microsoft.com");
        }
    }
    
}
