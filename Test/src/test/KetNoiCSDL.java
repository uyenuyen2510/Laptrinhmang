/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Cao Trinh
 */
public class KetNoiCSDL {
    Connection conn=null;
    public KetNoiCSDL() throws SQLException{
        String url="jdbc:mysql://localhost:3306/qlhd";
        this.conn=DriverManager.getConnection(url,"root","");
    }
    
    public ResultSet LayDL(String tbname) throws SQLException{
        ResultSet rs =null;
        Statement ts= this.conn.createStatement();
        String sql="select * from "+tbname; /*ORDER BY `Luong` ASC*/
        rs=ts.executeQuery(sql);
        return rs;
    }
    public ResultSet LayDL2(String tbname) throws SQLException{
        ResultSet rs =null;
        Statement ts= this.conn.createStatement();
        String sql="select * from "+tbname;/*ORDER BY `Luong` DESC*/
        rs=ts.executeQuery(sql);
        return rs;
    }
    public void UpdateCH(String ma, String ten, String sdt) throws SQLException { 
        Statement sta = this.conn.createStatement();
        String sql0="UPDATE khachhang SET `tenkh`='" + ten + "',`dthoai`='" + sdt +"' WHERE `makh`='"+ ma + "'";
        sta.executeUpdate(sql0);
    }

    public void InsertCH(String ma, String ten, String sdt) throws SQLException { 
        Statement sta = this.conn.createStatement(); 
        String sql1 = "Insert khachhang values('"+ma+"','"+ten+"','"+sdt+"')";
        sta.executeUpdate(sql1);
    }

    public void Delete(String ma) throws SQLException {

        Statement sta = this.conn.createStatement();
        String sql = "Delete from khachhang WHERE `makh`='"+ ma +"'";
        sta.executeUpdate(sql);
    }
    
    public void UpdateTG(String ten, String email, String diachi, String sdt, String coquan, int sogiogd) throws SQLException { 
        Statement sta = this.conn.createStatement();
        int a=200000;
        int luong=sogiogd*a;
        String sql0="UPDATE gvtg SET `Email`='" + email + "',`DiaChi`='" + diachi + "',`SDT`='" + sdt +"',`CoQuan`='" + coquan +"',`SoGioGD`='" + sogiogd +"',`Luong`='" + luong +"' WHERE `TenGV`='"+ ten + "'";
        sta.executeUpdate(sql0);
    }

    public void InsertTG(String ten, String email, String diachi, String sdt, String coquan, int sogiogd) throws SQLException { 
        Statement sta = this.conn.createStatement();
        int a=200000;
        int luong=sogiogd*a;
        String sql1 = "Insert gvtg values('"+ten+"','"+email+"','"+diachi+"','"+sdt+"','"+coquan+"','"+sogiogd+"','"+luong+"')";
        sta.executeUpdate(sql1);
    }
    public void DeleteTG(String ma) throws SQLException {

        Statement sta = this.conn.createStatement();
        String sql = "Delete from gvtg WHERE `TenGV`='"+ ma +"'";
        sta.executeUpdate(sql);
    }
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        KetNoiCSDL kn = new KetNoiCSDL();
        ResultSet rs = kn.LayDL("khachhang");
        while(rs.next())
            {
                System.out.println(rs.getString(1)+" - "+ rs.getString(2)+" - "+
                    rs.getString(3));
            }
    }
}
