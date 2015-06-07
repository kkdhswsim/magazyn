
package model;

public class artykul {
    private int id;
    private String nazwa;
    private int dostawca_id;
    private int ilosc;
    private double cena;
    private dostawca dostaw;

    public artykul() {
        this.id=0;
        this.dostaw = new dostawca();
    }

    public artykul(int id, String nazwa, int dostawca_id, int ilosc, double cena, dostawca dostaw) {
        this.id = id;
        this.nazwa = nazwa;
        this.dostawca_id = dostawca_id;
        this.ilosc = ilosc;
        this.cena = cena;
        this.dostaw = dostaw;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setDostawca_id(int dostawca_id) {
        this.dostawca_id = dostawca_id;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setDostaw(dostawca dostaw) {
        this.dostaw = dostaw;
    }

    public int getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getDostawca_id() {
        return dostawca_id;
    }

    public int getIlosc() {
        return ilosc;
    }

    public double getCena() {
        return cena;
    }

    public dostawca getDostaw() {
        return dostaw;
    }
    
    
}
