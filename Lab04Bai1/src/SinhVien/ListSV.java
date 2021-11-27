/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinhVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Duc Hieu IT
 */
public class ListSV {
    ArrayList<sv> dssv = new ArrayList<sv>();
    private boolean ktraMsv(String masv) {
        for (sv a: dssv) {
            if(a.getMsv().equalsIgnoreCase(masv))
                return true;
        }
        return false;
    }
    public boolean addsv(sv a)
    {
        if(ktraMsv(a.getMsv()))
            return false;
        return dssv.add(a);
    }
    public sv timkiem(String masv)
    {
        for (sv a: dssv) {
            if(a.getMsv().equalsIgnoreCase(masv))
                a.Xuat();
        }
        return null;
    }
    public sv sua(int x, sv a)
    {
        return dssv.set(x-1, a);
    }
    public void xoa(String masv)
    {
        sv a=timkiem(masv);
        dssv.remove(a);
    }
    public void sapxep()
    {
        Collections.sort(dssv, new Comparator<sv>() {
            @Override
            public int compare(sv o1, sv o2) {
                return o1.getMsv().compareTo(o2.getMsv());
            }
        });
    }
}
