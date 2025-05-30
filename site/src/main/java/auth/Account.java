package auth;

import database.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {
    private Integer id;
    private String name;

    public Account(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void register(String name, String password) throws SQLException {
        String sql = "INSERT INTO account(name, password) VALUES (?,?)";
        PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql);
        statement.setString(1,name);
        statement.setString(2,password);
        System.out.println(statement.executeUpdate());

    }
    public static Account getAccount(String name) throws SQLException {
        String sql = "SELECT id, name FROM account WHERE name = ?;";
        PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql);
        statement.setString(1,name);
        statement.execute();
        ResultSet result = statement.getResultSet();
        if(result.next() ){
          return new Account(
                  result.getInt("id"),
                  result.getString("name")
          );
        }
throw new IndexOutOfBoundsException();

    }
}
