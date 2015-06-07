
package paczka;

import java.sql.Connection;
import java.sql.DriverManager;


public final class MySQLpolaczenie extends polaczenie{

    public MySQLpolaczenie(String[] params) {
        this.params = params;
        this.open();
    }
    
    @Override
    public Connection open() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://dawid73.cal24.pl:3306/"+this.params[0];
            this.connection = DriverManager.getConnection(url, this.params[1], this.params[2]);
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return this.connection;
    }
    
}
