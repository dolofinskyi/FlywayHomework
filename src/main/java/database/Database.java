package database;

import prefs.Prefs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final Database instance = new Database();
    private Connection connection;

    private Database() {

    }

    public static Database getInstance() {
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()){
                String connectionUrl = new Prefs().getString(Prefs.JDBC_CONNECTION_URL);
                connection = DriverManager.getConnection(connectionUrl);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

}
