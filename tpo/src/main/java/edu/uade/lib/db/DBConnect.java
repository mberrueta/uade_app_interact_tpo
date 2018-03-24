package edu.uade.lib.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {
  private Connection connection;
  private Statement statement;
  private String db_url;
  private String db_user;
  private String db_pass;

  public DBConnect() throws ClassNotFoundException, SQLException {
      db_url = System.getenv("JDBC_DATABASE_URL");
      db_user = System.getenv("JDBC_DATABASE_USER");
      db_pass = System.getenv("JDBC_DATABASE_PASS");
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection(db_url, db_user, db_pass);
      statement = connection.createStatement();
  }

  public ResultSet execute(String query) {
    ResultSet result_set = null;
    try {
      result_set = statement.executeQuery(query);
    } catch (Exception e) {
      System.out.println(e);
    }
    return result_set;
  }

  public Connection getConnection() {
    return connection;
  }

  public void setConnection(Connection connection) {
    this.connection = connection;
  }

  public Statement getStatement() {
    return statement;
  }

  public void setStatement(Statement statement) {
    this.statement = statement;
  }
}