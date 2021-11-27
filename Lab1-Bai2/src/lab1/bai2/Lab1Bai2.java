/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1.bai2;
import java.util.Scanner;

/**
 *
 * @author Cao Trinh
 */
public class Lab1Bai2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a,b,max,min; 
        Scanner sc = new Scanner(System.in); //Phím tắt  CTRL + Space 
        System.out.println("Nhap so nguyen a:"); 
        a = sc.nextInt(); 
        System.out.println("Nhap so nguyen b:"); 
        b = sc.nextInt(); 
        max = (a>b)?a:b; 
        min = (a>b)?b:a; 
        System.out.println("Max la:"+max); 
        System.out.println("Min la:"+min); 
    }
    
}
