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
    
    public static void main(String[] args) throws IOException {
        
        TemperatureSensor sensor = new TemperatureSensor();
        
        System.out.println("Senzorul se conecteaza la server...");
        Socket s = new Socket("localhost",1888);
        System.out.println("Senzorul s-a conectat la server!");
 
        PrintWriter k = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
        BufferedReader y = new BufferedReader(new InputStreamReader(s.getInputStream()));
 
        while(true){
            System.out.println("Introduceti valoarea temperaturii:");
            k.println(sensor.readValue());
        }
    }
    
}
