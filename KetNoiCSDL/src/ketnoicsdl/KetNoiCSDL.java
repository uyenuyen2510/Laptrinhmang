/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ketnoicsdl;

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

    /**
     * @param args the command line arguments
     */
    Connection conn = null;
    public KetNoiCSDL() throws SQLException{
        String url ="jdbc:mysql://localhost:/quanly";
        this.conn = DriverManager.getConnection(url,"root","");
    }
    public ResultSet laydl(String tenbang) throws  SQLException{
        ResultSet kq = null;
        Statement st = this.conn.createStatement();
        String sql ="select * from thongtin";
        kq =st.executeQuery((sql));
        return kq;
    }
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        KetNoiCSDL a = new KetNoiCSDL();
        ResultSet rs = a.laydl("thongtin");
        while(rs.next())
        {
            System.out.println(rs.getString(1) + " - " + rs.getString(3));
        }
    }
    
}
