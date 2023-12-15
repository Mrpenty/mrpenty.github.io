/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.ActionDAO;
import dal.AlbumDAO;
import dal.CategoryDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Action;
import model.Album;
import model.Category;
import model.User;

/**
 *
 * @author use
 */
@WebServlet(name="AdminServlet", urlPatterns={"/admin"})
public class AdminServlet extends HttpServlet {
   
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
         CategoryDAO cd = new CategoryDAO();
        ArrayList<Category> cl = cd.getAll();
        AlbumDAO ad = new AlbumDAO();
        ArrayList<Album> albums_Vpop = ad.getAlbumsOfCategory(1);
        ad.setLiked(albums_Vpop);
        ArrayList<Album> albums_USUK = ad.getAlbumsOfCategory(2);
        ad.setLiked(albums_USUK);
        ArrayList<Album> albums_Lofi = ad.getAlbumsOfCategory(3);
        ad.setLiked(albums_Lofi);
        ActionDAO actionDAO = new ActionDAO();
        ArrayList<Action> actions = actionDAO.getAll();
      
        UserDAO ud = new UserDAO();
        ArrayList<User> users = ud.getAll();
        request.setAttribute("categories", cl);
        request.setAttribute("albums_Vpop", albums_Vpop);
        request.setAttribute("albums_USUK", albums_USUK);
        request.setAttribute("albums_Lofi", albums_Lofi);
        request.setAttribute("actions", actions);
        request.setAttribute("users", users);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
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
