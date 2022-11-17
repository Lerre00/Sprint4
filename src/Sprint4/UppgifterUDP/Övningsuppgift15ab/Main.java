package Sprint4.UppgifterUDP.Övningsuppgift15ab;

public class Main {
    Main() throws InterruptedException {

        NumberQueue<Integer> q = new NumberQueue<>();

        q.put(1);
        q.put(2);
        q.put(3);

        Integer firstTake = q.take();
        //Integer secondTake = q.take();
        System.out.println("size: "+ q.Size());

        Queue <String> q2 = new Queue<>();

        q2.put("test1");
        q2.put("test2");
        q2.put("test3");

        String StringTake = q2.take();
        System.out.println("size: "+ q2.Size());

        System.out.println("value of integer q: " +q.summary());

        System.out.println("value of indexes: " + q.indexNumber());

        NumberQueue <Number> q3 = new NumberQueue<>();
        q3.put(43273343L);
        q3.put(0.5);
        q3.put(12);

        System.out.println("value of integer q: " +q3.summary());

        System.out.println("value of indexes: " + q3.indexNumber());
    }
    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
    }
}
