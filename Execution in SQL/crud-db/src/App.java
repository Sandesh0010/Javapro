//import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner  = new Scanner(System.in);
        //load the database driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //connection to database
        String url = "jdbc:mysql://localhost:3306/new";
        String username = "root";
        String password = "root";
         Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("Datebase connected ! Ready to work....");

        while(true){
        System.out.println("Hello, World!");
        System.out.println("Menu");
        System.out.println("-------------------");
        System.out.println("1: View all the Customers");
        System.out.println("2: Add new customers");
        System.out.println("3: update customers by id");
        System.out.println("4: Delete customers by id");
        int choice = scanner.nextInt();
        switch(choice)
        {
            case 1:
            //fetch from table customers
            String query = "SELECT  * FROM Customers";
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
            System.out.println(rs.getString("FirstName")+" "+rs.getString("CustomerID") +rs.getString("Email"));
            }
            

            case 2:
            System.out.println("Enter your first name ");
            String name= scanner.next();
            System.out.println("Enter your last name ");
            String Lastname= scanner.next();
            System.out.println("Enter your Email");
            String email=scanner.next();
            System.out.println("Enter your phone number");
            String phone= scanner.next();
            PreparedStatement preparedStatement = conn.prepareStatement("insert into Customers (FirstName,LastName,Email,phone) values (?,?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, Lastname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phone);
            preparedStatement.executeUpdate();
            System.out.println("Inserted into database");

            case 3:
            System.out.println("update customers by id");

            case 4:
            System.out.println("delete  customers by id");
 
         
            default:
            System.out.println("invalid choice!! please select ");
            
        }
    }


    }
}
