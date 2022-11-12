package Sprint4.Uppgifter.Övningsuppgift2a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;

public class Sender {
    Sender()throws UnknownHostException, SocketException, IOException, InterruptedException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        InetAddress toAdr = InetAddress.getLocalHost();//InetAddress.getByName("172.20.200.188");
        int toPort = 2424;
        DatagramSocket socket = new DatagramSocket();
        ArrayList <String> message = new ArrayList<>();
        message.add(0, "bra citat1");
        message.add(1,"bra citat2");
        message.add(2, "bra citat3");

        for(int i = 0; i <message.size(); i++){
            byte[] data = message.get(i).getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, toPort);
            socket.send(packet);
            Thread.sleep(5000);
        }
        System.exit(0);

    }

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException, InterruptedException{
        Sender send = new Sender();
    }
}
