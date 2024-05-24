import javax.swing.*;
class Boxx{
    public static void main(String[] args)
    {
        Boxrender box =new Boxrender();

        JFrame f= new JFrame ("Box");
        f.add(box);
        f.setSize(500,500);
        f.setVisible (true);
    }
}