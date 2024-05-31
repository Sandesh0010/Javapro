import javax.swing.*;
public class Move{
    public static void main(String[] args) {
        JFrame frame=new JFrame("GAMELOOP");
        frame.setSize(500,500);
        frame.setResizable(false);
        //frame.setLocationRelativeTo(null);
        Gamepanel game= new Gamepanel();
        frame.add (game);
        game.StartGame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}