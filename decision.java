/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
//import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author darsh
 */
public class decision extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        if ("enterData".equals(request.getParameter("action"))) {
            response.sendRedirect("first.html");
        } else {
            int roll = Integer.parseInt(request.getParameter("rollNo"));
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<h1> Your roll No.:"+roll+"</h1>");
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/darshan", "root", "");

            // Query to get the OS marks of the student with the given roll number
            String query = "SELECT * FROM student WHERE roll_no = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, roll);

            // Execute the query
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Retrieve OS marks
                int os = rs.getInt("os");
                int sp=rs.getInt("sp");
                int db=rs.getInt("db");
                int java=rs.getInt("java");
                String notes=rs.getString("notes");
                request.setAttribute("roll", roll);
                request.setAttribute("os", os);
                request.setAttribute("sp", sp);
                request.setAttribute("db", db);
                request.setAttribute("java", java);
                request.setAttribute("notes", notes);
                request.getRequestDispatcher("showdata.jsp").forward(request, response);
            } else {
                response.sendRedirect("decision.html");
            }
        }
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet decision</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet decision at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(decision.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(decision.class.getName()).log(Level.SEVERE, null, ex);
        }
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
