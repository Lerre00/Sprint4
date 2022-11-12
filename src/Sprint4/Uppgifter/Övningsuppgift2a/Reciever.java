package Sprint4.Uppgifter.Övningsuppgift2a;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Reciever {
    Reciever()throws UnknownHostException, SocketException, IOException {
        int minPort = 2424;
        DatagramSocket socket = new DatagramSocket(minPort);
        byte[] data = new byte[256];
        while(true){
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            System.out.println("Citat från: " + packet.getAddress().getHostAddress());
            String message = new String(packet.getData(), 0, packet.getLength());

            System.out.println(message);

        }
        //System.out.println("Done with task, exiting...");

    }

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException{
        Reciever recieve = new Reciever();
    }
}
