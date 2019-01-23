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
    
    public int readValue(){
        Scanner sc = new Scanner(System.in);
        int value = Integer.parseInt(sc.nextLine());
        setLastReadValue(value);
        return value;
    }
}
