/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.AlbumDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.sql.Timestamp;
import model.Album;
import model.MyMethod;

/**
 *
 * @author use
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100) // 100 MB,

  @WebServlet(name="CreateAlbumServlet", urlPatterns={"/create"})
public class CreateAlbumServlet extends HttpServlet {
   
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          String url = request.getContextPath() + "/admin";
        String create_name = request.getParameter("create_name");
        String create_author = request.getParameter("create_author");
        int category_ID = Integer.parseInt(request.getParameter("create_category"));
        String create_duration = request.getParameter("create_duration");
        Part imageFile = request.getPart("create_image");
        String p_AddressUploadImage = "D:/Document/Player/web/img/song-img"+"/" + MyMethod.getFolder(category_ID) + "/";
        String create_image = MyMethod.getUpload(imageFile, create_name, p_AddressUploadImage);
        Part audioFile = request.getPart("create_audio");
       
        String p_AddressUploadAudio = "D:/Document/Player/web/song-mp3" +"/" + MyMethod.getFolder(category_ID) + "/";
        String create_audio = MyMethod.getUpload(audioFile, create_name, p_AddressUploadAudio);
      
        Album a = new Album(create_name, create_author, category_ID, create_duration, create_image, create_audio);
        AlbumDAO ad = new AlbumDAO();
        ad.inserAlbum(a);
        
        
        response.sendRedirect(url);
    } 

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
