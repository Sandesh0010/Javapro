import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame= new JFrame("MY TO DO");
       frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        
        JTextField textField=new JTextField(20);
        JButton addButton = new JButton("Add");
        JPanel panel=new JPanel();
        panel.add(textField);
        panel.add(addButton);
        frame.add(panel,BorderLayout.NORTH);

        DefaultTableModel tableModel= new DefaultTableModel(new Object[]
        {"ID","Task","Is Completed"},0);
        JTable table= new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(table);
        frame.add (scroll,BorderLayout.SOUTH);

        // tableModel.addRow(new Object[]{1,"Test","Completed"});
        // tableModel.addRow(new Object[]{2,"Test","Completed"});

        //all code here before set Visible
        frame.setVisible(true);
    }
}
