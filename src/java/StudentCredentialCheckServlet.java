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
public class StudentCredentialCheckServlet extends HttpServlet {

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
           String choice = request.getParameter("choice");
           String rpassword = null;
           String name=null;
           String adno=null;
           adno=request.getParameter("uid");
           String password=request.getParameter("password");
           String query ="select * from stupass where adno='"+adno+"'";
           ResultSet rs = stmt.executeQuery(query);
           rs = stmt.executeQuery(query);
           while(rs.next())
           {
               rpassword = rs.getString("password");
           }
           if(rpassword.equals(password)){     
            if(choice.equals("profile"))
            {
                 RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
                 request.setAttribute("adno",adno); // set your String value in the attribute
                 dispatcher.forward( request, response );
            }    
            if(choice.equals("academics"))
            {
                 RequestDispatcher dispatcher = request.getRequestDispatcher("academics.jsp");
                 request.setAttribute("adno",adno); // set your String value in the attribute
                 dispatcher.forward( request, response );
            }
            if(choice.equals("attendance"))
            {
                 RequestDispatcher dispatcher = request.getRequestDispatcher("attendance.jsp");
                 request.setAttribute("adno",adno); // set your String value in the attribute
                 dispatcher.forward( request, response );
            }
           }
        }
            catch (SQLException ex) {
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