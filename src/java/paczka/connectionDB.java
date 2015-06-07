
package paczka;

public class connectionDB {
    
    public static final int MYSQL = 1;
    public static String[] configMYSQL = {"dawid73_swsim", "dawid73_swsim", "java4321"};
    
    public static polaczenie open(int typeDb){
        switch(typeDb){
            case connectionDB.MYSQL:
                return new MySQLpolaczenie(configMYSQL);
            default:
                return null;
    }
    
}
}
