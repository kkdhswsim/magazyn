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
public class trasa {
    
    private int id;
    private int kierowca_id;
    private int ciezarowka_id;
    private int naczepa_id;
    private String dwyjazd;
    private String dpowrot;
    private String mwyjazd;
    private String mpowrot;

    public void setId(int id) {
        this.id = id;
    }

    public void setKierowca_id(int kierowca_id) {
        this.kierowca_id = kierowca_id;
    }

    public void setCiezarowka_id(int ciezarowka_id) {
        this.ciezarowka_id = ciezarowka_id;
    }

    public void setNaczepa_id(int naczepa_id) {
        this.naczepa_id = naczepa_id;
    }

    public void setDwyjazd(String dwyjazd) {
        this.dwyjazd = dwyjazd;
    }

    public void setDpowrot(String dpowrot) {
        this.dpowrot = dpowrot;
    }

    public void setMwyjazd(String mwyjazd) {
        this.mwyjazd = mwyjazd;
    }

    public void setMpowrot(String mpowrot) {
        this.mpowrot = mpowrot;
    }

    public int getId() {
        return id;
    }

    public int getKierowca_id() {
        return kierowca_id;
    }

    public int getCiezarowka_id() {
        return ciezarowka_id;
    }

    public int getNaczepa_id() {
        return naczepa_id;
    }

    public String getDwyjazd() {
        return dwyjazd;
    }

    public String getDpowrot() {
        return dpowrot;
    }

    public String getMwyjazd() {
        return mwyjazd;
    }

    public String getMpowrot() {
        return mpowrot;
    }

}
