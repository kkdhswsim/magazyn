/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ciezarowka;
import model.kierowca;
import model.trasa;
import paczka.connectionDB;
import paczka.polaczenie;

/**
 *
 * @author Dawid
 */
public class trasaADD implements trasaDAO {
    
    polaczenie conn;

    public trasaADD() {
        
    }
    
    
    public List<trasa> list() {
        this.conn = connectionDB.open(connectionDB.MYSQL);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM trasa");
        List<trasa> list = new ArrayList<trasa>();
        try{
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                trasa tr = new trasa();
                tr.setId(rs.getInt("id"));
                tr.setKierowca_id(rs.getInt("kierowca_id"));
                tr.setCiezarowka_id(rs.getInt("ciezarowka_id"));
                tr.setNaczepa_id(rs.getInt("naczepa_id"));
                tr.setDwyjazd(rs.getString("dwyjazd"));
                tr.setMwyjazd(rs.getString("mwyjazd"));
                tr.setDpowrot(rs.getString("dpowrot"));
                tr.setMpowrot(rs.getString("mpowrot"));
                list.add(tr);
            }
        }catch(Exception e){
             }
        finally{
            this.conn.close();
        }    
       return list;
    }
    

    public trasa edit(int id) {
        this.conn = connectionDB.open(connectionDB.MYSQL);
        trasa tr = new trasa();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM trasa WHERE id = ").append(id);
        try{
            ResultSet rs = this.conn.query(sql.toString());
            while (rs.next()){
                
                tr.setId(rs.getInt("id"));
                tr.setKierowca_id(rs.getInt("kierowca_id"));
                tr.setCiezarowka_id(rs.getInt("ciezarowka_id"));
                tr.setNaczepa_id(rs.getInt("naczepa_id"));
                tr.setDwyjazd(rs.getString("dwyjazd"));
                tr.setMwyjazd(rs.getString("mwyjazd"));
                tr.setDpowrot(rs.getString("dpowrot"));
                tr.setMpowrot(rs.getString("mpowrot"));
               
            }
        }catch(Exception e){  
        }finally{
            this.conn.close();
        }
        return tr;
    }
    

    public boolean save(trasa tr) {
       this.conn = connectionDB.open(connectionDB.MYSQL);
        boolean save = false;
        try{
            if(tr.getId() == 0) {//dodaje nowy wpis
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO trasa (kierowca_id, ciezarowka_id, naczepa_id, dwyjazd, dpowrot, mwyjazd, mpowrot) VALUES (").append(tr.getKierowca_id());
                sql.append(", ").append(tr.getCiezarowka_id()).append(", ").append(tr.getNaczepa_id());
                sql.append(", '").append(tr.getDwyjazd()).append("', '").append(tr.getDpowrot());
                sql.append("', '").append(tr.getMwyjazd()).append("', '").append(tr.getMpowrot()).append("')");
                this.conn.execute(sql.toString());
            }else{//aktualizacja wpisu
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE kierowca SET id = ").append(tr.getId());
                sql.append(", imie = '").append(tr.getId());
                sql.append("', nazwisko = '").append(tr.getId());
                sql.append("', nrdokumentu = '").append(tr.getId());
                sql.append("' WHERE id = ").append(tr.getId()).append(";");
                this.conn.execute(sql.toString());
            }
            save = true;
        }catch(Exception e){
            
        }finally{
            this.conn.close();
        }
    return save;
    }


    public boolean delete(int id) {
      this.conn = connectionDB.open(connectionDB.MYSQL);
      boolean delete = false; 
      try{
          StringBuilder sql = new StringBuilder();
          sql.append("DELETE FROM trasa WHERE id = ");
          sql.append(id).append(";");
          this.conn.execute(sql.toString());
          
      }catch(Exception e){
          
      }finally{
          this.conn.close();
      }return delete;
    
    }
    
   
    
}