package Sprint4.UppgifterTCP.Övningsuppgift8.Server;

public class Kompis {

    protected String namn;
    protected String mobilnummer;
    protected String födelsedag;
    protected String email;

    public Kompis(String namn, String mobilnummer, String födelsedag, String email) {
        this.namn = namn;
        this.mobilnummer = mobilnummer;
        this.födelsedag = födelsedag;
        this.email = email;
    }

    public String getKompis(){
        return namn;
    }

    public String getData(){
        return "Namn: "+namn+", Mobilnummer: "+mobilnummer
                +", Födelsedag: "+födelsedag +", Email: "+email;
    }

}
