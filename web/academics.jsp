<%-- 
    Document   : academics.jsp
    Created on : 19 Feb, 2019, 7:27:24 PM
    Author     : Laptop
--%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Marks..!!</title>
        <link type="text/css" rel="stylesheet" href="mycss.css">
        <style>
               
        </style>
    </head>
    <body>
        <%!private Connection cn = null;
           String c1=null,c2=null,c3=null,c4=null,c5=null,c6=null;
        %>
        <%
                Class.forName("com.mysql.jdbc.Driver");
                cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb","root","");
                String adno = (String)request.getAttribute("adno");
        %>
        <%
                Statement stmt = cn.createStatement();
                String query ="select * from studetails where adno='"+adno+"'";
                ResultSet rs = stmt.executeQuery(query);
                String sem1="sem1";
         %>
         <%
                while(rs.next())
                {   
         %>
           <div id="div1">
                <center>Your academic performance <b><%=rs.getString("stuname")%></b>..!!</center>
           </div>
         <%
                  }
         %>
            <%
              String query1 ="select * from stumarks where adno='"+adno+"' and semester='"+sem1+"'";
              rs = stmt.executeQuery(query1);
         %>
         <%
               while(rs.next())
               {   
         %> 
         <% String internal = rs.getString("exam");%>
         <% 
              if(internal.equals("Internal 1"))
              {
                    c1 = rs.getString("c1");
                    c2 = rs.getString("c2");
                    c3 = rs.getString("c3");
                    c4 = rs.getString("c4");
                    c5 = rs.getString("c5");
                    c6 = rs.getString("c6");
         %>
         <div id="int1" >  
         <table cellpadding="10" cellspacing="3" bgcolor="black" >                        
             <center><p> Internal 1</p><center>
         <tr bgcolor="lightblue">
            <td id="1">Course 1</td>
            <td id="1"><%=c1%></td>
         </tr>
         <tr bgcolor="lightyellow">
            <td id="2">Course 2</td>
            <td id="2"><%=c2%></td>
         </tr>
         <tr bgcolor="lightblue">
             <td id="1">Course 3</td>
             <td id="1"><%=c3%></td>
         </tr>
         <tr bgcolor="lightyellow">
             <td id="2">Course 4</td>
             <td id="2"><%=c4%></td>
         </tr>
         <tr bgcolor="lightblue">
            <td id="1">Course 5:</td>
            <td id="1"><%=c5%></td>
         </tr>
         <tr bgcolor="lightyellow">
             <td id="2">Course 6:</td>
             <td id="2"><%=c6%></td>
         </tr>
        </table>
        </div>
                   <%
                       }
                    %> 
        <% 
              if(internal.equals("Internal 2"))
              {
                    c1 = rs.getString("c1");
                    c2 = rs.getString("c2");
                    c3 = rs.getString("c3");
                    c4 = rs.getString("c4");
                    c5 = rs.getString("c5");
                    c6 = rs.getString("c6");
         %>
         <div id="int2" >  
         <table cellpadding="10" cellspacing="3" bgcolor="black" >                        
             <center><p> Internal 2</p><center>
         <tr bgcolor="lightblue">
            <td id="1">Course 1</td>
            <td id="1"><%=c1%></td>
         </tr>
         <tr bgcolor="lightyellow">
            <td id="2">Course 2</td>
            <td id="2"><%=c2%></td>
         </tr>
         <tr bgcolor="lightblue">
             <td id="1">Course 3</td>
             <td id="1"><%=c3%></td>
         </tr>
         <tr bgcolor="lightyellow">
             <td id="2">Course 4</td>
             <td id="2"><%=c4%></td>
         </tr>
         <tr bgcolor="lightblue">
            <td id="1">Course 5:</td>
            <td id="1"><%=c5%></td>
         </tr>
         <tr bgcolor="lightyellow">
             <td id="2">Course 6:</td>
             <td id="2"><%=c6%></td>
         </tr>
        </table>
        </div>
                   <%
                       }
                    %>
        <% 
              if(internal.equals("Internal 3"))
              {
                    c1 = rs.getString("c1");
                    c2 = rs.getString("c2");
                    c3 = rs.getString("c3");
                    c4 = rs.getString("c4");
                    c5 = rs.getString("c5");
                    c6 = rs.getString("c6");
         %>
         <div id="int3" >  
         <table cellpadding="10" cellspacing="3" bgcolor="black" >                        
             <center><p> Internal 3</p><center>
         <tr bgcolor="lightblue">
            <td id="1">Course 1</td>
            <td id="1"><%=c1%></td>
         </tr>
         <tr bgcolor="lightyellow">
            <td id="2">Course 2</td>
            <td id="2"><%=c2%></td>
         </tr>
         <tr bgcolor="lightblue">
             <td id="1">Course 3</td>
             <td id="1"><%=c3%></td>
         </tr>
         <tr bgcolor="lightyellow">
             <td id="2">Course 4</td>
             <td id="2"><%=c4%></td>
         </tr>
         <tr bgcolor="lightblue">
            <td id="1">Course 5:</td>
            <td id="1"><%=c5%></td>
         </tr>
         <tr bgcolor="lightyellow">
             <td id="2">Course 6:</td>
             <td id="2"><%=c6%></td>
         </tr>
        </table>
        </div>
                   <%
                       }
                    %>
                    <%
                        }
                    %>
    </body>
</html>
