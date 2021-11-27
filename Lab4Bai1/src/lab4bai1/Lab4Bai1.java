/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab4bai1;

/**
 *
 * @author Cao Trinh
 */
public class Lab4Bai1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       DanhSachSinhVien qlsv=new DanhSachSinhVien();  
       SinhVien teo=new SinhVien();   
       teo.setMasv("113");   
       teo.setTensv("Nguyễn Văn Tèo");   
       qlsv.addSinhvien(teo);   
       SinhVien ty=new SinhVien();   
       ty.setMasv("114");   
       ty.setTensv("Nguyễn Thị tý");   
       qlsv.addSinhvien(ty);   
       qlsv.sort(); 
       System.out.println(qlsv);
    }
    
}
