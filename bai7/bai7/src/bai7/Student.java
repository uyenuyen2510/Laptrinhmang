/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai7;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class Student extends Person {

    public Student(double Diem1, double Diem2, double DiemTB, String HoTen, String DiaChi) {
        super(HoTen, DiaChi);
        this.Diem1 = Diem1;
        this.Diem2 = Diem2;
        this.DiemTB = DiemTB;
        DiemTB = (Diem1 + Diem2)/2;
    }

    public double getDiem1() {
        return Diem1;
    }

    public double getDiem2() {
        return Diem2;
    }

    public double getDiemTB() {
        return DiemTB;
    }

    

    public Student() {
    }
    private double Diem1, Diem2, DiemTB;
    
     public void HienThi() {
        super.HienThi();
        System.out.println("\tDiem 1: " + Diem1);
        System.out.println("\tDiem 2: " + Diem2);
        System.out.println("\tDiem trung binh: " + DiemTB);
}    
     public void Nhap(Scanner sc) {
        super.Nhap(sc);
        System.out.print("\tNhap diem 1: ");
        Diem1 = sc.nextDouble();
        System.out.print("\tNhap diem 2: ");
        Diem2 = sc.nextDouble();
       
        DiemTB = (Diem1 + Diem2 ) / 2;
    }
}
