import javax.swing.JFrame;

public class Frame{
    public static void main(String[] args) {
        JFrame frame=new JFrame("Main Panel");
        Gamepanel boxes=new Gamepanel();
        frame.add(boxes);
        boxes.StartGame();
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}