import java.sql.*;
import java.util.Scanner;

public class DbConnection {
    public   static Connection connection;
    public   static Statement statement;
    public static ResultSet resultSet;

    static {
        try {
            String url = "jdbc:postgresql://floppy.db.elephantsql.com/wfnutumw";
            String database= "wfnutumw";
            String password = "lA0jRiDGKCozUBNZyrvCKr76BpP3HM8Q";
            connection = DriverManager.getConnection(url, database, password);
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