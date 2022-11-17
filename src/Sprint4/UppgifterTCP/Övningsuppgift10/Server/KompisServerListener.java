package Sprint4.UppgifterTCP.Övningsuppgift10.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class KompisServerListener {

    KompisServerListener(){

        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(44444)) {
                final Socket socketToClient = serverSocket.accept();
                MultiUserKompisServer clientHandler = new MultiUserKompisServer(socketToClient);
                clientHandler.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws IOException {

        KompisServerListener serverListener = new KompisServerListener();

    }

}
