
package test;



import java.util.List;
import dao.kierowcaDAO;
import dao.kierowcaADD;
import model.kierowca;


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
        kierowcaDAO kierowDAO = new kierowcaADD();
        List<kierowca> list = kierowDAO.list();
        System.out.println("- kierowcy -");
       for(kierowca kierow : list){
           System.out.println("id: "+kierow.getId()+" Imie: "+kierow.getImie()+" Nazwisko: "+kierow.getNazwisko()+" Nr dokumentu: "+kierow.getNrdokumentu());
       }
    }
    
    public void editMySQL(){
       // dostawcaDAO dostawDAO = new dostawcaADD();
        //dostawca dostaw = dostawDAO.edit(2);
        
     //   System.out.println("Id: "+dostaw.getId()+" Nazwa: "+dostaw.getNazwa());

    }
    
        public void saveMySQL(){
        kierowcaDAO kierowDAO = new kierowcaADD();
        kierowca kierow = new kierowca();
        //dostaw.setId(6);
        kierow.setImie("Adam");
        kierow.setNazwisko("Firanka");
        kierow.setNrdokumentu("7777-1111-12122");
        kierowDAO.save(kierow);

    }
        
        public void deleteMySQL(){
       // dostawcaDAO dostawDAO = new dostawcaADD();
       // dostawDAO.delete(2);
        
        }
}
