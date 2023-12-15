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
public class Slider {
    
    private int id;
    private Album album;
    private String heading;
    private String text;

    public Slider() {
    }

    public Slider(int id, Album album, String heading, String text) {
        this.id = id;
        this.album = album;
        this.heading = heading;
        this.text = text;
    }

    public Slider(Album album, String heading, String text) {
        this.album = album;
        this.heading = heading;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
}
