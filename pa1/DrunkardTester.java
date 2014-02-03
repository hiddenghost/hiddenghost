/**
   DrunkardTester     
       console-based test program for Drunkard class.
       Uses hard-coded data, prints expected and actual output.

    author: Shijie Xu

   Note: "private static" methods below are how we define helper
   functions for other static functions.  Need to be static because
   main is static.  Don't need to be public because they are only
   ever called by main (not from outside the class).
*/

public class DrunkardTester
{
    public static void main(String[] args)
    {
        ImPoint loc = new ImPoint(0, 0);
        int theStepSize = 10;
        System.out.println("Drunkard is expected to start at " + loc);
        System.out.println("The step size is expected to be " + theStepSize);
        drunkardTest(loc, theStepSize);
        
        loc = new ImPoint(100, 82);
        theStepSize = 20;
        System.out.println("Drunkard is expected to start at " + loc);
        System.out.println("The step size is expected to be " + theStepSize);
        drunkardTest(loc, theStepSize);
        
        loc = new ImPoint(50, 60);
        theStepSize = 30;
        System.out.println("Drunkard is expected to start at " + loc);
        System.out.println("The step size is expected to be " + theStepSize);
        drunkardTest(loc, theStepSize);
        /*
        int theStepSize = 10;
        ImPoint loc = new ImPoint(0, 0);
        Drunkard drunkard = new Drunkard(loc, 10);
        for (int i=0; i<30; i++)
        {
            drunkard.takeStep();
            System.out.println(drunkard.getCurrentLoc());
        }*/
    }

    public static void drunkardTest(ImPoint startLoc, int theStepSize)
    {
        Drunkard drunkard = new Drunkard(startLoc, theStepSize);

        System.out.println("Testing with ImPoint=" + startLoc + " theStepSize=" + theStepSize);
        System.out.println("Testing getCurrentLoc...");
        
        ImPoint formerStep = drunkard.getCurrentLoc();
        System.out.println("The current Location is: " + formerStep);
        
        System.out.println("Testing takeStep...");
        System.out.println("The Drunkard will take 5 steps.");
        for (int i=0; i<5; i++)
        {
            drunkard.takeStep();
            ImPoint nextStep = drunkard.getCurrentLoc();
            System.out.println("Take valid step from " + formerStep + " to " + nextStep + ".");
            formerStep = nextStep;
        }
        System.out.println();
    }
}