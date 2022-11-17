package Sprint4.UppgifterTCP.Övningsuppgift1;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    int port = 44444;
    String output = "Hej svejs";

        public Server(){

            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);){

                while (true) {
                    out.println(output);
                    Thread.sleep(1000);
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