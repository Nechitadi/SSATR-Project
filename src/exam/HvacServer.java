package exam;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class HvacServer {
 
    public static void main(String[] args) throws IOException {
        ArrayList<SensorHandler> list = new ArrayList<>();
        ServerSocket ss = new ServerSocket(1888);
        
        while(true) {
            System.out.println("Astept valori de la senzori...");
            
            Socket s = ss.accept();
            SensorHandler handler = new SensorHandler(s);
            list.add(handler);
            handler.start();
          }
    }
}

class SensorHandler extends Thread{
    Socket s;
    HVAC hvac = new HVAC();
 
    public SensorHandler(Socket s) {
        this.s = s;
    }
 
    public void run(){
        try {
            PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            
            while (true) {
                String line = in.readLine(); //asteapta mesaje de la client
                System.out.println("\nAm citit valoare de la senzor: \n" + line);
                displayData(line);       
            }
 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void displayData(String line) {
        System.out.println("\n===Afisez date===\n");
        
        if (line.contains("T: ")) {
            String typedValue = line.replace("T: ", "");
            Integer temperatureFromSensor = Integer.parseInt(typedValue);
            hvac.setReadTemperature(temperatureFromSensor);
            hvac.switchHeatingAndCooling(temperatureFromSensor);
        } else if (line.contains("SetT ")) {
            String typedValue = line.replace("SetT ", "");
            Integer roomSetTemperature = Integer.parseInt(typedValue);
            hvac.setRoomSetTemperature(roomSetTemperature);
            System.out.println(
                "Temperatura a fost setata la: " + 
                hvac.getRoomSetTemperature() +
                hvac.CELSIUS_SYMBOL + "C"
            );
        }
    }
    
}