import java.sql.*;
import java.util.Scanner;

public class DbConnection {
    public   static Connection connection;
    public   static Statement statement;
    public static ResultSet resultSet;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/superMarket","postgres","postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static String query;
    public static Scanner scanner = new Scanner(System.in);


}