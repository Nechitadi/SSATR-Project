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
    }
       
    public void switchHeatingAndCooling(int currentValue) {
        if (currentValue < roomSetTemperature) {
            heat(currentValue);
        } else {
            cool(currentValue);
        }
    }
    
    private void heat(Integer currentValue) {
        System.out.println("===A pornit incalzirea===");
        while(currentValue < roomSetTemperature) {
            currentValue++;         
            System.out.println("Temperatura a crescut la " + currentValue + CELSIUS_SYMBOL + "C");
        }
        System.out.println("Temperatura a ajuns la nivelul setat: " + roomSetTemperature + CELSIUS_SYMBOL + "C");
    }
    
    private void cool(Integer currentValue) {
        System.out.println("===A pornit sitemul de ventilatie===");
        while(currentValue > roomSetTemperature) {
            currentValue--;         
            System.out.println("Temperatura a scazut la " + currentValue + CELSIUS_SYMBOL + "C");
        }
        System.out.println("Temperatura a ajuns la nivelul setat: " + roomSetTemperature + CELSIUS_SYMBOL + "C");
    }
    
    private void addToHistoryOfTemperatures() {
        temperatureHistory.add(readTemperature);
        System.out.println("Istoricul temperaturilor citite: " + temperatureHistory.toString());
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
