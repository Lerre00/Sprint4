package Sprint4.UppgifterUDP.Övningsuppgift15ab;

import java.util.ArrayList;
import java.util.List;

public class NumberQueue <T extends Number> implements InterfaceQueue<T>{
    private List<T> l = new ArrayList<>();

    /*public double sum() {
        double sum = 0.0;
        for (T t : l){
            sum += t.doubleValue();
        }
        return sum;
    }*/

    public String indexNumber() {
        int counter = 0;
        T temp;
        String test = "";
        for (T t : l){
            temp = l.get(counter);
            test += "index[" + counter + "]:" +  temp + ", ";
            counter++;
        }
        return test;
    }
    public int summary() {
        int counter = 0;
        String s = "";
        T temp;
        int i = 0;
        for (T t : l){
            temp = l.get(counter);
            s += temp;
            i += Integer.parseInt(s);
            s = "";
            counter++;
        }
        return i;
    }
    public int Size(){
        return l.size();
    }

    public void put(T t){
        l.add(t);
    }

    public T take(){
        while(l.isEmpty()){
            try{ wait(); }
            catch(InterruptedException e){ return null;}
        }
        T temp = l.get(0);
        l.remove(0);
        return temp;
    }
}
