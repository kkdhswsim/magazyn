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
public class kierowca {
    
    private int id;
    private String imie;
    private String nazwisko;
    private String nrdokumentu;

    public kierowca() {
        this.id=0;
        this.imie="";
        this.nazwisko="";
        this.nrdokumentu="";
    }

    public kierowca(int id, String imie, String nazwisko, String nrdokumentu) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrdokumentu = nrdokumentu;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setNrdokumentu(String nrdokumentu) {
        this.nrdokumentu = nrdokumentu;
    }

    public int getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getNrdokumentu() {
        return nrdokumentu;
    }
    
}
