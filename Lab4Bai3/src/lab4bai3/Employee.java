/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4bai3;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Cao Trinh
 */
public class Employee {
    public String manv;
    public String tennv;
    public String chucvu;
    public float luong;
    public int thoigian;

    public Employee() {
    }

    public Employee(String manv, String tennv, String chucvu, float luong, int thoigian) {
        this.manv = manv;
        this.tennv = tennv;
        this.chucvu = chucvu;
        this.luong = luong;
        this.thoigian = thoigian;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public int getThoigian() {
        return thoigian;
    }

    public void setThoigian(int thoigian) {
        this.thoigian = thoigian;
    }
    
    public void nhap(){
        ArrayList<Employee> em = new ArrayList<>();
        em.add(tennv);
        em.add(manv);
        em.add(chucvu);
        em.add(luong);
        em.add(thoigian);
        
    }
    
}
