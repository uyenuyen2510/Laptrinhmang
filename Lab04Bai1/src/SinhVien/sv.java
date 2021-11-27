/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinhVien;

import java.util.Scanner;

/**
 *
 * @author Duc Hieu IT
 */
public class sv {
    String msv;
    String ten;
    int nam;
    String dc;
    String lop;
    public Scanner sc=new Scanner(System.in);
    public sv() {
    }

    public sv(String msv, String ten, int nam, String dc, String lop) {
        this.msv = msv;
        this.ten = ten;
        this.nam = nam;
        this.dc = dc;
        this.lop = lop;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }


    public void Nhap()
    {
        System.out.print("Nhap MSV: ");
        msv=sc.nextLine();
        System.out.print("Nhap Ten: ");
        ten=sc.nextLine();
        System.out.print("Nhap Nam Sinh: ");
        nam=sc.nextInt();sc.nextLine();
        System.out.print("Nhap Dia Chi: ");
        dc=sc.nextLine();
        System.out.print("Nhap Lop: ");
        lop=sc.nextLine();
    }
    public void Xuat()
    {
        System.out.printf("%1s %5s %5d %5s %5s",msv,ten,nam,dc,lop);
    }
}
