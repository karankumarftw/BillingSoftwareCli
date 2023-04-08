package Core;

import java.sql.*;
import java.util.Scanner;

public class DbConnectionScannerAndFormatting {
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
    public static String[] unittypes = {"kg","l","packet","piece"};
    public static final String error = "\u001B[31m";
    public static final String successful = "\u001B[32m";
    public static final String title = "\u001B[34m";
    public static final String reset = "\u001B[0m";
    public static final String line = "\u001B[36m";


}