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

    
    public Graph() {
        setTitle("Temperatures Graph");
        setSize(800, 800);
        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void paint(Graphics g) {
        g.drawLine(0, 400, 800, 400);
        
        initializeData();
        int pointOneX = 0;
        int pointOneY = 400;
        int pointTwoX = 20;
        int pointTwoY;
        
        for(int i=0; i<graphData.size(); i++) {
            System.out.println("Count is: " + graphData.get(i));
            int value = graphData.get(i);
           
            pointTwoY = 400 - value * 10;
            g.drawLine(pointOneX, pointOneY, pointTwoX, pointTwoY);
            g.fillOval(pointTwoX - 2, pointTwoY - 2, 4, 4);
            
            pointOneX += 20;
            pointOneY = pointTwoY;
            pointTwoX += 20;
        }
    }
    
    public void initializeData() {
        graphData.add(22);
        graphData.add(20);
        graphData.add(25);
        graphData.add(20);
        graphData.add(23);
        graphData.add(15);
        graphData.add(22);
        graphData.add(28);
        graphData.add(22);
        graphData.add(10);
        graphData.add(15);
       
        for (int i = 0; i <= 22; i++) {
            graphData.add(i);
        }
    }
    
    public static void main(String[] args) {
        Graph graphic = new Graph();
    }

    void paint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
