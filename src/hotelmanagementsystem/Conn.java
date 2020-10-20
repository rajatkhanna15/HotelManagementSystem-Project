
package hotelmanagementsystem;

/**
 *
 * @author rajat
 */
import java.sql.*;  

public class Conn{
    Connection c;
    Statement s;
    public Conn(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///HotelManagementSystem","root","Rajat9241"); 
            System.out.println("Connection Successful");
            s =c.createStatement();  
            
           
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
    public static void main(String[] args)
    {
        new Conn();
    }
}  
