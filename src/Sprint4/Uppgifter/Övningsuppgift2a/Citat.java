package Sprint4.Uppgifter.Övningsuppgift2a;

public class Citat extends Thread{
    private String braCitat;
    private double interval;

    public Citat(String braCitat){
        this.braCitat = braCitat;
        this.interval = 5000;
    }

    @Override
    public void run()  {
        while (!Thread.interrupted()){
            try {
                Thread.sleep(Math.round(5000));
                System.out.println(braCitat);
            }
            catch (InterruptedException e){
                break;
            }
        }

    }
}
