import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    static Connection connection;
    static JFrame frame;
    static JTextField textField;
    static JButton addButton;
    static DefaultTableModel tableModel;

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/my-tod";
        String username = "root";
        String password = "root";
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("connected");

        frame = new JFrame("MY TO DO");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        textField = new JTextField(20);
        addButton = new JButton("Add");
        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(addButton);
        frame.add(panel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[] { "ID", "Task", "Is Completed" }, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(table);
        frame.add(scroll, BorderLayout.SOUTH);
        loadData();
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addData();

            }

        });

        // String query ="SELECT * FROM datas";
        // Statement statement= connection.createStatement();
        // statement.executeQuery(query);
        // ResultSet rows=statement.executeQuery(query);
        // while (rows.next()){
        // tableModel.addRow(new Object[]{rows.getInt("ID"),
        // rows.getString("Task"),rows.getString("completed")});

        // }

        // tableModel.addRow(new Object[]{1,"Test","Completed"});
        // tableModel.addRow(new Object[]{2,"Test","Completed"});

        // all code here before set Visible
        frame.setVisible(true);
    }

    private static void loadData() {

        String query = "SELECT * FROM datas";
        Statement statement;
        try {
            statement = connection.createStatement();
            // statement.executeQuery(query);
            ResultSet rows = statement.executeQuery(query);
            tableModel.setRowCount(0);
            while (rows.next()) {
                tableModel.addRow(
                        new Object[] { rows.getInt("ID"), rows.getString("Task"), rows.getString("completed") });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void addData() {
        try {
            String input = textField.getText();
            if (input.equals("")) {
                return;
            }
            PreparedStatement statement = connection.prepareStatement("INSERT INTO datas(Task)values(?)");
            statement.setString(1, textField.getText());
            statement.executeUpdate();
            textField.setText("");
            loadData();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

    }

}
