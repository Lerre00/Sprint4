package Sprint4.Uppgifter.Övningsuppgift4b;

import java.io.IOException;
import java.net.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Reciever {
    Reciever()throws UnknownHostException, SocketException, IOException {
        String ip = "234.235.236.237";
        InetAddress adress = InetAddress.getByName(ip);
        int port = 2424;
        InetSocketAddress group = new InetSocketAddress(adress, port);
        NetworkInterface netInterface = NetworkInterface.getByName("wlan0");
        MulticastSocket socket = new MulticastSocket(port);
        socket.joinGroup(group, netInterface);

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
