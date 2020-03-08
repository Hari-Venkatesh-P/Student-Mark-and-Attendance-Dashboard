import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
/**
 *
 * @author Laptop
 */
public class addstudentservlet extends HttpServlet {

     private Connection cn = null;
    public void init(ServletConfig sc) throws ServletException
    {
        
        try
        {
            super.init(sc);
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb","root","");
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        } 
    }
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            try{
            Statement stmt = cn.createStatement();
           String name = request.getParameter("name");
           String gender = request.getParameter("gender");
           String dob = request.getParameter("dob");
           String adno = request.getParameter("adno");
           String regno = request.getParameter("regno");
           String dept = request.getParameter("dept");
           String batch = request.getParameter("batch");
           String uid = request.getParameter("adno");
           String password = request.getParameter("password");
           String year = request.getParameter("year");
           String section = request.getParameter("section");
           String routine = request.getParameter("routine");
           String query ="insert into studetails values ('"+name+"','"+gender+"','"+dob+"','"+adno+"','"+regno+"','"+dept+"','"+batch+"')";
           stmt.executeUpdate(query);
           String query1="insert into stupass values('"+uid+"','"+password+"')";
           stmt.executeUpdate(query1);
           String query2 ="insert into stubasicdetails values ('"+adno+"','"+dept+"','"+year+"','"+section+"','"+routine+"')";
           stmt.executeUpdate(query2);
           PreparedStatement ps=cn.prepareStatement("insert into imgtable values(?,?)");  
           ps.setString(1,adno);  
           FileInputStream fin=new FileInputStream("D:\\Academics\\SEM 6\\15CSC05-J2EE\\Applications\\MyServletApplication\\web\\insertimages\\"+adno+".jpg");  
           ps.setBinaryStream(2,fin,fin.available());  
           int i=ps.executeUpdate();  
           System.out.println(i+" records affected");  
            out.println("<p>Details of Student Mr./Ms."+name+" has been succesfully upated</p>");
            
        }catch (SQLException ex) {
                System.out.println(ex);
         }
            
    }
     public void destroy()
       {
          try
          {
             if (cn!=null) 
             {
                 cn.close();
             }
          } catch (Exception ex) {
            System.out.println(ex);
                                } 
       }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}