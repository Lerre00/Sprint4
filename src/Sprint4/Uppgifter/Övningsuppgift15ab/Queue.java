package Sprint4.Uppgifter.Övningsuppgift15ab;

import java.util.LinkedList;
import java.util.List;

public class Queue <T> implements InterfaceQueue<T> {

    private List<T> l = new LinkedList<>();

    public Queue (){}

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
