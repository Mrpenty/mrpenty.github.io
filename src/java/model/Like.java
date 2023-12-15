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
public class Like {
    private int id;
    private int user_ID;
    private int album_ID;

    public Like() {
    }

    public Like(int id, int user_ID, int album_ID) {
        this.id = id;
        this.user_ID = user_ID;
        this.album_ID = album_ID;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public int getAlbum_ID() {
        return album_ID;
    }

    public void setAlbum_ID(int album_ID) {
        this.album_ID = album_ID;
    }

   
    
    
}
