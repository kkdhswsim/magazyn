/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.kierowca;
<<<<<<< HEAD
import model.trasa;
=======
>>>>>>> 4e42201f82dece0e9c6fdb8f5bbe63f897bdc99c


public interface trasaDAO {
    public List<trasa> list();
<<<<<<< HEAD
    public trasa edit(int id);
    public boolean save(trasa tras);
=======
    public kierowca edit(int id);
    public boolean save(kierowca kierow);
>>>>>>> 4e42201f82dece0e9c6fdb8f5bbe63f897bdc99c
    public boolean delete(int id);
    
}