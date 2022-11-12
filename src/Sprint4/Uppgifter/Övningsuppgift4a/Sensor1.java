package Sprint4.Uppgifter.Övningsuppgift4a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Sensor1 {
    Sensor1()throws UnknownHostException, SocketException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        InetAddress toAdr = InetAddress.getLocalHost();
        int toPort = 2424;
        DatagramSocket socket = new DatagramSocket();
        String message;
        String city;
        String temp;
        System.out.println("Vilken stad?");
        city = in.readLine();
        while(true){
            System.out.println("temperatur?");
            temp = in.readLine();
            message = city+": "+temp+" grader";
            byte[] data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, toPort);
            socket.send(packet);
        }
        //System.exit(0);

}

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        Sensor1 main = new Sensor1();
    }
}
