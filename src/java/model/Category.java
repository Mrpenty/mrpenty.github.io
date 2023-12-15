/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dclon
 */
public class Category {
    private int id;
    private String name;
    private int total_Album;
    private int total_Liked;
    private int total_User;

    public Category() {
    }

    public Category(String name, int total_Album, int total_Liked, int total_User) {
        this.name = name;
        this.total_Album = total_Album;
        this.total_Liked = total_Liked;
        this.total_User = total_User;
    }

    public Category(int id, String name, int total_Album, int total_Liked, int total_User) {
        this.id = id;
        this.name = name;
        this.total_Album = total_Album;
        this.total_Liked = total_Liked;
        this.total_User = total_User;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal_Album() {
        return total_Album;
    }

    public void setTotal_Album(int total_Album) {
        this.total_Album = total_Album;
    }

    public int getTotal_Liked() {
        return total_Liked;
    }

    public void setTotal_Liked(int total_Liked) {
        this.total_Liked = total_Liked;
    }

    public int getTotal_User() {
        return total_User;
    }

    public void setTotal_User(int total_User) {
        this.total_User = total_User;
    }
    
}
