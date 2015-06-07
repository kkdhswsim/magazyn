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
import model.dostawca;
import paczka.connectionDB;
import paczka.polaczenie;

/**
 *
 * @author Dawid
 */
public class dostawcaADD implements dostawcaDAO {
    
    polaczenie conn;

    public dostawcaADD() {
        
    }
    
    

    @Override
    public List<dostawca> list() {
        this.conn = connectionDB.open(connectionDB.MYSQL);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM dostawcy");
        List<dostawca> list = new ArrayList<dostawca>();
        try{
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                dostawca dostaw = new dostawca();
                dostaw.setId(rs.getInt("id"));
                dostaw.setNazwa(rs.getString("nazwa"));
                dostaw.setAdres(rs.getString("adres"));
                dostaw.setNip(rs.getString("nip"));
                list.add(dostaw);
            }
        }catch(Exception e){
             }
        finally{
            this.conn.close();
        }    
       return list;
    }

    @Override
    public dostawca edit(int id) {
        this.conn = connectionDB.open(connectionDB.MYSQL);
        dostawca dostaw = new dostawca();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM dostawcy WHERE id = ").append(id);
        try{
            ResultSet rs = this.conn.query(sql.toString());
            while (rs.next()){
                dostaw.setId(rs.getInt("id"));
                dostaw.setNazwa(rs.getString("nazwa"));
                dostaw.setAdres(rs.getString("adres"));
                dostaw.setNip(rs.getString("nip"));
            }
        }catch(Exception e){  
        }finally{
            this.conn.close();
        }
        return dostaw;
    }

    @Override
    public boolean save(dostawca dostaw) {
        this.conn = connectionDB.open(connectionDB.MYSQL);
        boolean save = false;
        try{
            if(dostaw.getId() == 0) {//dodaje nowy wpis
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO dostawcy (nazwa, adres, nip) VALUES ('").append(dostaw.getNazwa());
                sql.append("', '").append(dostaw.getAdres()).append("', '").append(dostaw.getNip()).append("')");
                this.conn.execute(sql.toString());
            }else{//aktualizacja wpisu
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE dostawcy SET id = ").append(dostaw.getId());
                sql.append(", nazwa = '").append(dostaw.getNazwa());
                sql.append("', adres = '").append(dostaw.getAdres());
                sql.append("', nip = '").append(dostaw.getNip());
                sql.append("' WHERE id = ").append(dostaw.getId()).append(";");
                this.conn.execute(sql.toString());
            }
            save = true;
        }catch(Exception e){
            
        }finally{
            this.conn.close();
        }
    return save;
    }

    @Override
    public boolean delete(int id) {
      this.conn = connectionDB.open(connectionDB.MYSQL);
      boolean delete = false; 
      try{
          StringBuilder sql = new StringBuilder();
          sql.append("DELETE FROM dostawcy WHERE id = ");
          sql.append(id);
          this.conn.execute(sql.toString());
          
      }catch(Exception e){
          
      }finally{
          this.conn.close();
      }return delete;
    
    }
    
}
