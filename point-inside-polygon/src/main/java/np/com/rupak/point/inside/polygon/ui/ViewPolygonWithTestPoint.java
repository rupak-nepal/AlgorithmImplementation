package np.com.rupak.point.inside.polygon.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import np.com.rupak.point.inside.polygon.point.Point;

/**
 *
 * @author rupak
 */
public class ViewPolygonWithTestPoint extends JFrame {

    public static ArrayList getPolygonPoints() {
        ArrayList<Point> list = new ArrayList<Point>();
        list.add(new Point(100, 1000));
        list.add(new Point(-3, 842));
        list.add(new Point(40, 444));
        list.add(new Point(600, 8));
        list.add(new Point(-100, 4));
        list.add(new Point(-500, 8));
        Point pSmallest = list.get(0);
        for(Point pp : list){
            if(pSmallest.getY() >= pp.getY())
                pSmallest = pp;
        }
        System.out.println("Smallest point is : "+ pSmallest.getX() + ","+ pSmallest.getY());
        
        
        return list;
    }

    private static Point getTestPoint() {
        Point testPoint = new Point(3, 3);
        return testPoint;
    }

    public ViewPolygonWithTestPoint() {
        super("Polygon with test point.");
        setSize(770, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    void drawLines(Graphics g) {//, Point[] polygonPoints, Point testPoint){
        Graphics2D gd = (Graphics2D) g;
        ArrayList<Point> points = new ArrayList<Point>();
        points = getPolygonPoints();
        Point testPoint = new Point(3, 3);
        
        
//        testPoint = getTestPoint();
        //arrange points in order to plot polygon.
        // but now draw as usual.
        for (int i = 0; i < 2; i++) {//Point p1 : points){
            gd.drawLine(points.get(i).getX(), points.get(i).getY(),
                    points.get(i + 1).getX(), points.get(i + 1).getY());
        }
//        System.out.println("--"+testPoint.getX());
//        gd.drawLine(testPoint.getX(), testPoint.getY(), testPoint.getX()+2, testPoint.getY());
         gd.drawLine(2, 200, 6, 119);

//        for(int i = 0; i< polygonPoints.length; i++)
//        gd.drawLine(polygonPoints[i].getX(), polygonPoints[i].getY(), WIDTH, WIDTH);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }

}
