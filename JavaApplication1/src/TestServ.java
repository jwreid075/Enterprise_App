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
                int idNum = 1;
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
                pw.print("<body>\n" +"\n" +"<h1>Create your order</h1>\n" +"\n" +"<div style=\"Width:100%\">\n" +
                        "<table  align=\"left\" style=\"border:2px double black; width:40%;\">");
               pw.print("<script>"
                       + "var btnArray = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];"
                       + "var nameArray = new Array(14);"
                       + "var priceArray = new Array(14);"
                       + "</script>");
                 
               while(rs.next())
                {
                    String foodName = rs.getString("FOOD_NAME");
                    Float foodPrice = rs.getFloat("FOOD_PRICE");
                    
                    //pw.print("<hr>");
                    //pw.print("<center>");
                    /*pw.print("<center>" + foodName + " " + foodPrice + " " + "<button type=\"button\">"
                            + "Add to order</button><hr/></center>");*/  
                    pw.print("<tr>\n" +"<td style=\"border:2px double black;\">" + foodName + "</td>\n" +"<td style=\"border:2px double black;\">" + 
                            foodPrice + "</td>\n" +"<td style=\"border:2px double black;\"><button type=\"button\" onClick=\"AddToOrder(" + idNum + ")\" id=\"b" + idNum + "\">"+ "Add to order</button></td>\n<td><p id=\"newField" + idNum + "\">0</p></td>" +"</tr>");
                    pw.print("<script>document.getElementById(\"b" + idNum + "\").addEventListener(\"click\",AddToOrder);</script>");
                    pw.print("<script>nameArray[" + (idNum-1) + "] = \"" + foodName + "\";</script>");
                    pw.print("<script>priceArray[" + (idNum-1) + "] = " + foodPrice + ";</script>");

                    idNum++;
                }
                pw.print("</table>");
                pw.print("<script>"
                       + "function AddToOrder(id)"
                       + "{"
                       + "btnArray[id - 1] += 1;"
                       + "var output = btnArray[id - 1].toString();"
                       + "document.getElementById(\"newField\" + id).innerHTML = output;}"
                       + "function CompleteOrder(orderID)"
                       + "{"
                       +  ""
                       + "}"
                       + "</script>");
                
                pw.print("<form action=\"home.html\"><input type =\"submit\" value=\"Home\"/></form></li>");
                pw.print("</body>");
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
