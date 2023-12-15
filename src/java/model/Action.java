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
public class Action {
    private int id;
    private String name;
    private int total_Activity;
    
    public Action() {
    }

    public Action(String name) {
        this.name = name;
    }

    public Action(int id, String name) {
        this.id = id;
        this.name = name;
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

    public int getTotal_Activity() {
        return total_Activity;
    }

    public void setTotal_Activity(int total_Activity) {
        this.total_Activity = total_Activity;
    }
    
}
