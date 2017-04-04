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
                doPost(req,res);
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
                        +"<div align='center'><h1>Sign Up</h1></div>\n" 
                        +"</td>\n" 
                        +"<tr>\n" 
                        +"<td>\n"
                        +"<form name=\"signup\" action=\"login.html\" method=\"post\">\n" 
                        +"<div align=\"center\"><input name=\"newUserName\" type=\"text\" placeholder=\"Username\"/></div><br/>\n"
                        +"<div align=\"center\"><input name=\"newPassword\" type=\"password\" placeholder=\"Password\" /></div><br />\n"
                        +"<div align=\"center\"><input name=\"firstName\" type=\"text\" placeholder=\"First Name\" /></div><br />\n"
                        +"<div align=\"center\"><input name=\"lastName\" type=\"text\" placeholder=\"Last Name\" /></div><br />\n" 
                        +"<div align=\"center\"><input name=\"address\" type=\"text\" placeholder=\"Address\" /></div><br />\n" 
                        +"<div align=\"center\"><input name=\"city\" type=\"text\" placeholder=\"City\" /></div><br />\n" 
                        +"<div align=\"center\"><input name=\"state\" type=\"text\" placeholder=\"State\" /></div><br />\n" 
                        +"<div align=\"center\"><input name=\"zipCode\" type=\"text\" placeholder=\"Zip Code\" /></div><br />\n"
                        +"<input type=\"submit\" value=\"Sign Up\"/>"
                        //+"<button type=\"button\" id=\"signUpButton\" value=\"Sign Up\" onClick=\"signUpUser(this.form)\">Sign Up</button>"
                        //+"<script>document.getElementById(\"signUpButton\").addEventListener(\"click\",signUpUser);</script>"
                        +"<br/>\n" 
                        +"</form>\n" 
                        +"</td>\n" 
                        +"</tr>\n" 
                        +"</table>\n");

                        /*//function called on sign up click
                        +"<script>\n"
                        + "function signUpUser(form)\n"
                        + "{\n"
                        + "try\n"
                        + "{\n" 
                        + "var connection = new ActiveXObject(\"adodb.connection\");\n"
                        //+ "var conString = \"jdbc:oracle:thin:jwr17/JX3vAZCM@//stuoracle.ptcollege.edu:1521/ORCL\";\n"
                        //+ "connection.Open(conString);\n"  
                        //+ "var stmt=connnection.createStatement();\n"
                        //+ " var inputtedUserName = document.getElementById(\"newUserName\").value;\n"
                        //+ "stmt.execute(\"INSERT INTO USERS (USERNAME, USER_PASSWORD, FIRST_NAME, LAST_NAME, ADDRESS, CITY, STATE_ABBR, ZIPCODE, USERTYPE) "
                        //+ "VALUES (\" + form.newUserName.value + \",\" + form.newPassword.value + \",\" + form.firstName.value + \",\" + form.lastName.value + \",\" + "
                        //+ "form.address.value + \",\" + form.city.value + \",\" + form.state.value + \",\" + form.zipCode.value + \",CUSTOMER)\");\n"
                        + " document.write(\"<p>\"+form.newUserName.value+\"</p>\")"  
                        + "}\n"
                        + "catch(err)\n" 
                        + "{\n"
                        + "alert(\"Well that wasn't right\");\n" 
                        + "}\n"
                        + "}\n"
                        +"</script>"
                        );*/
                
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
                        +"if(form.userid.value ==\"john\" && form.pswrd.value ===\"jim\")\n"
			+"{\n"
			+"window.open('home.html');\n"
			+"}\n"
			+"else{alert(\"Error Password or Username\");\n}"
                        +"}\n"
                        +"</script>");
                
                pw.print("<hr>\n"
                        +"<p style=\"font-size: 12px; text-align: center\">Copyright Das Schwarze Hahnchen (R) 2017</p>"
                );
                        
                //String newUserName = rs.getString("<script>inputtedUserName</script>");
                //pw.print("<p>"+newUserName+"</p>");
                pw.print("</body>\n");

                con.close();
            }
            catch(Exception e)
            {
                //pw.println("ERROR "+ e.getMessage());
            }	
        }
        
        public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
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
                 
            
            
        }
        
}