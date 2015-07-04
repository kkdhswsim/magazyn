/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.kierowca;

import model.trasa;



public interface trasaDAO {
    public List<trasa> list();

    public trasa edit(int id);
    public boolean save(trasa tras);

    public boolean delete(int id);
    
}