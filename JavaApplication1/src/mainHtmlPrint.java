public class mainHtmlPrint 
{
    String htmlOneTestServ = "<html>\n"+"<head>\n"+"<title>\n"+"Das Schwarze Hahnchen\n"+"</title>\n"+"<style>\n"+
                "\n"+"td{\n"+"font-style: italic;\n"+"position: relative;\n"+"text-align: center;\n"+"}\n"+"\n" 
                +"body {\n"+"background-color: #93B874;\n"+"}\n"+"\n"+"pre {\n"+"background-color: rgb(200,0,0);\n"+
                "text-align: center;\n"+"\n"+"}\n"+"\n"+"li{\n"+"\n"+"height:20px;\n"+"width:320px;\n"+"display:block;\n"+
                "float:left;\n"+"text-align: center;\n"+"background-color: rgb(108,135,86);\n"+"color: red;\n"+"}\n"+""; 
    String htmlTwoTestServ = "</style>\n"+"</head>\n"+"\n"+"<!-- Creates the first table (Includes the restaurant name, and logo in the border -->\n"+
                "\n"+"<table width='80%' align=\"center\" style=\"border:5px double black;\">\n"+"<tr>\n"+"<td>\n"+
                "<img style=\"width:150px;height:128px;\" src=\"logo.png\" alt=\"logo\"></td>\n"+"<td>\n"+
                "<h1 style =\"font-size: 450%\">Das Schwarze Hahnchen</h1>\n"+"</td>\n"+"</tr>\n"+"\n"+"</table>\n"+"\n"+"<hr>\n"+
                "\n"+"\n"+"<div id=\"footer\">\n"+"<nav>\n"+"<ul>\n"+
                "<li><form action=\"home.html\"><input type =\"submit\" value=\"Home\"/></form></li><li><form action=\"menu.html\"><input type =\"submit\" value=\"Menu\"/></form></li><li><form action=\"order.html\"><input type=\"submit\" value=\"Order\"/></form></li><li><form action=\"contact.html\"><input type =\"submit\" value=\"Contact\"/></form></li><li><form action=\"login.html\"><input type=\"submit\" value=\"Login\"/></form></li>\n"+
                "</ul>\n"+"</nav>\n"+"<br>\n"+"</div>\n"+"<br>\n"+"<hr>";
    String htmlOneMenuLoad ="<html>\n"+"<head>\n"+"<title>\n"+"Das Schwarze Hahnchen\n"+"</title>\n"+"<style>\n"+
                "\n"+"td{\n"+"font-style: italic;\n"+"position: relative;\n"+"text-align: center;\n"+"}\n"+
                "\n"+"body {\n"+"background-color: #93B874;\n"+"}\n"+"\n"+"pre {\n"+"background-color: rgb(200,0,0);\n"+
                "text-align: center;\n"+"\n"+"}\n"+"\n"+"li{\n"+"\n"+"height:20px;\n"+"width:320px;\n"+
                "display:block;\n"+"float:left;\n"+"text-align: center;\n"+"background-color: rgb(108,135,86);\n"+
                "color: red;\n"+"}\n"+"";
    String htmlTwoMenuLoad = "</style>\n"+"</head>\n"+"\n"+"<!-- Creates the first table (Includes the restaurant name, and logo in the border -->\n"+
                "\n"+"<table width='80%' align=\"center\" style=\"border:5px double black;\">\n"+"<tr>\n"+"<td>\n"+
                "<img style=\"width:150px;height:128px;\" src=\"logo.png\" alt=\"logo\"></td>\n"+"<td>\n"+"<h1 style =\"font-size: 450%\">Das Schwarze Hahnchen</h1>\n"+"</td>\n" +
                "</tr>\n"+"\n"+"</table>\n"+"\n"+"<hr>\n"+"\n"+"\n"+"<div id=\"footer\">\n"+"<nav>\n"+"<ul>\n"+
                "		<li><form action=\"home.html\"><input type =\"submit\" value=\"Home\"/></form></li><li><form action=\"menu.html\"><input type =\"submit\" value=\"Menu\"/></form></li><li><form action=\"order.html\"><input type=\"submit\" value=\"Order\"/></form></li><li><form action=\"contact.html\"><input type =\"submit\" value=\"Contact\"/></form></li><li><form action=\"login.html\"><input type=\"submit\" value=\"Login\"/></form></li>\n" +
                "</ul>\n"+"</nav>\n"+"<br>\n"+"</div>\n"+"<br>\n"+"<hr>";
    String totalButton = "<button type=\"button\" onClick=\"Total()\" id=\"totalID\">" + "Total</button>";
    String completeButton = "<form action=\"complete.html\"><input type=\"submit\" id=\"complete\"  disabled=\"disabled\" value=\"Check Out\"/></form>";
    String removeButton = "<form action=\"order.html\"><input type=\"submit\"  value=\"Reset\"/></form>";

    public String htmlReturn()
    {
        return htmlOneTestServ;
    }
    
    public String secondHtmlReturn()
    {
        return htmlTwoTestServ;
    }
    
    public String htmlMenuLoadOne()
    {
        return htmlOneMenuLoad;
    }
    
    public String htmlMenuLoadTwo()
    {
        return htmlTwoMenuLoad;
    }
    
    public String totalButton()
    {
        return totalButton;
    }
    
    public String removeButton()
    {
        return removeButton;
    }
    
    public String completeButton()
    {
        return completeButton;
    }
}
