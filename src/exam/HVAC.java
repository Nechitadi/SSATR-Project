package exam;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HVAC {
    
    private int roomSetTemperature = 22;
    private int ROOM_SET_HUMIDITY = 50;
    String CELSIUS_SYMBOL = Character.toString((char) '\u00B0');
    private int readTemperature;    
    private int readHumidity;
    private List<Integer> temperatureHistory = new ArrayList();

    public int getRoomSetTemperature() {
        return roomSetTemperature;
    }

    public void setRoomSetTemperature(int roomSetTemperature) {
        this.roomSetTemperature = roomSetTemperature;
        System.out.println("Temperatura a fost setata la: " + roomSetTemperature + CELSIUS_SYMBOL + "C");
    }
       
    public String switchHeatingAndCooling(int currentValue) {
        if (currentValue < roomSetTemperature) {
            return heat(currentValue);
        } else {
            return cool(currentValue);
        }
    }
    
    private String heat(Integer currentValue) {
        String result = "===A pornit incalzirea===\n";
        while(currentValue < roomSetTemperature) {
            currentValue++; 
            result += "Temperatura a crescut la " + currentValue.toString() + CELSIUS_SYMBOL + "C\n";
        }
        result += "Temperatura a ajuns la nivelul setat: ";
        result += String.valueOf(roomSetTemperature) + CELSIUS_SYMBOL + "C";
        result += "\nDONE";
        
        return result;
    }
    
    private String cool(Integer currentValue) {
        String result = "===A pornit sitemul de ventilatie===\n";
        while(currentValue > roomSetTemperature) {
            currentValue--;   
            result += "Temperatura a scazut la " + currentValue.toString() + CELSIUS_SYMBOL + "C\n";
        }
        result += "Temperatura a ajuns la nivelul setat: ";
        result += String.valueOf(roomSetTemperature) + CELSIUS_SYMBOL + "C";
        result += "\nDONE";  
        
        return result;
    }
    
    private void addToHistoryOfTemperatures() {
        temperatureHistory.add(readTemperature);
        System.out.println("Istoricul temperaturilor citite din incapere: " + temperatureHistory.toString());
    }
    
    public int getReadTemperature() {
        return readTemperature;
    }

    public void setReadTemperature(int readTemperature) {
        this.readTemperature = readTemperature;
        addToHistoryOfTemperatures();
    }

    public int getReadHumidity() {
        return readHumidity;
    }

    public void setReadHumidity(int readHumidity) {
        this.readHumidity = readHumidity;
    }        
}
