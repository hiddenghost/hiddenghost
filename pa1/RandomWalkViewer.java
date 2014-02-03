import javax.swing.JFrame;
import java.util.Scanner;


public class RandomWalkViewer
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setTitle("RandomWalk!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        System.out.print("Enter number of steps: ");
        //int stepNum = 200;
        int stepNum = in.nextInt();
        while(stepNum<=0)
        {
            System.out.println("ERROR: Number entered must be greater than 0.");
            System.out.print("Enter number of steps: ");
            stepNum = in.nextInt();
        }
        RandomWalkComponent component = new RandomWalkComponent(stepNum);
        frame.add(component);

        frame.setVisible(true);
    }
}