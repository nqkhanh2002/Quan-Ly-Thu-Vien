package Dashboard;
import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
    public static Connection getConnection(){
        
        Connection connect = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6424812?useUnicode=true&characterEncoding=UTF-8", "sql6424812","iNCTFpyiiJ");
            
        }catch(Exception e){
            
            System.out.print(e.getMessage());
        }
       return connect; 
    }
    
}
