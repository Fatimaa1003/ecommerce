import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class DatabaseUtil {
    private static Connection connection;

    static {
        try {
            Properties props = new Properties();
            InputStream in = DatabaseUtil.class.getClassLoader().getResourceAsStream("db.properties");
            props.load(in);
            String url = props.getProperty("db.url");
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");

            connection = DriverManager.getConnection(url, username, password);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
