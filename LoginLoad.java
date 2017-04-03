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
                //String query = "select USERNAME from users";    
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
                        +"<form name=\"signup\">\n" 
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
                        
//                        + "<script language=\"php\">\n"
//                        + "function signUpUser()\n"
//                        + "{\n"
//                        + "$conn = oci_connect(\"jwr17\", \"JX3vAZCM\", \"stuoracle.ptcollege.edu:1521/ORCL\");\n"
//                        + "if(!$conn)\n"
//                        + "{\n"
//                        + "$e = oci_error();\n"
//                        + "trigger_error(htmlentities($e['message'], ENT_QUOTES, E_USER_ERROR);\n"
//                        + "}\n"
//                        + "$stid = oci_parse($conn, 'SELECT * FROM USERS');\n"
//                        + "if(!$stid)\n"
//                        + "{\n"
//                        + "$e = oci_error($conn);\n"
//                        + "trigger_error(htmlentities($e['message'], ENT_QUOTES), E_USER_ERROR);\n"
//                        + "}\n"
//                        + "print \"table border='1'>\n\";\n"
//                        + "while($row = orci_fetch_array($stid, OCI_ASSOC+OCI_RETURN_NULLS))\n"
//                        + "{\n"
//                        + "print \"<tr>\n\";\n"
//                        + "foreach($row as $item)\n"
//                        + "{\n"
//                        + "print \"<td>\" . ($item != null ? htmlentities($item, ENT_QUOTES) : \"nbsp;\").\"</td>\n\";\n"
//                        + "}\n"
//                        + "print \"<tr>\n\";\n"
//                        + "}\n"
//                        + "print \"<table>\n\";\n"
//                        + "oci_free_statement($stid);\n"
//                        + "oci_close($conn);\n"
//                        + "}\n"
//                        
//                        + "</script>"
                        
                        //function called on sign up click
                        +"<script>\n"
                        + "function signUpUser(form)\n"
                        + "{\n"
                        + "try\n"
                        + "{\n" 
                        + "var connection = new ActiveXObject(\"adodb.connection\");\n"
                        + "var conString = \"jdbc:oracle:thin:jwr17/JX3vAZCM@//stuoracle.ptcollege.edu:1521/ORCL\";\n"
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
                        + "alert(\"Error Fucko\");\n" 
                        + "}\n"
                        + "}\n"
                        +"</script>"
                        );
                
                pw.print("<h1 align=\"center\">Log-In</h1>\n"
                                +"<div align=\"center\""
                        + "<form name=\"login\" align=\"center\">\n"
                        +"Username<input type=\"text\" name=\"userid\"/><br>\n"
			+"Password<input type=\"password\" name=\"pswrd\"/><br>\n"
                        +"<button type=\"button\" onClick=\"check(this.form)\" id=\"login\">" + "Login</button>"
                        +"<script>document.getElementById(\"login\").addEventListener(\"click\",check);</script>"
			+"<input type=\"reset\" value=\"Clear\"/>\n"
			+"</form></div>");
                while(rs.next())
                {
                String userName = rs.getString("USERNAME");
                String passWord = rs.getString("USER_PASSWORD");
                pw.print(
                        "<script language=\"javascript\">"
                        +"function check(form)\n"
                        +"{\n"
                        +"if(form.userid.value ==\"john\" && form.pswrd.value ===\"jim\")\n"
			+"{\n"
			+"window.open('home.html');\n"
			+"}\n"
			+"else{alert(\"Error Password or Username\");\n}"
                        +"}\n"
                        +"</script>");
                }       
                        pw.print("<hr>\n"
                        +"<p style=\"font-size: 12px; text-align: center\">Copyright Das Schwarze Hahnchen (R) 2017</p>"
                );
                        
                String newUserName = rs.getString("<script>inputtedUserName</script>");
                pw.print("<p>"+newUserName+"</p>");
                pw.print("</body>\n");

                con.close();
            }
            catch(Exception e)
            {
                //pw.println("ERROR "+ e.getMessage());
            }	
        }
           
}