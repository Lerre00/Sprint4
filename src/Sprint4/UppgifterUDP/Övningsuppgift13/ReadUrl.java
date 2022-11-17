package Sprint4.UppgifterUDP.Övningsuppgift13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadUrl {
    ReadUrl() throws Exception {

        URL ord = new URL("https://github.com/dwyl/english-words/blob/master/words.txt?raw=true");
        BufferedReader in = new BufferedReader
                (new InputStreamReader(ord.openStream()));

        String line;
        int ordLängd = 0;
        String s = "";
        while((line = in.readLine()) != null) {

            ordLängd += line.length();
            //System.out.println(ordLängd);
            s+=ordLängd + ", ";
            ordLängd=0;
        }
        int chCount = 0;
        int count3 = 0;
        String[] parts = s.split(",");
        String s2 = "";

        for (int j = 0; j < 50; j++) {
            s2 = ""+count3;
            //System.out.println("test");
            for (int i = 0; i < parts.length; i++) {
                //System.out.println(parts[i]);
                if (parts[i].contains(s2)) { //fel
                    //System.out.println("you did it");
                    chCount++;
                }

            }
            System.out.println("antal bokstäver: " + count3 + "antal ord: " + chCount);
            chCount=0;
            s2 = "";
            count3++;
        }

        /*while((inputLine=in.readLine())!= null){
            System.out.println(counter + ". " + inputLine);
            counter++;
        }*/
        in.close();
    }
    public static void main(String[] args) throws Exception {
        ReadUrl url = new ReadUrl();
    }
}
