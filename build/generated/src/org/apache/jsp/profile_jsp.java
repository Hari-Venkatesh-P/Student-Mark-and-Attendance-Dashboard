package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


           private Connection cn = null; 
         
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Personal Details</title>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            #big{\n");
      out.write("                    font-size:25px;\n");
      out.write("                    position: absolute;\n");
      out.write("                    left:150px;\n");
      out.write("                    top:200px;\n");
      out.write("                    font-family: serif;\n");
      out.write("                 }\n");
      out.write("                  #small{\n");
      out.write("                    font-size:15px;\n");
      out.write("                    position: absolute;\n");
      out.write("                    left:850px;\n");
      out.write("                    top:400px;\n");
      out.write("                 }\n");
      out.write("                 #image{\n");
      out.write("                    position: absolute;\n");
      out.write("                    left:850px;\n");
      out.write("                    top:200px;\n");
      out.write("                 }\n");
      out.write("                 #div1 {background-color: pink;width:33cm;height:40px;font-size:30px;font-family:arial;text-align:center;font-style:italic;}\n");
      out.write("                body{background-color:lightgrey;border-color: black;border-style: solid;}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>       \n");
      out.write("        ");
      out.write("\n");
      out.write("         ");

            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb","root","");
          
      out.write("\n");
      out.write("          ");
String adno = "13005";
      out.write("\n");
      out.write("//(String)request.getAttribute(\"adno\");\n");
      out.write("          ");

            Statement stmt = cn.createStatement();
            String query ="select * from studetails where adno='"+adno+"'";
            ResultSet rs = stmt.executeQuery(query);
           
      out.write("\n");
      out.write("           ");

                    while(rs.next())
                    {   
            
      out.write("\n");
      out.write("            <div id=\"div1\">\n");
      out.write("                <p id=\"p1\">Welcome to Your Profile <b>");
      out.print(rs.getString("stuname"));
      out.write("</b>..!!</p>\n");
      out.write("            </div><br><br><br>\n");
      out.write("             ");

                  }
             
      out.write("\n");
      out.write("            ");

              String query1 ="select * from studetails where adno='"+adno+"'";
              rs = stmt.executeQuery(query1);
            
      out.write("\n");
      out.write("           \n");
      out.write("                 ");

                    while(rs.next())
                    {   
                  
      out.write(" \n");
      out.write("                  <div id=\"big\" >  \n");
      out.write("                  <table cellpadding=\"10\" cellspacing=\"3\" bgcolor=\"black\" >\n");
      out.write("                      <center><h3>Basic Profile</h3></center><br>\n");
      out.write("                   <tr bgcolor=\"lightblue\">\n");
      out.write("                       <td id=\"1\">Name</td>\n");
      out.write("                       <td id=\"1\">");
      out.print(rs.getString("stuname"));
      out.write("</td>\n");
      out.write("                   </tr>\n");
      out.write("                   <tr bgcolor=\"lightyellow\">\n");
      out.write("                       <td id=\"2\">Gender</td>\n");
      out.write("                       <td id=\"2\">");
      out.print(rs.getString("gender"));
      out.write("</td>\n");
      out.write("                   </tr>\n");
      out.write("                   <tr bgcolor=\"lightblue\">\n");
      out.write("                       <td id=\"1\">Date of Birth</td>\n");
      out.write("                       <td id=\"1\">");
      out.print(rs.getString("dob"));
      out.write("</td>\n");
      out.write("                   </tr>\n");
      out.write("                   <tr bgcolor=\"lightyellow\">\n");
      out.write("                       <td id=\"2\">Admission Number</td>\n");
      out.write("                       <td id=\"2\">");
      out.print(rs.getString("adno"));
      out.write("</td>\n");
      out.write("                   </tr>\n");
      out.write("                   <tr bgcolor=\"lightblue\">\n");
      out.write("                       <td id=\"1\">Registration Number</td>\n");
      out.write("                       <td id=\"1\">");
      out.print(rs.getString("regno"));
      out.write("</td>\n");
      out.write("                   </tr>\n");
      out.write("                   <tr bgcolor=\"lightyellow\">\n");
      out.write("                       <td id=\"2\">Department</td>\n");
      out.write("                       <td id=\"2\">");
      out.print(rs.getString("dept"));
      out.write("</td>\n");
      out.write("                   </tr>\n");
      out.write("                   <tr bgcolor=\"lightblue\">\n");
      out.write("                       <td id=\"1\">Batch</td>\n");
      out.write("                       <td id=\"1\">");
      out.print(rs.getString("batch"));
      out.write("</td>\n");
      out.write("                   </tr>\n");
      out.write("                    ");

                       }
                    
      out.write("\n");
      out.write("           </table>\n");
      out.write("          </div>\n");
      out.write("                       ");

              String query2 ="select * from stubasicdetails where adno='"+adno+"'";
              rs = stmt.executeQuery(query2);
            
      out.write("\n");
      out.write("           \n");
      out.write("                 ");

                    while(rs.next())
                    {   
                  
      out.write(" \n");
      out.write("                  <div id=\"small\" >  \n");
      out.write("                  <table cellpadding=\"10\" cellspacing=\"3\" bgcolor=\"black\" >\n");
      out.write("                      <br><br><br>\n");
      out.write("                   <tr bgcolor=\"lightyellow\">\n");
      out.write("                       <td id=\"1\">Admission No:</td>\n");
      out.write("                       <td id=\"1\">");
      out.print(rs.getString("adno"));
      out.write("</td>\n");
      out.write("                   </tr>\n");
      out.write("                   <tr bgcolor=\"lightsalmon\">\n");
      out.write("                       <td id=\"2\">Course :</td>\n");
      out.write("                       <td id=\"2\">");
      out.print(rs.getString("course"));
      out.write("</td>\n");
      out.write("                   </tr>\n");
      out.write("                   <tr bgcolor=\"lightyellow\">\n");
      out.write("                       <td id=\"1\">Year of study :</td>\n");
      out.write("                       <td id=\"1\">");
      out.print(rs.getString("year"));
      out.write("</td>\n");
      out.write("                   </tr>\n");
      out.write("                   <tr bgcolor=\"lightsalmon\">\n");
      out.write("                       <td id=\"1\">Section :</td>\n");
      out.write("                       <td id=\"1\">");
      out.print(rs.getString("section"));
      out.write("</td>\n");
      out.write("                   </tr>\n");
      out.write("                   <tr bgcolor=\"lightyellow\">\n");
      out.write("                       <td id=\"2\">Routine :</td>\n");
      out.write("                       <td id=\"2\">");
      out.print(rs.getString("routine"));
      out.write("</td>\n");
      out.write("                   </tr>\n");
      out.write("                    ");

                       }
                    
      out.write("\n");
      out.write("           </table>\n");
      out.write("          </div>\n");
      out.write("                    ");

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
                    
      out.write("\n");
      out.write("                    ");

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
                         
      out.write("\n");
      out.write("                         <div id=\"image\">\n");
      out.write("                                <img src=\"retreiveimages\\\\image.jpg\" height=\"200px\" width=\"200px\">\n");
      out.write("                          </div>\n");
      out.write("                         ");

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
                    
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
