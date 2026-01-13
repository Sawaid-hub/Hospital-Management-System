package DbConfig;

import java.util.Properties;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSetup {

    private static Properties properties = new Properties();

    // Static block to load the JDBC driver and properties
    static {
        try {
            properties.load(DbSetup.class.getClassLoader().getResourceAsStream("db.properties"));
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            throw new RuntimeException("Error initializing database configuration", e);
        }
    }

    // Method to get a database connection
    public static Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                properties.getProperty("db.url"),
                properties.getProperty("db.user"),
                properties.getProperty("db.password")
            );
        } catch (SQLException e) {
            throw new SQLException("Error connecting to the database", e);
        }
        return con;
    }

    // Method to close a database connection
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
