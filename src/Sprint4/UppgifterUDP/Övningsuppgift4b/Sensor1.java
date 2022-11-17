package Sprint4.UppgifterUDP.Övningsuppgift4b;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Sensor1 {
    Sensor1()throws UnknownHostException, SocketException, IOException {

        String temp = "";
        String message = "";
        String city = "";
        String ip = "234.235.236.237";
        InetAddress adress = InetAddress.getByName(ip);
        int port = 2424;
        InetSocketAddress group = new InetSocketAddress(adress, port);
        NetworkInterface netInterface = NetworkInterface.getByName("0");
        Scanner sc = new Scanner(System.in);
        System.out.println("Vilken stad?");
        city = sc.next();
        MulticastSocket socket = new MulticastSocket(port);
        socket.joinGroup(group, netInterface);
        System.out.println("Temperatur? ");
        while(sc.hasNext()){
            temp = sc.next();
            message = city+": "+temp+" grader";
            byte[] data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, adress, port);
            socket.send(packet);
            System.out.println("Temperatur? ");
        }
    }

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        Sensor1 main = new Sensor1();
    }
}
