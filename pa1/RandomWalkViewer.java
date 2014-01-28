import javax.swing.JFrame;

public class RandomWalkViewer
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setTitle("RandomWalk!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int stepNum = 40;
        RandomWalkComponent component = new RandomWalkComponent(stepNum);
        frame.add(component);

        frame.setVisible(true);
    }
}