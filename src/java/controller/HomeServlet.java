/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.AlbumDAO;
import dal.SliderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Album;
import model.Slider;
import model.User;

/**
 *
 * @author use
 */
@WebServlet(name="HomeServlet", urlPatterns={"/home"})
public class HomeServlet extends HttpServlet {
   
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
        
        SliderDAO sd = new SliderDAO();
        ArrayList<Slider> sliders = sd.getAll();
        request.setAttribute("sliders", sliders);
        AlbumDAO ad = new AlbumDAO();
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        if (u != null) {
            ArrayList<Album> albums_Vpop = ad.getAlbumsOfCategoryWithUser(1, u.getId());
            request.setAttribute("albums_Vpop", albums_Vpop);
            ArrayList<Album> albums_USUK = ad.getAlbumsOfCategoryWithUser(2, u.getId());
            request.setAttribute("albums_USUK", albums_USUK);
            ArrayList<Album> albums_Lofi = ad.getAlbumsOfCategoryWithUser(3, u.getId());
            request.setAttribute("albums_Lofi", albums_Lofi);
        } else {
            ArrayList<Album> albums_Vpop = ad.getAlbumsOfCategory(1);
            request.setAttribute("albums_Vpop", albums_Vpop);
            ArrayList<Album> albums_USUK = ad.getAlbumsOfCategory(2);
            request.setAttribute("albums_USUK", albums_USUK);
            ArrayList<Album> albums_Lofi = ad.getAlbumsOfCategory(3);
            request.setAttribute("albums_Lofi", albums_Lofi);
        }
        request.getRequestDispatcher("home.jsp").forward(request, response);
    
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
