/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
/**
 *
 * @author jwr17
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try
            {
            Class.forName("oracle.jdbc.driver.OracleDriver");
    
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:jwr17/JX3vAZCM@//stuoracle.ptcollege.edu:1521/ORCL");
            
            /*res.setContentType("text/html");

		PrintWriter pw=res.getWriter();
		String name=req.getParameter("name");
		pw.println("Welcome "+name);*/
            
            Statement stmt=con.createStatement();
    
            ResultSet rs=stmt.executeQuery("select * from FOOD");
            while(rs.next())
            System.out.println(rs.getInt(1) + " " + rs.getString(2)+" " +rs.getString(3));
    
            con.close();
            }
            catch(Exception e){System.out.println(e);}
    }
    
}
