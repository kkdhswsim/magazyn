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
import model.login;
import paczka.connectionDB;
import paczka.polaczenie;


/**
 *
 * @author Dawid
 */
public class loginADD implements loginDAO {
    
    polaczenie conn;

    public loginADD() {
        
    }
    
    public List<login> list() {
        this.conn = connectionDB.open(connectionDB.MYSQL);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM user");
        List<login> list = new ArrayList<login>();
        try{
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                login log = new login();
                log.setId(rs.getInt("id"));
                log.setUsername(rs.getString("username"));
                log.setPass(rs.getString("pass"));
                list.add(log);
            }
        }catch(Exception e){
             }
        finally{
            this.conn.close();
        }    
       return list;
    }
    
}

 
