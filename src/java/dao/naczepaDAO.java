/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.naczepa;


public interface naczepaDAO {
    public List<naczepa> list();
    public naczepa edit(int id);
    public boolean save(naczepa naczep);
    public boolean delete(int id);
    
}