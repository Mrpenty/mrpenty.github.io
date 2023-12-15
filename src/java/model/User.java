/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author dclon
 */
public class User {

    private int id;
    private String username;
    private String password;
    private String firs_name;
    private String last_name;
    private String avatar;
    private int role_id;
    private String email;

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role_id = 1;
    }

    public User(String username, String password, String firs_name, String last_name, String avatar, int role_id, String email) {
        this.username = username;
        this.password = password;
        this.firs_name = firs_name;
        this.last_name = last_name;
        this.avatar = avatar;
        this.role_id = role_id;
        this.email = email;
    }

    public User(int id, String username, String password, String firs_name, String last_name, String avatar, int role_id, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firs_name = firs_name;
        this.last_name = last_name;
        this.avatar = avatar;
        this.role_id = role_id;
        this.email = email;
    }

    public User(String firs_name, String last_name, String username, String password, String email) {
          this.firs_name = firs_name;
        this.last_name = last_name;
         this.username = username;
       this.password = password;
       this.email = email;

       this.role_id = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirs_name() {
        return firs_name;
    }

    public void setFirs_name(String firs_name) {
        this.firs_name = firs_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFullname() {
        return firs_name + " " + last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getRole_id() {
        return role_id;
    }
    
    public String getRole_name() {
        return MyMethod.getRole_name(role_id);
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

   

  
   
    
  
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

 

  

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", firs_name=" + firs_name + ", last_name=" + last_name + ", avatar=" + avatar + ", role_id=" + role_id + ", email=" + email + '}';
    }
    
    
}
