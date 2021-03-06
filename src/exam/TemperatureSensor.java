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
public class TemperatureSensor extends Sensor {

    @Override
    public String readValue() {
        return super.readValue();
    }
    
    public int celsiusToFarenheit(int celsiusValue) {
        return celsiusValue * 5;
    }
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        TemperatureSensor sensor = new TemperatureSensor();
        
        System.out.println("Senzorul de temperatura se conecteaza la server...");
        Socket s = new Socket("localhost",1888);
        System.out.println("Senzorul s-a conectat la server!");
        System.out.println("Comenzi acceptate:");
        System.out.println("T: <valoarea> (Prentru a trimite o valoare citita catre server)");
        System.out.println("SetT <valoarea> (Pentru a seta temperatura dorita in incapere)");
        System.out.println("GraficT <scara> (Pentru a crea graficul temperaturilor citite pana in prezent, la scara dorita)");

        PrintWriter k = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
        BufferedReader y = new BufferedReader(new InputStreamReader(s.getInputStream()));
        
        while(true){
            System.out.println("\n=== Introduceti valoare sau comanda ===");
            k.println(sensor.readValue());
            
            String responseFromServer;
            while((responseFromServer = y.readLine()) != null) {
                if (responseFromServer.equals("DONE")) {
                    break;
                }
                Thread.sleep(000);
                System.out.println(responseFromServer);
            }
        }
    }
}
