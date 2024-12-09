/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darsh
 */
public class datastore extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String rollNo = request.getParameter("rollNo");
        int marks_os = Integer.parseInt(request.getParameter("marks_os"));
        int marks_sp = Integer.parseInt(request.getParameter("marks_sp"));
        int marks_java = Integer.parseInt(request.getParameter("marks_java"));
        int marks_db = Integer.parseInt(request.getParameter("marks_db"));
        String notes = request.getParameter("notes");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/darshan", "root", "");
//            String sql = "INSERT INTO students (roll_no, marks_os, marks_sp, marks_java, marks_db, notes) VALUES (?, ?, ?, ?, ?, ?)";
//            PreparedStatement st = conn.prepareStatement("INSERT INTO students (roll_no, marks_os, marks_sp, marks_java, marks_db, notes) VALUES (?, ?, ?, ?, ?, ?)");
        PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("INSERT INTO student (roll_no, os, sp, java, db, notes) VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setString(1, rollNo);
        stmt.setInt(2, marks_os);
        stmt.setInt(3, marks_sp);
        stmt.setInt(4, marks_java);
        stmt.setInt(5, marks_db);
        stmt.setString(6, notes);

        stmt.executeUpdate();
//            stmt.close();
//            conn.close();
        response.sendRedirect("dataenter.html");
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
            Logger.getLogger(datastore.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(datastore.class.getName()).log(Level.SEVERE, null, ex);
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
