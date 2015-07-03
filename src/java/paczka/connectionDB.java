
package paczka;

public class connectionDB {
    
    public static final int MYSQL = 1;
    public static String[] configMYSQL = {"swsim", "root", ""};
    
    public static polaczenie open(int typeDb){
        switch(typeDb){
            case connectionDB.MYSQL:
                return new MySQLpolaczenie(configMYSQL);
            default:
                return null;
    }
    
}
}
