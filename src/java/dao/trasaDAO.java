/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.kierowca;


public interface trasaDAO {
    public List<trasa> list();
    public kierowca edit(int id);
    public boolean save(kierowca kierow);
    public boolean delete(int id);
    
}