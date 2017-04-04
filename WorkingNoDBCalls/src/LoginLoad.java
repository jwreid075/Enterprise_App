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

public class LoginLoad extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
                DBConnection testDb = new DBConnection();
                Connection con = testDb.DBConnection();   
                mainHtmlPrint htmlPrint = new mainHtmlPrint();
                String htmlPrintOne = htmlPrint.htmlReturn();
                String htmlPrintTwo = htmlPrint.secondHtmlReturn();
                String query1 = "select USERNAME, USER_PASSWORD from USERS";
                
                //int idNum = 1;
                //String query a= "select USERNAME from users";    
         try
            {
                //What kind of response is going to the browser
                res.setContentType("text/html"); 
		PrintWriter pw=res.getWriter();
		//String name=req.getParameter("name");
                //pw.println("Welcome Hi "+name);
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery(query1);

                pw.print(htmlPrintOne);  
                pw.print(htmlPrintTwo); 
                pw.print("<body>\n" 
                        +"<table align='center' width='80%'>\n"
                        +"<tr>\n"
                        +"</tr>\n"
                        +"</table>\n"
                        +"</tr>\n" 
                        +"<table align='center' width='50%'>\n" 
                        +"<tr>\n" 
                        +"<td colspan=\"2\">\n" 
                        +"<div align='center'><h1>Sign Up</h1>\n" 
                        +"</td>\n" 
                        +"<tr>\n" 
                        +"<td>\n"
                        +"<form name=\"signup\" align=\"center\">\n" 
                        +"Username<input type=\"text\" name=\"newUserId\"/><br/>\n"
                        +"Password<input type=\"password\"name=\"newPassword\"/><br/>\n"
                        +"First Name<input type=\"text\"  name=\"firstName\"/><br />\n"
                        +"Last Name<input type=\"text\" name=\"lastName\"/><br/>\n" 
                        +"Address<input type=\"text\" name=\"address\"/><br/>\n" 
                        +"City<input type=\"text\" name=\"city\"/><br/>\n" 
                        +"State<input type=\"text\" name=\"state\"/><br/>\n" 
                        +"Zipcode<input type=\"text\" name=\"zipCode\"/><br/>\n"
                        +"<button type=\"button\" onClick=\"signUp(this.form)\" id=\"signUpButton\">" + "Sign Up</button>"
                        +"<script>document.getElementById(\"signUpButton\").addEventListener(\"click\",signUp);</script>"
                        +"<input type=\"reset\" value=\"Clear\"/>\n"
                        +"<br/>\n" 
                        +"</form>\n" 
                        +"</div>"
                        +"</td>\n" 
                        +"</tr>\n" 
                        +"</table>\n");

                pw.print("<h1 align=\"center\">Log-In</h1>\n"
                        +"<div align=\"center\">"
                        + "<form name=\"login\" align=\"center\">\n"
                        +"Username<input type=\"text\" name=\"userid\"/><br>\n"
			+"Password<input type=\"password\" name=\"pswrd\"/><br>\n"
                        +"<button type=\"button\" onClick=\"check(this.form)\" id=\"login\">" + "Login</button>"
                        +"<script>document.getElementById(\"login\").addEventListener(\"click\",check);</script>"
			+"<input type=\"reset\" value=\"Clear\"/>\n"
			+"</form></div>");

                //String userName = rs.getString("USERNAME");
                //String passWord = rs.getString("USER_PASSWORD");
                pw.print(
                        "<script language=\"javascript\">\n"
                        +"function check(form)\n"
                        +"{\n"
                        +"if(form.userid.value ==\"CallofDuty\" && form.pswrd.value ===\"derrick\")\n"
			+"{\n"
			+"window.open('loggedIn.html');\n"
			+"}\n"
			+"else{alert(\"Error Password or Username\");\n}"
                        +"}\n"
                        +"</script>");
                pw.print("<script>"
                        +"function signUp(form)\n"
                        +"{"
                        +"if(form.newUserId.value == \"CallofDuty\" && form.newPassword.value ==\"derrick\" && form.firstName.value ==\"Derrick\")\n"
                            +"{"
                            +"window.open('signedUp.html');\n"
                            +"}"
                        +"else{alert(\"Must enter valid information\");\n}"
                        +"}"
                        + "</script>");
                
                pw.print("<hr>\n"
                        +"<p style=\"font-size: 12px; text-align: center\">Copyright Das Schwarze Hahnchen (R) 2017</p>"
                );
                        
                pw.print("</body>\n");

                con.close();
            }
            catch(Exception e)
            {
                //pw.println("ERROR "+ e.getMessage());
            }	
        }
        
        /*public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
            DBConnection testDb = new DBConnection();
            Connection con = testDb.DBConnection();   
            String query1 = "Select USERNAME from USERS;";
            
            try
            {
                res.setContentType("text/html"); 
                PrintWriter pw=res.getWriter();     
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery(query1);
                String userName = rs.getString("USERNAME");
                
                if(req.getParameter("newUserName").equals(userName))
                {
                   stmt.execute("INSERT INTO USERS (USERNAME, USER_PASSWORD, FIRST_NAME, LAST_NAME, ADDRESS, CITY, STATE_ABBR, ZIPCODE, USERTYPE) VALUES(" + req.getParameter("newUserName")+","+req.getParameter("newPassword")+","+req.getParameter("firstName")+","+req.getParameter("lastName")+","+req.getParameter("address")+","+req.getParameter("city")+","+req.getParameter("state")+","+req.getParameter("zipCode")+",CUSTOMER)");
                   pw.print("<script>"
                            + "function alertWinning(){alert(\"It worked\");} "
                            + "alertWinning();"
                            + "</script>");
                }
                else
                {
                    pw.print("<script>"
                            + "function alertFunction(){alert(\"Error Password or Username\");} "
                            + "alertFunction();"
                            + "</script>");
                }
                
            
            }
            catch(SQLException e)
            {
                
            }
                 
            
            
        }*/
        
}