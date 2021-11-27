/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author caodi
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KetNoiCSDL {

    private Connection con;

    public KetNoiCSDL() throws  SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:/quanly", "root", "");
    }

    public ResultSet GetData(String tbName) throws SQLException {
        ResultSet kq = null;
        Statement statement = this.con.createStatement();
        String sql = "select * from quanlythongtin";
        kq = statement.executeQuery(sql);
        return kq;
    }

    public void Update(int ma, String hoten, int sdt, String diachi) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql1 = "Update quanlythongtin set hoten='" + hoten + "', sdt='" + sdt + "',diachi='" + diachi + "' where ma =" + ma + "";
        String sql2 = "Update quanlythongtin set hoten='" + hoten + "', sdt='" + sdt + "',diachi='" + diachi + "' where ma =" + ma + "";
        sta.executeUpdate(sql1);
        sta.executeUpdate(sql2);
    }

    public void Insert(int ma, String hoten, int sdt, String diachi) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql1 = "Insert quanlythongtin values("+ma+",'"+hoten+"'  ,"+sdt+" ,"+diachi+" )";
        sta.executeUpdate(sql1);
    }

    public void Delete(int ma) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql = "delete quanlythongtin where ma =" + ma + "";
        sta.executeUpdate(sql);
    }

    public void Close() throws SQLException {
        if (this.con != null) {
            this.con.close();
        }
    }
}
