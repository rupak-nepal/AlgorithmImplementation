package np.com.rupak.point.inside.polygon.util;

import np.com.rupak.point.inside.polygon.ui.JavaGraphics;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import np.com.rupak.point.inside.polygon.point.Point;

/**
 *
 * @author rupak
 */
public class AngleUtil {

    public static Point startingPoint;
    public static int polygonSize;
    public static double totalAngle;
    public static Point testPoint;

    public void calculateAngleBetweenTestPointAndOtherPoints(Point[] points, Point checkPoint) {
        testPoint = checkPoint;
        startingPoint = points[0];
        polygonSize = points.length;
        System.out.println("size : "+polygonSize);
        double []angles = new double[7];
        double angle;
        for (int i = 0; i < points.length; i++) {
            System.out.println("index ::: " + i);
            if (i == polygonSize-1) {
                
                System.out.println(" *** exception conditin ***");
                angle = getAngleInDegreeWithTestPoint(points[i], startingPoint);
                System.out.println("Last side angle :"+angle);
//                totalAngle += angle;
            } else {
                System.out.println(" *** normal conditin ***");
                angle = getAngleInDegreeWithTestPoint(points[i], points[i + 1]);
                System.out.println("normal angle :"+angle);
//                totalAngle =+ normalAngle;
            }
            
            angles[i] = angle;

        }
        
        for(int k = 0; k<angles.length; k++){
            System.out.println("angle : "+angles[k]);
            totalAngle += angles[k];
        }
        System.out.println("Total angle in radian is :" + totalAngle);
        System.out.println("Total angle in degrees is :" + Math.toDegrees(totalAngle));
        System.out.println("Total angle in degrees with rouding is :" +
                Math.round(Math.toDegrees(totalAngle)));
        totalAngle = Math.round(Math.toDegrees(totalAngle));
        if (Math.round(totalAngle) == 360) {
            System.out.println("Test Point is inside Polygon");
        } else {
            System.out.println("Test Point is outside Polygon");
        }
    }

    public static double getAngleInDegreeWithTestPoint(Point initalPoint, Point finalPoint) {
        int vectorFirstXComponent = initalPoint.getX() - testPoint.getX();
        int vectorFirstYComponent = initalPoint.getY() - testPoint.getY();
        int vectorSecondXComponent = finalPoint.getX() - testPoint.getX();
        int vectorSecondYComponent = finalPoint.getY() - testPoint.getY();
        double angle;
        double dotProduct = (vectorFirstXComponent * vectorSecondXComponent)
                + (vectorFirstYComponent * vectorSecondYComponent);
        double magnitudeOfFirstVector = Math.sqrt(
                (Math.pow(vectorFirstXComponent, 2) + Math.pow(vectorFirstYComponent, 2))
        );
        double magnitudeOfSecondVector = Math.sqrt(
                (Math.pow(vectorSecondXComponent, 2) + Math.pow(vectorSecondYComponent, 2))
        );
        angle = Math.acos(
                (dotProduct / (magnitudeOfFirstVector * magnitudeOfSecondVector))
        );
//        angle = Math.round(
//        Math.toDegrees(Math.acos(
//                (dotProduct / (magnitudeOfFirstVector * magnitudeOfSecondVector))
//        )));
//        System.out.println("degree angle :"+an);
//        System.out.println("radean angle :"+angle);
        return angle;
    }

    public static Point[] preparePolygonPoints() {

        ArrayList<Point> list = new ArrayList<Point>();
        list.add(new Point(150, 150));
        list.add(new Point(250, 100));
        list.add(new Point(325, 125));
        list.add(new Point(375, 225));
        list.add(new Point(450, 250));
        list.add(new Point(275, 375));
        list.add(new Point(100, 300));

        Point[] points = list.toArray(new Point[list.size()]);

        return points;
    }

    public static Point prepareTestPoint() {
        Point checkPoint = new Point(300,30);//170, 200);//
        return checkPoint;
    }

}
