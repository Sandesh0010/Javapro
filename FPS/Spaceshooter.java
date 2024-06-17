import javax.swing.JFrame;

class Spaceshooter 
{
    public static void main(String arg[])
    { 
        JFrame f=new JFrame();
        f.setResizable(false);//to make unresizble
        Gamepanel panel =new Gamepanel();
        f.add(panel);
        panel.StartGame();
        //  f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,500);
        f.setVisible(true);
    }

}