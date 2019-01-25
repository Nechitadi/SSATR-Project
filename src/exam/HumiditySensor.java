package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class HumiditySensor extends Sensor {

    @Override
    public String readValue() {
        return super.readValue();
    }
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        TemperatureSensor sensor = new TemperatureSensor();
        
        System.out.println("Senzorul de umiditate se conecteaza la server...");
        Socket s = new Socket("localhost",1888);
        System.out.println("Conexiune cu succes!");
        System.out.println("Comenzi acceptate:");
        System.out.println("H: <valoarea> (Prentru a trimite o valoare citita catre server)");
        System.out.println("SetH <valoarea> (Pentru a seta umiditate dorita in incapere)");
        System.out.println("GraficH <scara> (Pentru a crea graficul umiditatilor citite pana in prezent, la scara dorita)");
 
        PrintWriter k = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
        BufferedReader y = new BufferedReader(new InputStreamReader(s.getInputStream()));
        
        while(true){
            System.out.println("\nIntroduceti valoarea umiditatii:");
            k.println(sensor.readValue());
            
            String responseFromServer;
            while((responseFromServer = y.readLine()) != null) {
                if (responseFromServer.equals("DONE")) {
                    break;
                }
                Thread.sleep(1000);
                System.out.println(responseFromServer);
            }
        }
    }
}
