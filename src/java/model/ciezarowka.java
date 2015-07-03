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
public class ciezarowka {
    
    private int id;
    private String marka;
    private String model;
    private String rejestracja;

    public ciezarowka() {
        this.id=0;
        this.marka="";
        this.model="";
        this.rejestracja="";
    }

    public ciezarowka(int id, String marka, String model, String rejestracja) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.rejestracja = rejestracja;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRejestracja(String rejestracja) {
        this.rejestracja = rejestracja;
    }

    public int getId() {
        return id;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public String getRejestracja() {
        return rejestracja;
    }
    
}
