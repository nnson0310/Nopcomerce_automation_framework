package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    static Connection conn;

    /**
     * Create a connection to database (default using PostgresSql)
     * Change dbUrl variable when using another sql database
     * @param dbName name of database
     * @return connection to database URL
     * @author Son
     */
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
