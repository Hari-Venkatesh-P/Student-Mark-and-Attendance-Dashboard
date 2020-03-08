<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal Details</title>
        <style type="text/css">
            #big{
                    font-size:25px;
                    position: absolute;
                    left:150px;
                    top:150px;
                 }
                 #div1 {background-color: pink;width:33cm;height:40px;}
                 #bor {border-color: black;border-style: solid;}
                #p1 {font-size:30px;font-family:arial;text-align:center;font-style:italic;}
                body{background-color:lemonchiffon;}
        </style>
    </head>
    
    <body>
        <div id="bor">
        <%!
           private Connection cn = null; 
         %>
         <%
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb","root","");
          %>
          <%String adno = (String)request.getAttribute("adno");%>
            <div id="div1">
                <p id="p1">Do Check Your Attendance Regularly <b><%=adno%></b>..!!</p>
            </div><br><br><br>
            <div id="big" >
            <table cellpadding="10" cellspacing="3" bgcolor="black" >
                  <thead>
                  <br><br>
            <tr bgcolor="lightgrey">
                       <td id="1">Date</td>
                       <td id="1">Period 1 </td>
                       <td id="1">Period 2</td>
                       <td id="1">Period 3</td>
                       <td id="1">Period 4</td>
                       <td id="1">Period 5</td>
                       <td id="1">Period 6</td>
                       <td id="1">Period 7</td>
                       <td id="1">Period 8</td>    
                   </tr>
            <%
              Statement stmt = cn.createStatement();
              String query1 ="select * from stuattendance where adno='"+adno+"'";
              ResultSet rs = stmt.executeQuery(query1);
              String p1,p2,p3,p4,p5,p6,p7,p8;
              String p1c,p2c,p3c,p4c,p5c,p6c,p7c,p8c;
              %>
              <%
                    while(rs.next())
                    {            
              %>
              <%
                         p1 = rs.getString("p1");
                         if(p1.equals("P")){p1c="lightgreen";}
                         else if(p1.equals("Ab")){p1c="red";}
                         else if(p1.equals("L")){p1c="pink";}
                         else if(p1.equals("OD")){p1c="orange";}
                         else if(p1.equals("L")){p1c="lightgreen";}
                         else{p1c="lightblue";}
                         %>
                         <%
                         p2 = rs.getString("p2");
                         if(p2.equals("P")){p2c="lightgreen";}
                         else if(p2.equals("Ab")){p2c="red";}
                         else if(p2.equals("L")){p2c="pink";}
                         else if(p2.equals("OD")){p2c="orange";}
                         else if(p2.equals("L")){p2c="lightgreen";}
                         else{p2c="lightblue";}   
              %>        
                          <%
                         p3 = rs.getString("p3");
                         if(p3.equals("P")){p3c="lightgreen";}
                         else if(p3.equals("Ab")){p3c="red";}
                         else if(p3.equals("L")){p3c="pink";}
                         else if(p3.equals("OD")){p3c="orange";}
                         else if(p3.equals("L")){p3c="lightgreen";}
                         else{p3c="lightblue";}   
              %>
                           <%
                         p4 = rs.getString("p4");
                         if(p4.equals("P")){p4c="lightgreen";}
                         else if(p4.equals("Ab")){p4c="red";}
                         else if(p4.equals("L")){p4c="pink";}
                         else if(p4.equals("OD")){p4c="orange";}
                         else if(p4.equals("L")){p4c="lightgreen";}
                         else{p4c="lightblue";}   
              %>
              <%
                         p5 = rs.getString("p5");
                         if(p5.equals("P")){p5c="lightgreen";}
                         else if(p5.equals("Ab")){p5c="red";}
                         else if(p5.equals("L")){p5c="pink";}
                         else if(p5.equals("OD")){p5c="orange";}
                         else if(p5.equals("L")){p5c="lightgreen";}
                         else{p5c="lightblue";}   
              %>
              <%
                         p6 = rs.getString("p6");
                         if(p6.equals("P")){p6c="lightgreen";}
                         else if(p6.equals("Ab")){p6c="red";}
                         else if(p6.equals("L")){p6c="pink";}
                         else if(p6.equals("OD")){p6c="orange";}
                         else if(p6.equals("L")){p6c="lightgreen";}
                         else{p6c="lightblue";}   
              %>
              <%
                         p7 = rs.getString("p7");
                         if(p7.equals("P")){p7c="lightgreen";}
                         else if(p7.equals("Ab")){p7c="red";}
                         else if(p7.equals("L")){p7c="pink";}
                         else if(p7.equals("OD")){p7c="orange";}
                         else if(p7.equals("L")){p7c="lightgreen";}
                         else{p7c="lightblue";}   
              %>
              <%
                         p8 = rs.getString("p8");
                         if(p8.equals("P")){p8c="lightgreen";}
                         else if(p8.equals("Ab")){p8c="red";}
                         else if(p8.equals("L")){p8c="pink";}
                         else if(p8.equals("OD")){p8c="orange";}
                         else if(p8.equals("L")){p8c="lightgreen";}
                         else{p8c="lightblue";}   
              %>
                   <tr bgcolor="lightgrey">
                       <td bgcolor="grey"><%=rs.getString("date")%></td>
                       <td bgcolor="<%= p1c%>"><%=rs.getString("p1")%></td>
                       <td bgcolor="<%= p2c%>"><%=rs.getString("p2")%></td>
                       <td bgcolor="<%= p3c%>"><%=rs.getString("p3")%></td>
                       <td bgcolor="<%= p4c%>"><%=rs.getString("p4")%></td>
                       <td bgcolor="<%= p5c%>"><%=rs.getString("p5")%></td>
                       <td bgcolor="<%= p6c%>"><%=rs.getString("p6")%></td>
                       <td bgcolor="<%= p7c%>"><%=rs.getString("p7")%></td>
                       <td bgcolor="<%= p8c%>"><%=rs.getString("p8")%></td>  
                   </tr>
               </thead>
               <tbody>
                    <%
                       }
                    %>
               </tbody>
           </table>
               </div>
        </div>
    </body>
</html>