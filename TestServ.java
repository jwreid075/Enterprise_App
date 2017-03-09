import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import javax.swing.*;

public class TestServ extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
                DBConnection testDb = new DBConnection();
                Connection con = testDb.DBConnection();   
                mainHtmlPrint htmlPrint = new mainHtmlPrint();
                String htmlPrintOne = htmlPrint.htmlReturn();
                String htmlPrintTwo = htmlPrint.secondHtmlReturn();
                
                String query = "select FOOD_NAME, FOOD_PRICE from FOOD";    
         try
            {
                //What kind of response is going to the browser
                res.setContentType("text/html"); 
		PrintWriter pw=res.getWriter();
		//String name=req.getParameter("name");
                //pw.println("Welcome Hi "+name);
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery(query);

                pw.print(htmlPrintOne);  
                pw.print(htmlPrintTwo);
                while(rs.next())
                {
                    String foodName = rs.getString("FOOD_NAME");
                    Float foodPrice = rs.getFloat("FOOD_PRICE");
                    
                    //pw.print("<hr>");
                    //pw.print("<center>");
                    pw.print("<center>" + foodName + " " + foodPrice + " " + "<button type=\"button\">"
                            + "Add to order</button><hr/></center>");  
                }
                //}
                //pw.println(rs.getInt(1) + " " + rs.getString(2)+ " " +rs.getString(3));
                con.close();
            }
            catch(Exception e)
            {
                //pw.println("ERROR "+ e.getMessage());
            }	
        }
    
}
