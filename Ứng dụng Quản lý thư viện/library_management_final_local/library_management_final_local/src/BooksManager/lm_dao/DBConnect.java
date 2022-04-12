package BooksManager.lm_dao;

import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    
    public static Connection getConnection() {
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/sql6424812?useUnicode=true&characterEncoding=UTF-8", "root","");
            return con;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return con;
    }
    
    public static void main(String[] args) throws SQLException {
        Connection c = getConnection();
        System.out.println(c.toString());
        c.close();
    }
}
