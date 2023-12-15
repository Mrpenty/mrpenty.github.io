/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dal.RoleDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.regex.Pattern;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 *
 * @author dclon
 */
public class MyMethod {

    public MyMethod() {
    }

    public static String getFileType(String fileName) {
        int i = fileName.lastIndexOf(".");
        return fileName.substring(i, fileName.length());
    }

   

    public static String formatName(String name) {
        String     s_temp = name.toLowerCase();
        s_temp = s_temp.replace(' ', '-');
        s_temp = s_temp.replace('đ', 'd');
        s_temp = s_temp.replace('ê', 'e');
        s_temp = s_temp.replace('ô', 'o');
        s_temp = s_temp.replace('â', 'a');
        return s_temp;
    }

    public static String getUpload(Part file, String name, String pathAddressUpload) throws IOException {
        String fileName = file.getSubmittedFileName();
        String fileType = getFileType(fileName);
        String uploadPath = null;
        if (fileName != "") {
            uploadPath = pathAddressUpload + formatName(name) + fileType;
            try (FileOutputStream fos = new FileOutputStream(uploadPath)) {
                InputStream is = file.getInputStream();
                byte[] data = new byte[is.available()];
                is.read(data);
                fos.write(data);
            }
        }
        String val = uploadPath.replaceFirst("D:/Document/Player/web", ".");
        return val;
    }

    public static String getFolder(int category_ID) {
        switch (category_ID) {
            case 1:
                return "vpop";
            case 2:
                return "us-uk";
            case 3:
                return "lofi";
        }
        return null;
    }
    
    public static String getRole_name(int role_ID) {
        RoleDAO rd = new RoleDAO();
        return rd.getRoleName(role_ID);
    }

   

    

    public static boolean checkInput(String input) {
        if (input == null || input.trim().length() == 0) {
            return false;
        }
        return true;
    }

    
    

   

    
}
