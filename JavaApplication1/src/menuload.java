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

public class menuload extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
                DBConnection testDb = new DBConnection();
                Connection con = testDb.DBConnection(); 
                mainHtmlPrint htmlPrint = new mainHtmlPrint();
                String htmlPrintOne = htmlPrint.htmlMenuLoadOne();
                String htmlPrintTwo = htmlPrint.htmlMenuLoadTwo();
                
                String query = "select FOOD_NAME, FOOD_PRICE, DESCRIPTION from FOOD";
                int counter = 0;
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
                
                pw.print("<tr>");
                pw.print("<table border=\" 1px solid black\">");
                pw.print("<tr style=\"text-align: center;\">");
                
                while(rs.next())
                {
                    String foodName = rs.getString("FOOD_NAME");
                    Float foodPrice = rs.getFloat("FOOD_PRICE");
                    String foodDescription = rs.getString("DESCRIPTION");

                    pw.print("<td>" + "<img style=\"width:75px;height:75px;\" src=\"logo.png\">" + "<td style=\"width:350px;\">\n" + "<p>" + foodName + " - $" + foodPrice + "</br>" + foodDescription +"</p>"+"\n" + "</td>");
                    counter++;
                    
                    if(counter == 3)
                    {
                        pw.print("</tr>" + "<tr>");
                        counter = 0;
                    } 
                }
                
                pw.print("</tr>");
                pw.print("</table>");
                
                //pw.println(rs.getInt(1) + " " + rs.getString(2)+ " " +rs.getString(3));
                con.close();
            }
            catch(Exception e)
            {
               //pw.println("ERROR "+ e.getMessage());
            }	
        }
    
}
