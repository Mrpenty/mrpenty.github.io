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
public class Album {

    private int id;
    private String name;
    private String author;
    private int category_id;
    private String duration;
    private String image;
    private String path;
    private int total_liked;
    private boolean liked;

    public Album() {
        this.liked = false;
    }

   

    public Album(int id, String name, String author, int category_id, String duration, String image, String path, int like) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category_id = category_id;
        this.duration = duration;
        this.image = image;
        this.path = path;
        this.total_liked = like;
    }

    public Album(String name, String author, int category_id, String duration, String image, String path) {
        this.name = name;
        this.author = author;
        this.category_id = category_id;
        this.duration = duration;
        this.image = image;
        this.path = path;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getCategory() {
        switch (category_id) {
            case 1:
                return "Vpop";
            case 2:
                return "US-UK";
            case 3:
                return "Lofi";
        }
        return null;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getTotal_liked() {
        return total_liked;
    }

    public void setTotal_liked(int total_liked) {
        this.total_liked = total_liked;
    }

    public boolean isLiked() {
        return liked;
    }
    
    public boolean getLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

}
