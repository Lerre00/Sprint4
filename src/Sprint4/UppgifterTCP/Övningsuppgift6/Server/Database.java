package Sprint4.UppgifterTCP.Övningsuppgift6.Server;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private final Kompis k1 = new Kompis("Leroy", "0702231254", "09/18", "leroycollazo@hotmail.com");
    private final Kompis k2 = new Kompis("Anton", "1234567", "08/03", "anton@hotmail.com");
    private final Kompis k3 = new Kompis("Jani", "7654321","14/05", "jani@hotmail.com");
    private final Kompis k4 = new Kompis("Samuel", "111222333","13/01", "samuelcollazo@hotmail.com");

    private final List <Kompis> allFriends = new ArrayList<>();

    public Database(){
        allFriends.add(k1);
        allFriends.add(k2);
        allFriends.add(k3);
        allFriends.add(k4);
    }


    public Kompis getCarData(String s){
        for (Kompis k :allFriends){
            if (k.getKompis().equalsIgnoreCase(s)){
                return k;
            }
        }
        return null;
    }

}
