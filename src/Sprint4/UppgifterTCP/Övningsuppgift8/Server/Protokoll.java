package Sprint4.UppgifterTCP.Övningsuppgift8.Server;

public class Protokoll {

    final protected int INITIAL = 0;
    final protected int INTHELOOP = 1;

    Database d =  new Database();
    protected int state = INITIAL;

    public String getOutput(String fromClient){
        if(state == INITIAL){
            state = INTHELOOP;
            return "Vilken kompis vill du slå upp i telfonboken?";
        }
        else if(state == INTHELOOP){
            return d.getKompisData(fromClient);
        }
        return "Unexpected state error";
    }
}
