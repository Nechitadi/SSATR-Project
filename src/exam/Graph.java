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
        setTitle("Temperatures Graph");
        setSize(800, 600);
        setVisible(true);
    }
    
    public void paint(Graphics g) {
        System.out.println("Painting " + dataType + " Graph");
        g.drawLine(0, 400, 800, 400);
        
        int pointOneX = 0;
        int pointOneY = 400;
        int pointTwoX = 20;
        int pointTwoY;
        
        for(int i=0; i<graphData.size(); i++) {
            int value = graphData.get(i);
           
            pointTwoY = 400 - value * scale; //for T use 10, for H use 5
            g.drawLine(pointOneX, pointOneY, pointTwoX, pointTwoY);
            g.fillOval(pointTwoX - 2, pointTwoY - 2, 4, 4);
            
            pointOneX += 20;
            pointOneY = pointTwoY;
            pointTwoX += 20;
        }
    }
    
//    public void initializeData() {
//        graphData.add(22);
//        graphData.add(20);
//        graphData.add(25);
//        graphData.add(20);
//        graphData.add(23);
//        graphData.add(15);
//        graphData.add(22);
//        graphData.add(28);
//        graphData.add(22);
//        graphData.add(10);
//        graphData.add(15);
//       
//        for (int i = 0; i <= 22; i++) {
//            graphData.add(i);
//        }
//    }
    
//    public static void main(String[] args) {
//        Graph graphic = new Graph();
//    }

    void paint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
