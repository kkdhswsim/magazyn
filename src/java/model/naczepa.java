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
public class naczepa {
    
    private int id;
    private String marka;
    private String typ;
    private String rejestracja;

    public naczepa() {
        this.id=0;
        this.marka="";
        this.typ="";
        this.rejestracja="";
    }

    public naczepa(int id, String marka, String typ, String rejestracja) {
        this.id = id;
        this.marka = marka;
        this.typ = typ;
        this.rejestracja = rejestracja;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setTyp(String typ) {
        this.typ = typ;
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

    public String getTyp() {
        return typ;
    }

    public String getRejestracja() {
        return rejestracja;
    }
    
}
