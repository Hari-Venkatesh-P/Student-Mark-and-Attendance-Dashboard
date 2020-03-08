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
                    top:200px;
                    font-family: serif;
                 }
                  #small{
                    font-size:15px;
                    position: absolute;
                    left:850px;
                    top:400px;
                 }
                 #image{
                    position: absolute;
                    left:850px;
                    top:200px;
                 }
                 #div1 {background-color: pink;width:33cm;height:40px;font-size:30px;font-family:arial;text-align:center;font-style:italic;}
                body{background-color:lightgrey;border-color: black;border-style: solid;}
        </style>
    </head>
    <body>       
        <%!
           private Connection cn = null; 
         %>
         <%
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb","root","");
          %>
          <%String adno = "13005";%>
//(String)request.getAttribute("adno");
          <%
            Statement stmt = cn.createStatement();
            String query ="select * from studetails where adno='"+adno+"'";
            ResultSet rs = stmt.executeQuery(query);
           %>
           <%
                    while(rs.next())
                    {   
            %>
            <div id="div1">
                <p id="p1">Welcome to Your Profile <b><%=rs.getString("stuname")%></b>..!!</p>
            </div><br><br><br>
             <%
                  }
             %>
            <%
              String query1 ="select * from studetails where adno='"+adno+"'";
              rs = stmt.executeQuery(query1);
            %>
           
                 <%
                    while(rs.next())
                    {   
                  %> 
                  <div id="big" >  
                  <table cellpadding="10" cellspacing="3" bgcolor="black" >
                      <center><h3>Basic Profile</h3></center><br>
                   <tr bgcolor="lightblue">
                       <td id="1">Name</td>
                       <td id="1"><%=rs.getString("stuname")%></td>
                   </tr>
                   <tr bgcolor="lightyellow">
                       <td id="2">Gender</td>
                       <td id="2"><%=rs.getString("gender")%></td>
                   </tr>
                   <tr bgcolor="lightblue">
                       <td id="1">Date of Birth</td>
                       <td id="1"><%=rs.getString("dob")%></td>
                   </tr>
                   <tr bgcolor="lightyellow">
                       <td id="2">Admission Number</td>
                       <td id="2"><%=rs.getString("adno")%></td>
                   </tr>
                   <tr bgcolor="lightblue">
                       <td id="1">Registration Number</td>
                       <td id="1"><%=rs.getString("regno")%></td>
                   </tr>
                   <tr bgcolor="lightyellow">
                       <td id="2">Department</td>
                       <td id="2"><%=rs.getString("dept")%></td>
                   </tr>
                   <tr bgcolor="lightblue">
                       <td id="1">Batch</td>
                       <td id="1"><%=rs.getString("batch")%></td>
                   </tr>
                    <%
                       }
                    %>
           </table>
          </div>
                       <%
              String query2 ="select * from stubasicdetails where adno='"+adno+"'";
              rs = stmt.executeQuery(query2);
            %>
           
                 <%
                    while(rs.next())
                    {   
                  %> 
                  <div id="small" >  
                  <table cellpadding="10" cellspacing="3" bgcolor="black" >
                      <br><br><br>
                   <tr bgcolor="lightyellow">
                       <td id="1">Admission No:</td>
                       <td id="1"><%=rs.getString("adno")%></td>
                   </tr>
                   <tr bgcolor="lightsalmon">
                       <td id="2">Course :</td>
                       <td id="2"><%=rs.getString("course")%></td>
                   </tr>
                   <tr bgcolor="lightyellow">
                       <td id="1">Year of study :</td>
                       <td id="1"><%=rs.getString("year")%></td>
                   </tr>
                   <tr bgcolor="lightsalmon">
                       <td id="1">Section :</td>
                       <td id="1"><%=rs.getString("section")%></td>
                   </tr>
                   <tr bgcolor="lightyellow">
                       <td id="2">Routine :</td>
                       <td id="2"><%=rs.getString("routine")%></td>
                   </tr>
                    <%
                       }
                    %>
           </table>
          </div>
                    <%
                    File file = new File("D:/Academics/SEM 6/15CSC05-J2EE/Applications/MyServletApplication/web/retreiveimages");
                    String[] myFiles;
                    if(file.isDirectory()){
                           myFiles = file.list();
                            for (int i=0; i<myFiles.length; i++) {
                            File myFile = new File(file, myFiles[i]);
                            myFile.delete();
                            }
                            System.out.println("");
                    }
                    %>
                    <%
                    try{  
                         Class.forName("com.mysql.jdbc.Driver");
                         Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb","root",""); 
                         Statement st=cn.createStatement();
                         String query4 = "select * from imgtable where adno="+adno+"";
                         rs = st.executeQuery(query4);
                         if(rs.next()){ 
                                Blob b=rs.getBlob(2);  
                                byte barr[]=b.getBytes(1,(int)b.length()); 
                                FileOutputStream fout=new FileOutputStream("D:\\Academics\\SEM 6\\15CSC05-J2EE\\Applications\\MyServletApplication\\web\\retreiveimages\\image.jpg");  
                                fout.write(barr);                
                                fout.close();  
                          }
                         System.out.println("ok");  
                         cn.close();  
                         %>
                         <div id="image">
                                <img src="retreiveimages\\image.jpg" height="200px" width="200px">
                          </div>
                         <%
                        }catch (Exception e) {e.printStackTrace();  }
                    finally {
                               try {
                                rs.close();
                                stmt.close();
                                cn.close();
                                }
                                catch (SQLException e) {
                                e.printStackTrace();
                                }
                            }   
                    %>
    </body>
</html>