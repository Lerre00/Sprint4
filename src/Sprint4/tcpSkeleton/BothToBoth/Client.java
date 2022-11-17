package Sprint4.tcpSkeleton.BothToBoth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    int port = 44444;
    String mess = "Hej svejs";

    Client() throws UnknownHostException {
        InetAddress ip = InetAddress.getByName("127.0.0.1");

        try(Socket sock = new Socket(ip, port); //kopplar upp sig
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()))
        ){

            String fromServer;

            while(true) {
                out.println(mess);
                fromServer = in.readLine();
                System.out.println(fromServer);
                Thread.sleep(3000);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws UnknownHostException {
        Client c = new Client();
    }
}
