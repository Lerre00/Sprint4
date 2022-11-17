package Sprint4.UppgifterTCP.Övningsuppgift10.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MultiUserKompisServer extends Thread{

    private Socket clientSocket;

    public MultiUserKompisServer(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
    }


    public void run() {

        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));)
        {
            String inputLine;

            Protokoll protocol = new Protokoll();
            out.println(protocol.processInput(null));

            while ((inputLine = in.readLine()) != null) {
                out.println(protocol.processInput(inputLine));
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
