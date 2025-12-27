package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/cine";
    private static final String USER = "root";
    private static final String PASSWORD = "B23070161";

    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error en la conexion con la base de datos");
        }
    }

    public static DatabaseConnection getInstance() {
        try {
            if (instance == null || instance.getConnection().isClosed()) {
                instance = new DatabaseConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}