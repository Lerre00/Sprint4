package Sprint4.UppgifterTCP.Övningsuppgift6.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class KompisServer {

    Database d = new Database();

    KompisServer(){

        int portNumber = 44444;

        try (ServerSocket serverSocket = new ServerSocket(portNumber);
             Socket clientSocket = serverSocket.accept();
             ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());//ingen true?
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));)
        {
            String inputLine;
            Kompis outputLine;

            out.writeObject("Vilken kompis du slå upp i telfonboken?");

            while ((inputLine = in.readLine()) != null) {
                outputLine = d.getCarData(inputLine.trim());
                if (outputLine == null){
                    out.writeObject("Denna person fanns inte i databasen: "+inputLine);
                }
                else{
                    out.writeObject(outputLine);
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
