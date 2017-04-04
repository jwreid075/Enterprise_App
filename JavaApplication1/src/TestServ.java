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
                String htmlTotalButton = htmlPrint.totalButton();
                String htmlRemoveButton = htmlPrint.removeButton();
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
                pw.print("<body>\n" +"\n" +"<h1 align=\"center\">Create your order</h1>\n" +"\n" +"<div style=\"Width:100%\">\n" +
                        "<table  align=\"center\" style=\"border:2px double black; width:40%;\">");
               pw.print("<script>"
                       + "var btnArray = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];"
                       + "var nameArray = new Array(14);"
                       + "var priceArray = new Array(14);"
                       + "var totalArray = new Array(50);"
                       + "for(i = 0; i < totalArray.length; i++)"
                       + "{"
                       + "totalArray[i] = 0;"
                       + "}"
                       + "var counter = 0;"
                       + "var totalOutput = 0;"
                       + "</script>");
                 
               while(rs.next())
                {
                    String foodName = rs.getString("FOOD_NAME");
                    Float foodPrice = rs.getFloat("FOOD_PRICE");
 
                    pw.print("<tr>\n" +"<td style=\"border:2px double black;\">" + foodName + "</td>\n" +"<td style=\"border:2px double black;\">" + 
                            foodPrice + "</td>\n" +"<td style=\"border:2px double black;\"><button type=\"button\" onClick=\"AddToOrder(" + idNum + ")\" id=\"b" + idNum + "\">"+ "Add to order</button></td>\n<td><p id=\"newField" + idNum + "\">0</p></td>" +"</tr>");
                    pw.print("<script>document.getElementById(\"b" + idNum + "\").addEventListener(\"click\",AddToOrder);</script>");
                    pw.print("<script>nameArray[" + (idNum-1) + "] = \"" + foodName + "\";</script>");
                    pw.print("<script>priceArray[" + (idNum-1) + "] = " + foodPrice + ";</script>");
                       
                    idNum++;
                }

                pw.print("</table>");
                pw.print("<p id=\"totalField\" align=\"center\"></p>");
                pw.print("<script>document.getElementById(\"totalID\").addEventListener(\"click\",Total);</script>");
                pw.print("<script>document.getElementById(\"removeID\").addEventListener(\"click\",Remove);</script>");

                pw.print("<script>"
                       + "function AddToOrder(id)"
                       + "{"
                       + "btnArray[id - 1] += 1;"
                       + "var output = btnArray[id - 1].toString();"
                       + "document.getElementById(\"newField\" + id).innerHTML = output;"
                       + "totalArray[counter] = priceArray[id - 1];"
                       + "counter++;"
                       + "}"
                       + "</script>");
                pw.print("<script>"
                        +"function Total()"
                        + "{"
                        + " totalOutput = 0;"
                        + "for(i = 0; i < totalArray.length; i++)"
                        + "{"
                        + " totalOutput += totalArray[i];"
                        + "}"
                        + "document.getElementById(\"totalField\").innerHTML = \"Your total price: $\" + totalOutput;"
                        + "}" 
                        +"</script>");
               pw.print("<div align=\"center\">");
               pw.print(htmlTotalButton);
               pw.print(htmlRemoveButton);
               pw.print("</div>");
                pw.print("</body>");
                con.close();
            }
            catch(Exception e)
            {
                //pw.println("ERROR "+ e.getMessage());
            }	
        }
    
}
