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
public class addmarksservlet extends HttpServlet {

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
           String dept = request.getParameter("dept");
           String exam = request.getParameter("exam");
           String sem = request.getParameter("sem");
           String c1 = request.getParameter("c1");
           String c2 = request.getParameter("c2");
           String c3 = request.getParameter("c3");
           String c4 = request.getParameter("c4");
           String c5 = request.getParameter("c5");
           String c6 = request.getParameter("c6");
           String name = request.getParameter("name");
           String query ="insert into stumarks values ('"+adno+"','"+name+"','"+dept+"','"+sem+"','"+exam+"',"+c1+","+c2+","+c3+","+c4+","+c5+","+c6+")";
           stmt.executeUpdate(query);
            out.println("<p>Marks for the student <b>"+name+"</b> in the<b>"+exam+"</b> has been succesfully upated</p>");
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