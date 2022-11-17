package Sprint4.Demo.TCPdemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    int port = 44444;
    String ack = "message recieved";
    String hej = "Hej och välkommen";

    Server(){

        try(ServerSocket servS = new ServerSocket(port);
            Socket sock = servS.accept();
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()))
        ){

            String temp = "";

            out.println(hej);

            while((temp = in.readLine())!= null){
                System.out.println(temp);
                out.println(ack + " " + temp);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        Server s = new Server();

    }

}
