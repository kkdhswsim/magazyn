
package test;

import dao.dostawcaADD;
import dao.dostawcaDAO;
import java.util.List;
import model.dostawca;


public class test {
    
    public static void main(String[] args){
        test te = new test();
        te.listMySQL();
        //te.editMySQL();
        te.saveMySQL();
        //te.deleteMySQL();
        te.listMySQL();
    }
    
    public void listMySQL(){
        dostawcaDAO dostawcaDAO = new dostawcaADD();
        List<dostawca> list = dostawcaDAO.list();
        System.out.println("-dostawcy -");
       for(dostawca dostaw : list){
           
           System.out.println("id: "+dostaw.getId()+" Nazwa: "+dostaw.getNazwa()+" Adres: "+dostaw.getAdres()+" NIP: "+dostaw.getNip());
       }
    }
    
    public void editMySQL(){
        dostawcaDAO dostawDAO = new dostawcaADD();
        dostawca dostaw = dostawDAO.edit(2);
        
        System.out.println("Id: "+dostaw.getId()+" Nazwa: "+dostaw.getNazwa());

    }
    
        public void saveMySQL(){
        dostawcaDAO dostawDAO = new dostawcaADD();
        dostawca dostaw = new dostawca();
        dostaw.setId(6);
        dostaw.setAdres("ul. Chorzowska 27");
        dostaw.setNazwa("Firma PPPRR");
        dostaw.setNip("7777-1111-12122");
        dostawDAO.save(dostaw);

    }
        
        public void deleteMySQL(){
        dostawcaDAO dostawDAO = new dostawcaADD();
        dostawDAO.delete(2);
        
        }
}
