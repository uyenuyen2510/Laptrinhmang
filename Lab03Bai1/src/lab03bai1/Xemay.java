/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03bai1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Xemay implements IXe {

    String bienso;
    String loaixe;
    String mauxe;
    float giatien;

    public Xemay() {
    }

    public Xemay(String bienso, String loaixe, String mauxe, float giatien) {
        this.bienso = bienso;
        this.loaixe = loaixe;
        this.mauxe = mauxe;
        this.giatien = giatien;
    }

    public String getBienso() {
        return bienso;
    }

    public void setBienso(String bienso) {
        this.bienso = bienso;
    }

    public String getLoaixe() {
        return loaixe;
    }

    public void setLoaixe(String loaixe) {
        this.loaixe = loaixe;
    }

    public String getMauxe() {
        return mauxe;
    }

    public void setMauxe(String mauxe) {
        this.mauxe = mauxe;
    }

    public float getGiatien() {
        return giatien;
    }

    public void setGiatien(float giatien) {
        this.giatien = giatien;
    }

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap bien so xe: ");
        bienso = sc.nextLine();
        System.out.print("Nhap loai xe: ");
        loaixe = sc.nextLine();
        System.out.print("Nhap mau xe: ");
        mauxe = sc.nextLine();
        System.out.print("Nhap gia tien: ");
        giatien = sc.nextFloat();

    }

    @Override
    public void hienthi() {
        System.out.print("Bien so xe :" + bienso);
        System.out.print("\nLoai xe :" + loaixe);
        System.out.print("\nMau xe :" + mauxe);
        System.out.print("\nGia tien : :" + giatien);
    }
    
    public void sapxep(){
        ArrayList<Xemay> dsxm = new ArrayList<>();

        Collections.sort(dsxm, new Comparator<Xemay>() {
            @Override
            public int compare(Xemay o1, Xemay o2) {
                return o1.getBienso().compareTo(o2.getBienso());
            }
        }
        );
        
        for(int i = 1 ; i <= dsxm.size() ; i++)
        {
            System.out.println("Bien so : " + dsxm.get(i).bienso + " Loai xe : " + dsxm.get(i).loaixe + " Mau xe : " + dsxm.get(i).mauxe + " Gia tien : " + dsxm.get(i).giatien);
        }
    }
}
