package np.com.rupak.point.inside.polygon;

import java.awt.List;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import np.com.rupak.point.inside.polygon.point.Point;
import np.com.rupak.point.inside.polygon.ui.ViewPolygonWithTestPoint;

/**
 *
 * @author rupak
 */
public class Start {

    public static void main(String[] args) {
        
        
        SwingUtilities.invokeLater(() -> {
            new ViewPolygonWithTestPoint().setVisible(true);
        });
    }

}
