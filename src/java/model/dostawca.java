
package model;

public class dostawca {
    
    private int id;
    private String nazwa;
    private String adres;
    private String nip;

    public dostawca() {
        this.id=0;
        this.nazwa="";
        this.adres="";
        this.nip="";
    }

    public dostawca(int id, String nazwa, String adres, String nip) {
        this.id = id;
        this.nazwa = nazwa;
        this.adres = adres;
        this.nip = nip;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public int getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getAdres() {
        return adres;
    }

    public String getNip() {
        return nip;
    }
    
    
    
}
