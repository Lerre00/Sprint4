package Sprint4.Demo.Demo1;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Reciever {

    Reciever()throws UnknownHostException, SocketException, IOException {
        int minPort = 2424;
        DatagramSocket socket = new DatagramSocket(minPort);
        byte[] data = new byte[256];
        while(true){
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            System.out.println("Meddelande från: " + packet.getAddress().getHostAddress());
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println(message);
        }

    }

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException{
        Reciever recieve = new Reciever();
    }

}
