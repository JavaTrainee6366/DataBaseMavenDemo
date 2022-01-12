package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_Connection {
	
	static Connection con = null;
	  
    
    public static Connection db()
    {
       try{
          
        Class.forName("com.mysql.cj.jdbc.Driver");
             
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","root");
               // System.out.println("Connection Succeed::");
             
    }catch(Exception e)
        {
          System.out.print(e);        
        }
       return con;
    }

}
