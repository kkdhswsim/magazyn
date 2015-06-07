/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.dostawca;


public interface dostawcaDAO {
    public List<dostawca> list();
    public dostawca edit(int id);
    public boolean save(dostawca dostaw);
    public boolean delete(int id);
    
}
