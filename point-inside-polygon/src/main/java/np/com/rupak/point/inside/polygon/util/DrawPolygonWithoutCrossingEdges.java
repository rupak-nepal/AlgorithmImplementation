package np.com.rupak.point.inside.polygon.util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JFrame;
import np.com.rupak.point.inside.polygon.point.Point;

/**
 *
 * @author rupak
 */
public class DrawPolygonWithoutCrossingEdges extends JFrame {

    public static Point lowestPoint;
    public static ArrayList<Point> listOfPoint;
    public static Map<Point[], double[]> initialMap;
    public static Map<Point[], double[]> finalalMap;
    public static Point[] pointsOtherThanLowestPoint;
    public static double[] angleWithOtherPointsExceptLowestPoint;

    public ArrayList getLowestPoint(ArrayList<Point> list) {

        Point pLowest = list.get(0);
        for (Point pp : list) {
            if (pLowest.getY() >= pp.getY()) {
                pLowest = pp;
            }
        }
        lowestPoint.setX(pLowest.getX());
        lowestPoint.setY(pLowest.getY());
        System.out.println("Smallest point is : (" + pLowest.getX() + "," + pLowest.getY() + ")");
        int i = 0;
        for (Point pointt : list) {
            if (pointt.getX() == lowestPoint.getX()
                    && pointt.getY() == lowestPoint.getY()) {
                System.out.println("Equal case only once. ");
            } else {
                pointsOtherThanLowestPoint[i] = pointt;
                angleWithOtherPointsExceptLowestPoint[i]
                        = getAngleBetweenLowestPointAndTargetPoint(pointt);
                ++i;
            }
        }

        //getArrayOfAnles with otherpoints...
        for (int j = 0; j < pointsOtherThanLowestPoint.length; j++) {
            angleWithOtherPointsExceptLowestPoint[j]
                    = getAngleBetweenLowestPointAndTargetPoint(pointsOtherThanLowestPoint[j]);
        }
        initialMap.put(pointsOtherThanLowestPoint, angleWithOtherPointsExceptLowestPoint);

        //now sort the above map based on ascending order of angle.
//         pointsOtherThanLowestPoint[i] = pointt;
//                angleWithOtherPointsExceptLowestPoint[i] = 
//                    getAngleBetweenLowestPointAndTargetPoint(pointt);
//                ++i;
        return list;
    }

    public ArrayList<Point> preparePolygonPoints() {
        ArrayList<Point> list = new ArrayList<Point>();
        list.add(new Point(150, 150));
        list.add(new Point(250, 100));
        list.add(new Point(325, 125));
        list.add(new Point(375, 225));
        list.add(new Point(450, 250));
        list.add(new Point(275, 375));
        list.add(new Point(100, 300));

        return list;
    }

    private Point getTestPoint() {
        Point testPoint = new Point(3, 3);
        return testPoint;
    }

    public double getAngleBetweenLowestPointAndTargetPoint(Point p) {
        double angle = Math.atan(((p.getY() - lowestPoint.getY())
                / (p.getX() - lowestPoint.getX())));
        return angle;
    }

    public Map<Point[], double[]> getFinalMapOfOrderedPoint(Map<Point[], double[]> initialMap) {
        Map<Point[], double[]> orderedMap;
        Point[] orderedPoint;
        double [] orderedAngle;
        for(int k = 0; k<initialMap.keySet().size(); k++){
            
        }
        
//    double[] orderedAngles;
//    double angle = Math.atan(((p.getY() - lowestPoint.getY())
//            / (p.getX() - lowestPoint.getX())));
//    return angle ;
        return null;
    }

    public DrawPolygonWithoutCrossingEdges() {
        super("Polygon with test point.");
        setSize(770, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    void drawLines(Graphics g) {//, Point[] polygonPoints, Point testPoint){
        Graphics2D gd = (Graphics2D) g;
        ArrayList<Point> points = new ArrayList<Point>();
//        points = getPolygonPoints();
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
