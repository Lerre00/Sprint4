package Sprint4.UppgifterTCP.Övningsuppgift5.Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class KompisServer {

    Database d = new Database();

    KompisServer(){

        int portNumber = 44444;

        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;
            String outputLine;

            out.println("Vilken kompis du slå upp i telfonboken?");

            while ((inputLine = in.readLine()) != null) {
                outputLine = d.getKompisData(inputLine.trim());
                if (outputLine == null){
                    out.println("Denna person fanns inte i databasen: "+inputLine);
                }
                else{
                    out.println(outputLine);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        KompisServer kompisK = new KompisServer();
    }
}
