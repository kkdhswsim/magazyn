
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
<<<<<<< HEAD
            String url = "jdbc:mysql://dawid73.cal24.pl/"+this.params[0];
=======
            String url = "jdbc:mysql://localhost:6033/"+this.params[0];
>>>>>>> 4e42201f82dece0e9c6fdb8f5bbe63f897bdc99c
            this.connection = DriverManager.getConnection(url, this.params[1], this.params[2]);
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return this.connection;
    }
    
}
