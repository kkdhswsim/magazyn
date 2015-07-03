/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.ciezarowka;


public interface ciezarowkaDAO {
    public List<ciezarowka> list();
    public ciezarowka edit(int id);
    public boolean save(ciezarowka cieza);
    public boolean delete(int id);
    
}