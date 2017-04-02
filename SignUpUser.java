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

public class SignUpUser extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
                DBConnection testDb = new DBConnection();
                Connection con = testDb.DBConnection();   
                mainHtmlPrint htmlPrint = new mainHtmlPrint();
                String htmlPrintOne = htmlPrint.htmlReturn();
                String htmlPrintTwo = htmlPrint.secondHtmlReturn();
                //int idNum = 1;
                //String query = "select USERNAME from users";    
         try
            {
                //What kind of response is going to the browser
                res.setContentType("text/html"); 
		PrintWriter pw=res.getWriter();
		//String name=req.getParameter("name");
                //pw.println("Welcome Hi "+name);
                //Statement stmt=con.createStatement();
                //ResultSet rs=stmt.executeQuery(query);

                pw.print(htmlPrintOne);  
                pw.print(htmlPrintTwo);
                pw.print("<body>\n" 
                        +"<table align='center' width='80%'>\n"
                        +"<tr>\n"
                        +"<td>\n"
                        +"<h1>Log-In</h1>\n"
                        +"<form>\n"
                        +"<input id=\"userName\" type=\"text\" placeholder=\"Username\"/>\n"
                        +"<input id=\"userPassword\" type=\"password\" placeholder=\"Password\"/>\n"
                        +"<input type=\"submit\" value\"Login\" method=\"get\"/>"
                        +"</form>\n"
                        +"</td>\n"
                        +"</tr>\n"
                        +"</table>\n"
                        +"</tr>\n" 
                        +"<table align='center' width='50%'>\n" 
                        +"<tr>\n" 
                        +"<td colspan=\"2\">\n" 
                        +"<div align='center'><h1>Sign Up</h1></div>\n" 
                        +"</td>\n" 
                        +"<tr>\n" 
                        +"<td>\n" 
                        +"<form>\n" 
                        +"<div align=\"center\"><input id=\"newUserName\" type=\"text\" placeholder=\"Username\"/></div><br/>\n"
                        +"<div align=\"center\"><input id=\"newPassword\" type=\"password\" placeholder=\"Password\" /></div><br />\n"
                        +"<div align=\"center\"><input id=\"firstName\" type=\"text\" placeholder=\"First Name\" /></div><br />\n"
                        +"<div align=\"center\"><input id=\"lastName\" type=\"text\" placeholder=\"Last Name\" /></div><br />\n" 
                        +"<div align=\"center\"><input id=\"address\" type=\"text\" placeholder=\"Address\" /></div><br />\n" 
                        +"<div align=\"center\"><input id=\"city\" type=\"text\" placeholder=\"City\" /></div><br />\n" 
                        +"<div align=\"center\"><input id=\"state\" type=\"text\" placeholder=\"State\" /></div><br />\n" 
                        +"<div align=\"center\"><input id=\"zipCode\" type=\"text\" placeholder=\"Zip Code\" /></div><br />\n"
                        +"<button type=\"button\" id=\"signUpButton\" value=\"Sign Up\" onClick=\"signUpUser()\">Sign Up</button>"
                        +"<script>document.getElementById(\"signUpButton\").addEventListener(\"click\",signUpUser);</script>"
                        +"<br/>\n" 
                        +"</form>\n" 
                        +"</td>\n" 
                        +"</tr>\n" 
                        +"</table>\n"
                        +"<script>"
                        + "function signUpUser()"
                        + "{"
                        + " var userName = document.getElementById(\"newUserName\").value;"
                        + " document.write(<p>userName</p>)"
                        + "}"
                        +"</body>\n" 
                );
                
                        pw.print("<hr>\n"
                        +"<p style=\"font-size: 12px; text-align: center\">Copyright Das Schwarze Hahnchen (R) 2017</p>"
                );
                con.close();
            }
            catch(Exception e)
            {
                //pw.println("ERROR "+ e.getMessage());
            }	
        }
    
}
