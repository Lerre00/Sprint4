package Sprint4.Demo.Demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Queue {
    Queue()throws UnknownHostException, SocketException, IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        InetAddress toAdr = InetAddress.getLocalHost();
        int toPort = 2424;
        DatagramSocket socket = new DatagramSocket();
        String message;
        System.out.println("Vad vill du fråga?");
        while((message = in.readLine()) != null){

            byte[] data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, toPort);
            socket.send(packet);
            System.out.println("Vad vill du fråga?");

        }
        System.exit(0);

    }

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException{
        Queue main = new Queue();
    }
}
