/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab8bai3;

import java.net.*;
import java.io.*;

/**
 *
 * @author CaoTrung
 */
public class Lab8Bai3 {

    final static int defaultPort = 7;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Socket ClientSocket;
        String hostName;
        int portNumber;
        BufferedReader theInput;
        PrintWriter theOutput;
        BufferedReader userInput;
        String inputString;
        switch (args.length) {
            case 1:
                hostName = args[0];
                portNumber = defaultPort;
                break;
            case 2:
                hostName = args[0];
                portNumber = new Integer(args[1]).intValue()
                );
break;
            default:
                hostName = "localhost";
                portNumber = defaultPort;
        }
        try {
            System.out.println("Client side Echo utility");
            ClientSocket = new Socket(hostName, portNumber);
            theInput = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
            theOutput = new PrintWriter(ClientSocket.getOutputStream());
            userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your text or put only \'.\' to quit.");
            while (true) {
                inputString = userInput.readLine();
                if (inputString.equals(".")) {
                    break;
                }
                theOutput.println(inputString);
                System.out.println(theInput.readLine());
            }
        } catch (UnknownHostException e) {
            InterruptedException(" Unknown host error");
        } catch (ConnectException e) {
            System.out.println(" Service unavailable on port "
                    + portNumber + " of host " + hostName);
        } catch (IOException e) {
            InterruptedException(" Communication error occured\r\n " + e);
        }
    }
}
}
    
}
