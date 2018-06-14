package edu.uade.lib.db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import javax.xml.transform.Result;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.log4j.Logger;

public class DBConnection {

  private static final Logger log = Logger.getLogger("DBConnection");
  private static DBConnection instance;
  private final DataSource dataSource;
  private Connection connection;


  public DBConnection() throws Exception {
    this.dataSource = getDataSource();
    this.connection = dataSource.getConnection();
  }


  public void close() {
      try {
          connection.close();
      } catch (Exception e) {
          System.out.println("Mensaje Error: " + e.getMessage());
      }
  }


  public ResultSet getResults(String query)  throws Exception {
    log.debug(String.format("Executing '%s'", query));
    ResultSet result_set = null;
    Statement statement = getAStatement();
    return statement.executeQuery(query);
  }

  public int  execute(String query) throws Exception {
      log.debug(String.format("Executing '%s'", query));
      PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
      statement.executeUpdate();
       ResultSet keys = statement.getGeneratedKeys();
      if(keys.next()) {
        int key = keys.getInt(1);
        return key;
      }
      return 0;
  }

  private Statement getAStatement() throws Exception {
    return connection.createStatement();
  }

  private DataSource getDataSource() throws Exception {
    Properties props = new Properties();
    FileInputStream fis = null;
    MysqlDataSource mysqlDS = null;

    fis = new FileInputStream("resources/db.properties");
    props.load(fis);
    mysqlDS = new MysqlDataSource();
    mysqlDS.setURL(props.getProperty("jdbc.url"));
    mysqlDS.setUser(props.getProperty("jdbc.username"));
    mysqlDS.setPassword(props.getProperty("jdbc.password"));
    return mysqlDS;
  }
}
