package exam;

import java.awt.Graphics;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

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
    boolean active = true;
    
 
    public SensorHandler(Socket s) {
        this.s = s;
    }
 
    public void run(){
        try {
            PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            
            while (active) {
                String line = in.readLine(); //asteapta mesaje de la client
                System.out.println("\nAm citit valoare de la senzor: \n" + line);
                out.println(performActions(line));       
            }
 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String performActions(String line) throws IOException {
        System.out.println("\n===Afisez date==");
        String responseFromHVAC;
        
        if (line.contains("T: ")) {
            String typedValue = line.replace("T: ", "");
            Integer temperatureFromSensor = Integer.parseInt(typedValue);
            hvac.setReadTemperature(temperatureFromSensor);
            responseFromHVAC = hvac.switchHeatingAndCooling(temperatureFromSensor);
            return responseFromHVAC;
        } else if (line.contains("SetT ")) {
            String typedValue = line.replace("SetT ", "");
            Integer roomSetTemperature = Integer.parseInt(typedValue);
            hvac.setRoomSetTemperature(roomSetTemperature);
            responseFromHVAC = "Temperatura a fost setata la: ";
            responseFromHVAC += hvac.getRoomSetTemperature() + hvac.CELSIUS_SYMBOL + "C";
            responseFromHVAC += "\nDONE";

            return responseFromHVAC;
        } else if (line.contains("H: ")) {
            String typedValue = line.replace("H: ", "");
            Integer humidityFromSensor = Integer.parseInt(typedValue);
            hvac.setReadHumidity(humidityFromSensor);
            responseFromHVAC = hvac.switchHumidifierDevice(humidityFromSensor);
            return responseFromHVAC;
        } else if (line.contains("SetH ")) {
            String typedValue = line.replace("SetH ", "");
            Integer roomSetHumidity = Integer.parseInt(typedValue);
            hvac.setRoomSetHumidity(roomSetHumidity);
            responseFromHVAC = "Humidatea dorita a fost setata la: ";
            responseFromHVAC += hvac.getRoomSetHumidity() + "%";
            responseFromHVAC += "\nDONE";

            return responseFromHVAC;
        } else if (line.contains("Inchide")) {
            System.out.println("Conexiunea senzorului a fost intrerupta!");
            s.close();
            active = false;
        } else if (line.contains("Grafic")) {
            String typedValues = line.replace("Grafic", "");
            
            StringTokenizer st = new StringTokenizer(typedValues, " ");               
            String graphType = st.nextToken();
            Integer graphScale = Integer.parseInt(st.nextToken());
            
            System.out.println("GR TYPE: " + graphType);
            System.out.println("GR SCLAE: " + graphScale);

            if (graphType.equals("T")) {
                Graph grafic = new Graph(hvac.temperatureHistory, graphType, graphScale);
            } else if (graphType.equals("H")) {
                Graph grafic = new Graph(hvac.humidityHistory, graphType, graphScale);
            }

            return "\nDONE";
        }
        
        else {
            return "Comandata inexistenta.\nDONE";
        }
        return null;
    }
    
}