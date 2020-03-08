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
public class attendanceentryservlet extends HttpServlet {

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
           String adno = request.getParameter("adno");
           String date = request.getParameter("date");
           String p1 = request.getParameter("attendance1");
           String p2 = request.getParameter("attendance2");
           String p3 = request.getParameter("attendance3");
           String p4 = request.getParameter("attendance4");
           String p5 = request.getParameter("attendance5");
           String p6 = request.getParameter("attendance6");
           String p7 = request.getParameter("attendance7");
           String p8 = request.getParameter("attendance8");
           String query ="insert into stuattendance values ('"+adno+"','"+date+"','"+p1+"','"+p2+"','"+p3+"','"+p4+"','"+p5+"','"+p6+"','"+p7+"','"+p8+"')";
           stmt.executeUpdate(query);
            out.println("<p>Attendance <b>"+adno+"</b> for the date <b>"+date+"</b> has been succesfully upated</p>");
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