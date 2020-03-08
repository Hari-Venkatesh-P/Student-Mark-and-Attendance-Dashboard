<%-- 
    Document   : image
    Created on : 24 Feb, 2019, 2:21:21 PM
    Author     : Laptop
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <%
             String adno="13005";
             Blob b=null;
                    try{  
                         Class.forName("com.mysql.jdbc.Driver");
                         Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb","root",""); 
                         Statement st=cn.createStatement();
                         String query4 = "select * from imgtable where adno="+adno+"";
                         ResultSet rs = st.executeQuery(query4);
                         while(rs.next())
                         {
                            b  =  rs.getBlob("photo");
                         /*if(rs.next()){ 
                                Blob b=rs.getBlob(2);  
                                byte barr[]=b.getBytes(1,(int)b.length()); 
                                FileOutputStream fout=new FileOutputStream("D:\\Academics\\SEM 6\\15CSC05-J2EE\\Applications\\MyServletApplication\\web\\retreiveimages\\"+adno+".jpg");  
                                fout.write(barr);                
                                fout.close();  
                          }
                         System.out.println("ok");  
                         cn.close();  */
                         %>
                         <div>
                              <h1>Hello World!</h1>
                                <img src="<%= b %>" height="200" width="200" alt="can" />
                          </div>
                         <%
                    }
                        }catch (Exception e) {e.printStackTrace();  }  
                    %>
    </body>
</html>
