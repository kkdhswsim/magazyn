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
import paczka.connectionDB;
import paczka.polaczenie;

/**
 *
 * @author Dawid
 */
public class ciezarowkaADD implements ciezarowkaDAO {
    
    polaczenie conn;

    public ciezarowkaADD() {
        
    }
    
    


    public List<ciezarowka> list() {
        this.conn = connectionDB.open(connectionDB.MYSQL);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ciezarowka");
        List<ciezarowka> list = new ArrayList<ciezarowka>();
        try{
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                ciezarowka dostaw = new ciezarowka();
                dostaw.setId(rs.getInt("id"));
                dostaw.setMarka(rs.getString("marka"));
                dostaw.setModel(rs.getString("model"));
                dostaw.setRejestracja(rs.getString("rejestracja"));
                list.add(dostaw);
            }
        }catch(Exception e){
             }
        finally{
            this.conn.close();
        }    
       return list;
    }


    public ciezarowka edit(int id) {
        this.conn = connectionDB.open(connectionDB.MYSQL);
        ciezarowka dostaw = new ciezarowka();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ciezarowka WHERE id = ").append(id);
        try{
            ResultSet rs = this.conn.query(sql.toString());
            while (rs.next()){
                dostaw.setId(rs.getInt("id"));
                dostaw.setMarka(rs.getString("marka"));
                dostaw.setModel(rs.getString("model"));
                dostaw.setRejestracja(rs.getString("rejestracja"));
            }
        }catch(Exception e){  
        }finally{
            this.conn.close();
        }
        return dostaw;
    }
    

    public boolean save(ciezarowka kierow) {
        this.conn = connectionDB.open(connectionDB.MYSQL);
        boolean save = false;
        try{
            if(kierow.getId() == 0) {//dodaje nowy wpis
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO ciezarowka (marka, model, rejestracja) VALUES ('").append(kierow.getMarka());
                sql.append("', '").append(kierow.getModel()).append("', '").append(kierow.getRejestracja()).append("')");
                this.conn.execute(sql.toString());
            }else{//aktualizacja wpisu
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE ciezarowka SET id = ").append(kierow.getId());
                sql.append(", marka = '").append(kierow.getMarka());
                sql.append("', model = '").append(kierow.getModel());
                sql.append("', rejestracja = '").append(kierow.getRejestracja());
                sql.append("' WHERE id = ").append(kierow.getId()).append(";");
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
          sql.append("DELETE FROM ciezarowka WHERE id = ");
          sql.append(id).append(";");
          this.conn.execute(sql.toString());
          
      }catch(Exception e){
          
      }finally{
          this.conn.close();
      }return delete;
    
    }
    
}