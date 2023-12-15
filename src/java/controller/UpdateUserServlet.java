/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.MyMethod;
import model.User;

/**
 *
 * @author use
 */
@WebServlet(name="UpdateUserServlet", urlPatterns={"/updateuser"})
public class UpdateUserServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      UserDAO ud = new UserDAO();
String id = request.getParameter("id");
String url = request.getParameter("url");
HttpSession session = request.getSession();
User u = (User) session.getAttribute("user");

String first_name = request.getParameter("first-name");
String last_name = request.getParameter("last-name");
String old_password = request.getParameter("old-password");
String new_password = request.getParameter("new-password");
String verify_password = request.getParameter("verify-password");
String email = request.getParameter("email");
Boolean flag = true;

if (MyMethod.checkInput(old_password)) {
    if (old_password.equals(u.getPassword())) {
        if (new_password.equals(verify_password)) {
            if (MyMethod.checkInput(new_password)) {
                u.setPassword(new_password);
            } else {
                flag = false;
            }
        } else {
            flag = false;
            request.setAttribute("message", "Password and Verify Password do not match.");
        }
    } else {
        flag = false;
        request.setAttribute("message", "Incorrect old password.");
    }
}

if (MyMethod.checkInput(first_name) && flag) {
    u.setFirs_name(first_name);
}
if (MyMethod.checkInput(last_name) && flag) {
    u.setLast_name(last_name);
}
if (MyMethod.checkInput(email) && flag) {
    u.setEmail(email);
}

ud.updateUser(u);

request.getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
