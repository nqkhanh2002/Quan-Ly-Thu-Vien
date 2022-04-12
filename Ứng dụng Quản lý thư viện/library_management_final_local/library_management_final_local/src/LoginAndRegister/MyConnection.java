package LoginAndRegister;
import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
    public static Connection getConnection(){
        
        Connection connect = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/sql6424812?useUnicode=true&characterEncoding=UTF-8", "root","");
            
        }catch(Exception e){
            
            System.out.print(e.getMessage());
        }
       return connect; 
    }

    static Object getConnect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
