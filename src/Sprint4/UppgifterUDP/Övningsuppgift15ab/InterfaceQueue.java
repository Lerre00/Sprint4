package Sprint4.UppgifterUDP.Övningsuppgift15ab;

public interface InterfaceQueue<T> {

    public void put(T t);
    public T take();
    public int Size();

}
