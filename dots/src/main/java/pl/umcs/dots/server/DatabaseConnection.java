package pl.umcs.dots.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DatabaseConnection {
    private static Map<String, Connection> connections = new HashMap<>();

    public static Connection getConnection() {
        return connections.get("");
    }

    public void connect(String path) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:"+path);
        connections.put("", connection);
    }
    public void disconnect() throws SQLException {
        connections.get("").close();
        connections.remove("");
    }
}
