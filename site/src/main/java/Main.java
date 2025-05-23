import database.DatabaseConnection;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection connection = new DatabaseConnection();
        try {
            connection.connect("database.sql");
            System.out.println(set(connection,"abc","pass2"));
            get(connection);
            connection.disconnect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void get(DatabaseConnection connection) throws SQLException {
        String sql = "SELECT * FROM account;";
        PreparedStatement statement = connection.getConnection().prepareStatement(sql);
        System.out.println(statement.execute());
        ResultSet result = statement.getResultSet();
        while(result.next()){
            System.out.println(result.getString("name"));
            System.out.println(result.getString("password"));
        }
    }

    public static int set(DatabaseConnection connection, String name, String password) throws SQLException {
        String sql = "INSERT INTO account(name, password) VALUES (?,?)";
        PreparedStatement statement = connection.getConnection().prepareStatement(sql);
        statement.setString(1,name);
        statement.setString(2,password);
        System.out.println(statement.executeUpdate());
        ResultSet result = statement.getGeneratedKeys();
        if(result.next()){
            return result.getInt(1);
        }else {
            return -1;
        }
    }
}
