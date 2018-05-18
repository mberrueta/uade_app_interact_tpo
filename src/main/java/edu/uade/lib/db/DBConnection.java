package edu.uade.lib.db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.log4j.Logger;

public class DBConnection {

  static final Logger log = Logger.getLogger("DBConnection");
  private static DBConnection instance;
  private final DataSource dataSource;
  private Connection connection;


  public DBConnection() throws Exception {
    dataSource = getDatasSource();
    connection = dataSource.getConnection();
  }


  public void close() {
      try {
          connection.close();
      } catch (Exception e) {
          System.out.println("Mensaje Error: " + e.getMessage());
      }

  }

  public ResultSet execute(String query) throws Exception {
    log.debug(String.format("Executing '%s'", query));
    ResultSet result_set = null;
    Statement statement = getAStatement();
    if (query.contains("SELECT")){
      result_set = statement.executeQuery(query);
    }
    else
    {
      statement.executeUpdate(query);
    }
    return result_set;
  }

  private Statement getAStatement() throws Exception {
    return connection.createStatement();
  }

  private DataSource getDatasSource() throws Exception {
    Properties props = new Properties();
    FileInputStream fis = null;
    MysqlDataSource mysqlDS = null;
    fis = new FileInputStream(".properties");
    props.load(fis);
    mysqlDS = new MysqlDataSource();
    mysqlDS.setURL(props.getProperty("JDBC_DATABASE_URL"));
    mysqlDS.setUser(props.getProperty("JDBC_DATABASE_USER"));
    mysqlDS.setPassword(props.getProperty("JDBC_DATABASE_PASS"));
    return mysqlDS;
  }
}
