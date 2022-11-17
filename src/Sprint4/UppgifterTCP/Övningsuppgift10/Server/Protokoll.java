package Sprint4.UppgifterTCP.Övningsuppgift10.Server;

public class Protokoll {

    private static final int BEFORE_INIT = 0;
    private static final int WAITING_FOR_REQUEST = 1;

    private int state = BEFORE_INIT;
    Database dao = new Database();
    String dbResponse;

    public Object processInput(String theInput) {
        Object theOutput = null;

        if (state == BEFORE_INIT) {
            theOutput = "Vilken kompis vill du slå upp i telefonboken?";
            state = WAITING_FOR_REQUEST;
        } else if (state == WAITING_FOR_REQUEST) {
            dbResponse = dao.getKompisData(((String) theInput).trim());
            if (dbResponse == null) {
                theOutput = "Kompisen kunde inte hittas";
            } else {
                theOutput = dbResponse;
            }
        }
        return theOutput;
    }
}
