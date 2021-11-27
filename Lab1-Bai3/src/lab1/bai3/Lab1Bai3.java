/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1.bai3;
import java.util.Scanner;

/**
 *
 * @author Cao Trinh
 */
public class Lab1Bai3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a, b, c, delta; 
        Scanner sc = new Scanner(System.in); 
           do{ 
            System.out.println("Nhap he so a:"); 
            a = sc.nextInt(); 
            if(a==0) 
            System.out.println("Nhap lai a!"); 
        }while(a==0); 
         System.out.println("Nhap he so b:"); 
            b = sc.nextInt(); 
         System.out.println("Nhap he so c:"); 
        c = sc.nextInt(); 
            delta = b*b-4*a*c; 
        if(delta<0) 
            System.out.println("PT vo nghiem"); 
        else if(delta==0){ 
            float x = (float)-b/(2*a); 
            System.out.printf("PT co nghiem kep x1=x2=%.2f",x); 
        }else{ 
            float x1 = (float) (-b-Math.sqrt(delta))/(2*a); 
            float x2 = (float) (-b+Math.sqrt(delta))/(2*a); 
            System.out.println("PT co 2 nghiem phan biet:"); 
            System.out.printf("\tx1=%.2f \n",x1); 
            System.out.printf("\tx2=%.2f \n",x2); 
        } 
  
    }
    
}
