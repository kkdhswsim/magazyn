
package paczka;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class polaczenie {
    protected String [] params;
    protected Connection connection;
    
    abstract Connection open();
    
    public ResultSet query(String query){
        Statement st;
        ResultSet rs = null;
        try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    
        public boolean execute(String query){
        Statement st;
        boolean save = true;
        try{
            st = connection.createStatement();
            st.executeUpdate(query);
        }catch (SQLException e){
            save=false;
            e.printStackTrace();
        }
        return save;
    }
        
        public boolean close(){
            boolean ok = true;
            try{
                connection.close();
            }catch (Exception e){
                ok=false;
                e.printStackTrace();
            }
            return ok;
        }
    
}
