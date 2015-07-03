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
import model.naczepa;
import paczka.connectionDB;
import paczka.polaczenie;

/**
 *
 * @author Dawid
 */
public class naczepaADD implements naczepaDAO {
    
    polaczenie conn;

    public naczepaADD() {
        
    }
    
    


    public List<naczepa> list() {
        this.conn = connectionDB.open(connectionDB.MYSQL);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM naczepa");
        List<naczepa> list = new ArrayList<naczepa>();
        try{
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                naczepa dostaw = new naczepa();
                dostaw.setId(rs.getInt("id"));
                dostaw.setMarka(rs.getString("marka"));
                dostaw.setTyp(rs.getString("typ"));
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


    public naczepa edit(int id) {
        this.conn = connectionDB.open(connectionDB.MYSQL);
        naczepa dostaw = new naczepa();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM naczepa WHERE id = ").append(id);
        try{
            ResultSet rs = this.conn.query(sql.toString());
            while (rs.next()){
                dostaw.setId(rs.getInt("id"));
                dostaw.setMarka(rs.getString("marka"));
                dostaw.setTyp(rs.getString("typ"));
                dostaw.setRejestracja(rs.getString("rejestracja"));
            }
        }catch(Exception e){  
        }finally{
            this.conn.close();
        }
        return dostaw;
    }
    

    public boolean save(naczepa kierow) {
        this.conn = connectionDB.open(connectionDB.MYSQL);
        boolean save = false;
        try{
            if(kierow.getId() == 0) {//dodaje nowy wpis
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO naczepa (marka, typ, rejestracja) VALUES ('").append(kierow.getMarka());
                sql.append("', '").append(kierow.getTyp()).append("', '").append(kierow.getRejestracja()).append("')");
                this.conn.execute(sql.toString());
            }else{//aktualizacja wpisu
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE naczepa SET id = ").append(kierow.getId());
                sql.append(", marka = '").append(kierow.getMarka());
                sql.append("', typ = '").append(kierow.getTyp());
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
          sql.append("DELETE FROM naczepa WHERE id = ");
          sql.append(id).append(";");
          this.conn.execute(sql.toString());
          
      }catch(Exception e){
          
      }finally{
          this.conn.close();
      }return delete;
    
    }
    
}