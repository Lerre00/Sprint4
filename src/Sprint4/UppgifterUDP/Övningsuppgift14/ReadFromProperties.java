package Sprint4.UppgifterUDP.Övningsuppgift14;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadFromProperties extends JFrame{
    ReadFromProperties(){

        Properties p = new Properties();
        try{
            p.load(new FileInputStream("src/Sprint4/Uppgifter/Övningsuppgift14/settings.properties"));
        }
        catch(Exception e){
            System.out.println("Filen kunde inte hittas");
        }
        String mess = p.getProperty("message", "Hello");
        JLabel l = new JLabel(mess, JLabel.CENTER);
        add(l);
        l.setOpaque(true);
        String fName = p.getProperty("fontName", "Serif");
        String fStyle = p.getProperty("fontStyle", "PLAIN");
        int ifStyle;
        if (fStyle.equals("BOLD")){
            ifStyle = Font.BOLD;
        }
        else if(fStyle.equals("ITALIC")){
            ifStyle = Font.ITALIC;
        }
        else ifStyle = Font.PLAIN;

        int fSize = Integer.parseInt(p.getProperty("fontSize", "24"));
        l.setFont(new Font(fName, ifStyle, fSize));
        setSize(400,150);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        ReadFromProperties pRead = new ReadFromProperties();
    }
}
