package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    static Connection conn;

    public synchronized static Connection getDBConnection(String dbName) {
        String host = "localhost";
        String port = "5432";
        String user = "postgres";
        String password = "123456";
        String dbUrl = "jdbc:postgresql://" + host + ":" + port + "/" + dbName + "?loggerLevel=OFF";

        try {
            conn = DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
