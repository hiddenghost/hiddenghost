import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;

public class RandomWalkComponent extends JComponent
{
    private int stepNumOfDrunkard;

    public RandomWalkComponent(int stepNum)
    {
        stepNumOfDrunkard = stepNum;
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        ImPoint startLoc = new ImPoint(200, 200);
        int stepSize = 5;
        Drunkard drunkard = new Drunkard(startLoc, stepSize);
        
        ImPoint currentPoint = drunkard.getCurrentLoc();
        ImPoint nextPoint = currentPoint;
        Point2D from = currentPoint.getPoint2D();
        Point2D to = from;

        Line2D.Double segment = new Line2D.Double(from, to);

        for (int i=0; i<stepNumOfDrunkard; i++)
        {
            System.out.println("************* Current Steps: " + (i + 1) + " *************");
            drunkard.takeStep();
            nextPoint = drunkard.getCurrentLoc();
            to = nextPoint.getPoint2D();
            segment = new Line2D.Double(from, to);
            g2.draw(segment);

            currentPoint = nextPoint;
            from = to;
        }
    }
}