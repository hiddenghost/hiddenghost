// Name: Shijie Xu
// USC loginid: 6203324841
// CS 455 PA1
// Spring 2014
import java.awt.geom.Point2D;
import java.util.Random;

/**
   Drunkard class
       Represents a "drunkard" doing a random walk on a grid.
*/
public class Drunkard {

    /**
       Creates drunkard with given starting location and distance
       moved in a single step.
       @param startLoc starting location of drunkard
       @param theStepSize size of one step in the random walk
    */
    // Set some default values.
    private ImPoint startPoint = new ImPoint(200, 200);
    private ImPoint currentPoint;
    private int stepSize = 10;

    public Drunkard(ImPoint startLoc, int theStepSize) {
      startPoint = startLoc;
      currentPoint = startLoc;
      stepSize = theStepSize;
    }


    /**
       Takes a step of length step-size (see constructor) in one of
       the four compass directions.  Changes the current location of the
       drunkard.
       0: go up
       1: go right
       2: go down
       3: go left
    */
    public void takeStep() {
      Random randomNo = new Random();
      int directions = randomNo.nextInt(4);
      //System.out.println(directions);
      switch(directions)
      {
        case 0: currentPoint = startPoint.translate(0, -stepSize);
                System.out.println("Go up!");
                break;
        case 1: currentPoint = startPoint.translate(stepSize, 0);
                System.out.println("Turn right!");
                break;
        case 2: currentPoint = startPoint.translate(0, stepSize);
                System.out.println("Go Down!");
                break;
        case 3: currentPoint = startPoint.translate(-stepSize, 0);
                System.out.println("Turn left!");
                break;
      }
      startPoint = currentPoint;
    }


    /**
       gets the current location of the drunkard.
       @return an ImPoint object representing drunkard's current location
    */
    public ImPoint getCurrentLoc() {
	return currentPoint;  // REMOVE this line -- dummy code to get it to compile
    }

}
