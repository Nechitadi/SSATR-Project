package exam;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Sensor {
    
    private int lastReadValue;

    public int getLastReadValue() {
        return lastReadValue;
    }

    public void setLastReadValue(int lastReadValue) {
        this.lastReadValue = lastReadValue;
    }
    
    public String readValue(){
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        
        return value;
    }
}
