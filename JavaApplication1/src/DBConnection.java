import java.sql.*;

public class DBConnection
{   
    public Connection DBConnection()
    {
        try
        {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con =DriverManager.getConnection("jdbc:oracle:thin:jwr17/JX3vAZCM@//stuoracle.ptcollege.edu:1521/ORCL");
                return con;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    
}