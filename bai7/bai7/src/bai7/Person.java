/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai7;

import  java.util.Scanner;
/**
 *
 * @author Admin
 */
public class Person {

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public Person(String HoTen, String DiaChi) {
        this.HoTen = HoTen;
        this.DiaChi = DiaChi;
    }

    public Person() {
    }
    private String HoTen;
    private  String DiaChi;
    
    public void HienThi() {
       
        System.out.println("\tHo ten: " + HoTen);
        System.out.println("\tDia Chi: " + DiaChi);
    }
    public void Nhap(Scanner sc) {
        
        System.out.print("\tNhap ho ten: ");
        sc.nextLine();
        HoTen = sc.nextLine();
        
        System.out.print("\tNhap dia chi: ");
        sc.nextLine();
        DiaChi = sc.nextLine();
        
    }
}
