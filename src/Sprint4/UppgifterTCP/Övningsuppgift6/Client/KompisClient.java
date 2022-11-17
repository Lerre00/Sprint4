package Sprint4.UppgifterTCP.Övningsuppgift6.Client;

import Sprint4.UppgifterTCP.Övningsuppgift6.Server.Kompis;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class KompisClient {

    KompisClient() throws IOException{
            String hostName = "127.0.0.1";
            int portNumber = 44444;

            try (Socket addressSocket = new Socket(hostName, portNumber);
                 PrintWriter out = new PrintWriter(addressSocket.getOutputStream(),true);
                 ObjectInputStream in = new ObjectInputStream(addressSocket.getInputStream());
                 BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));)
            {
                Object fromServer;
                String fromUser;

                while ((fromServer = in.readObject()) != null) {

                    if (fromServer instanceof String) {
                        System.out.println("Server: " + fromServer);
                    }
                    else if (fromServer instanceof Kompis) {
                        System.out.println("Server: " + ((Kompis) fromServer).getData());
                    }

                    fromUser = stdIn.readLine();
                    if (fromUser != null) {
                        out.println(fromUser);
                    }
                }
            }
            catch (UnknownHostException e) {
                System.err.println("Don't know about host " + hostName);
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection to " +
                        hostName);
                System.exit(1);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


    }

    public static void main(String[] args) throws IOException {
        KompisClient kompisC = new KompisClient();
    }
}
