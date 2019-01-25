package exam;

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class Graph extends JFrame {
    
    private List<Integer> graphData = new ArrayList();
    private String dataType;
    private int scale;

    public Graph(List<Integer> data, String dataType, int scale) {
        this.scale = scale;
        this.dataType = dataType;
        this.graphData = data;
        
        if (dataType.equals("T")) setTitle("Temperatures Graph");
        if (dataType.equals("H")) setTitle("Humidities Graph");
        setSize(800, 450);
        setVisible(true);
    }
    
    public void paint(Graphics g) {
        int pointOneX = 0;
        int pointOneY = 400;
        int pointTwoX = 20;
        int pointTwoY;
        
        System.out.println("Desenez graficul " + dataType);
        
        // Axa 0
        g.drawLine(0, 400, 800, 400);
        g.drawLine(800, 400, 795, 405);
        g.drawLine(800, 400, 795, 395);
        
        // Unitatea de masura
        g.setColor(Color.red);
        if (dataType.equals("T")) g.drawString("0°C", 760, 415);
        if (dataType.equals("H")) g.drawString("0%", 780, 415);
        g.setColor(Color.black);
        
        // Axe la -5, 5, 10, 15, 20, 25 grade celsius;
        
        if (dataType.equals("T")) {
            int ax = 0;
            int ay = 400 + 5 * scale;
            int bx = 800;
            int by = 400 + 5 * scale;
            
            g.setColor(Color.red);
            g.drawString("-5°C", bx - 40, by + 15);
            
            g.setColor(Color.lightGray);
            g.drawLine(ax, ay, bx, by);
            
            // Axe pt fiecare grad
            Color veryLightGray = new Color(220,220,220);
            g.setColor(veryLightGray);

            for (int i = 1; i <= 25; i++) {
                ax = 0;
                ay = 400 - i * scale;
                bx = 800;
                by = 400 - i * scale;
                
                g.drawLine(ax, ay, bx, by);
            }
            
            for (int i = 5; i <= 25; i+=5) {
                ax = 0;
                ay = 400 - i * scale;
                bx = 800;
                by = 400 - i * scale;
                
                g.setColor(Color.red);
                g.drawString(i + "°C", bx - 40, by - 3);
                g.setColor(Color.lightGray);
                g.drawLine(ax, ay, bx, by);
            }
        } else if (dataType.equals("H")) {
            int ax = 0;
            int ay = 400 + 5 * scale;
            int bx = 800;
            int by = 400 + 5 * scale;
            
            g.setColor(Color.lightGray);
            
            for (int i = 5; i <= 100; i+=5) {
                ax = 0;
                ay = 400 - i * scale;
                bx = 800;
                by = 400 - i * scale;
                
                g.setColor(Color.red);
                g.drawString(i + "%", bx - 30, by - 3);
                g.setColor(Color.lightGray);
                g.drawLine(ax, ay, bx, by);
            }
        }
        
        g.setColor(Color.black);
        
        // Datele citite 
        
        for(int i = 0; i < graphData.size(); i++) {
            int value = graphData.get(i);
           
            pointTwoY = 400 - value * scale; //pt T foloseste 10, pt H foloseste 5
            g.drawLine(pointOneX, pointOneY, pointTwoX, pointTwoY);
            g.fillOval(pointTwoX - 2, pointTwoY - 2, 4, 4);
            
            pointOneX += 20;
            pointOneY = pointTwoY;
            pointTwoX += 20;
        }
    }
    
//    public static void main(String[] args) {
//        List<Integer> graphMockedData = new ArrayList();
////        graphMockedData.add(22);
////        graphMockedData.add(20);
////        graphMockedData.add(25);
////        graphMockedData.add(20);
////        graphMockedData.add(23);
////        graphMockedData.add(15);
////        graphMockedData.add(22);
////        graphMockedData.add(28);
////        graphMockedData.add(22);
////        graphMockedData.add(10);
////        graphMockedData.add(15);
//
////        graphMockedData.add(50);
////        graphMockedData.add(70);
////        graphMockedData.add(40);
////        graphMockedData.add(34);
////        graphMockedData.add(46);
////        graphMockedData.add(59);
////        graphMockedData.add(34);
////        graphMockedData.add(50);
////        graphMockedData.add(20);
////        graphMockedData.add(0);
////        graphMockedData.add(100);
//
//        Graph graphic = new Graph(graphMockedData, "T", 10);
//    }

    void paint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
