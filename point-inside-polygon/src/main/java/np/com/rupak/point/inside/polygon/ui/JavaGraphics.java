package np.com.rupak.point.inside.polygon.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import np.com.rupak.point.inside.polygon.point.Point;

/**
 *
 * @author rupak
 */
public class JavaGraphics {

    private JFrame mainMap;
    private Polygon poly;

    public JavaGraphics() {
    }

    public JavaGraphics(Point[] points, Point testPoint) {
        initComponents(points, testPoint);
    }

    private void initComponents(Point[] points, Point testPoint) {

        mainMap = new JFrame();
        mainMap.setResizable(false);
        mainMap.setTitle("Check wheather point is inside a polygon.");

        mainMap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//        int xPoly[] = {150, 250, -20, 325, 375, 450, 275, 100};
//        int yPoly[] = {150, 100, 500, 125, 225, 250, 375, 300};
        int xPoly[] = new int[points.length];
        int yPoly[] = new int[points.length];
        for (int k = 0; k < points.length; k++) {
            xPoly[k] = points[k].getX();
            yPoly[k] = points[k].getY();
        }

        poly = new Polygon(xPoly, yPoly, xPoly.length);
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLUE);
                g.drawPolygon(poly);
                g.drawString("::", testPoint.getX(), testPoint.getY());
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 600);
            }
        };
        mainMap.add(p);
        mainMap.pack();
        mainMap.setVisible(true);

    }

   
}
