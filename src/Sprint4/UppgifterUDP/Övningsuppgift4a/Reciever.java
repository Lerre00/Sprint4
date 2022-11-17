package Sprint4.UppgifterUDP.Övningsuppgift4a;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Reciever {
    Reciever()throws UnknownHostException, SocketException, IOException {
        int minPort = 2424;
        DatagramSocket socket = new DatagramSocket(minPort);
        byte[] data = new byte[256];



        while(true){
            LocalTime time = LocalTime.now();
            DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedTime = time.format(formatTime);
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            System.out.println(formattedTime);
            String message = new String(packet.getData(), 0, packet.getLength());

            System.out.println(message);

        }

    }

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException{
        Reciever recieve = new Reciever();
    }
}
