/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecttosqlserver;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.*;
/**
 *
 * @author Pham Truong
 */
public class ConectToSQLserver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var server = "DESKTOP-VUFA1BS\\SQLEXPRESS03";
        var user = "sa";
        var password = "041220";
        var db = "Login";
        var port = "1433";
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(user);
        ds.setPassword(password);
        ds.setDatabaseName(db);
        ds.setServerName(server);
        ds.setPortNumber(1433);
        try (Connection conn = ds.getConnection()){
            System.out.println("Kết Nối với SQL Server thành công!");
            System.out.println(conn.getCatalog());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
