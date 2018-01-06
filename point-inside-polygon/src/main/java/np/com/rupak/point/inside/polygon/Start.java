package np.com.rupak.point.inside.polygon;

import javax.swing.SwingUtilities;
import np.com.rupak.point.inside.polygon.ui.JavaGraphics;
import np.com.rupak.point.inside.polygon.util.AngleUtil;

/**
 *
 * @author rupak
 */
public class Start {

    public static void main(String[] args) {
        AngleUtil angleUtil = new AngleUtil();
        angleUtil.calculateAngleBetweenTestPointAndOtherPoints(
                AngleUtil.preparePolygonPoints(), AngleUtil.prepareTestPoint());
        
        System.out.println("now draw polygon with testpoint");
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JavaGraphics(AngleUtil.preparePolygonPoints(), AngleUtil.prepareTestPoint());
            }
        });
    }

}
