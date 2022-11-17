package Sprint4.UppgifterTCP.Övningsuppgift1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    int port = 44444;

    Client() throws IOException {
        InetAddress ip = InetAddress.getByName("127.0.0.1");


        try (Socket addressSocket = new Socket(ip, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(addressSocket.getInputStream()));){

            String temp = "";

            while ((temp = in.readLine()) != null) {
                System.out.println(temp);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws IOException {
        Client c = new Client();
    }
}

