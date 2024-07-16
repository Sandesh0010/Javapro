
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        String URL = "jdbc:mysql://localhost:3306/new";
        String db_user = "root";
        String db_password = "root";

        // loading the driver
       try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        // connecting to the database
       Connection conn =  DriverManager.getConnection(URL, db_user, db_password);
        System.out.println("Database connected!");

        // insert into database
        PreparedStatement preparedStatement = conn.prepareStatement("insert into users (Fname, email) values (?, ?)");
        preparedStatement.setString(1, "Aati");
        preparedStatement.setString(2, "Aati@gmail.com");
        preparedStatement.executeUpdate();
        System.out.println("Inserted into database");
       } catch (ClassNotFoundException | SQLException e) {
       }
    }
}
