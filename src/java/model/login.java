/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dawid
 */
public class login {
    private int id;
    private String username;
    private String pass;
    
    public login() {
        this.id=0;
        this.username="";
        this.pass="";
    }

    public login(int id, String username, String pass) {
        this.id = id;
        this.username = username;
        this.pass = pass;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }
}


