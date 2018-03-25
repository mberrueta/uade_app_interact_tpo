package edu.uade.lib.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class Transaction {
  static Logger log = Logger.getLogger(Transaction.class.getName());
  private static Transaction instance = null;

  protected Transaction() {
  }

  public static Transaction getInstance() {
    if (instance == null) {
      instance = new Transaction();
    }
    return instance;
  }

  public Boolean commit() {
    return true;
  }

  public Boolean rollback() {
    return true;
  }

  public Boolean begin() throws SQLException, ClassNotFoundException {
    ResultSet result = new DBConnect().execute("SELECT * FROM test_table");
      while (result.next()) {
        System.out.println(result);
        log.debug(result);
      }
    return true;
  }
}