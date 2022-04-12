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
            con = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6424812?useUnicode=true&characterEncoding=UTF-8", "sql6424812","iNCTFpyiiJ");
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
