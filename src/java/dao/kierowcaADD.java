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
import model.kierowca;
import paczka.connectionDB;
import paczka.polaczenie;

/**
 *
 * @author Dawid
 */
public class kierowcaADD implements kierowcaDAO {
    
    polaczenie conn;

    public kierowcaADD() {
        
    }
    
    


    public List<kierowca> list() {
        this.conn = connectionDB.open(connectionDB.MYSQL);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM kierowca");
        List<kierowca> list = new ArrayList<kierowca>();
        try{
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                kierowca dostaw = new kierowca();
                dostaw.setId(rs.getInt("id"));
                dostaw.setImie(rs.getString("imie"));
                dostaw.setNazwisko(rs.getString("nazwisko"));
                dostaw.setNrdokumentu(rs.getString("nrdokumentu"));
                list.add(dostaw);
            }
        }catch(Exception e){
             }
        finally{
            this.conn.close();
        }    
       return list;
    }


    public kierowca edit(int id) {
        this.conn = connectionDB.open(connectionDB.MYSQL);
        kierowca dostaw = new kierowca();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM kierowca WHERE id = ").append(id);
        try{
            ResultSet rs = this.conn.query(sql.toString());
            while (rs.next()){
                dostaw.setId(rs.getInt("id"));
                dostaw.setImie(rs.getString("imie"));
                dostaw.setNazwisko(rs.getString("nazwisko"));
                dostaw.setNrdokumentu(rs.getString("nrdokumentu"));
            }
        }catch(Exception e){  
        }finally{
            this.conn.close();
        }
        return dostaw;
    }

    public boolean save(kierowca kierow) {
        this.conn = connectionDB.open(connectionDB.MYSQL);
        boolean save = false;
        try{
            if(kierow.getId() == 0) {//dodaje nowy wpis
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO kierowca (imie, nazwisko, nrdokumentu) VALUES ('").append(kierow.getImie());
                sql.append("', '").append(kierow.getNazwisko()).append("', '").append(kierow.getNrdokumentu()).append("')");
                this.conn.execute(sql.toString());
            }else{//aktualizacja wpisu
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE dostawcy SET id = ").append(kierow.getId());
                sql.append(", imie = '").append(kierow.getImie());
                sql.append("', nazwisko = '").append(kierow.getNazwisko());
                sql.append("', nrdokumentu = '").append(kierow.getNrdokumentu());
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
          sql.append("DELETE FROM kierowca WHERE id = ");
          sql.append(id);
          this.conn.execute(sql.toString());
          
      }catch(Exception e){
          
      }finally{
          this.conn.close();
      }return delete;
    
    }
    
}