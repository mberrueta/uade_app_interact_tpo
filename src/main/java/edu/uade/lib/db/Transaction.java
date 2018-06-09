package edu.uade.lib.db;

import org.apache.log4j.Logger;

public class Transaction {
  static Logger log = Logger.getLogger(Transaction.class.getName());
  private static Transaction instance = null;

  private Transaction() {
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

  public Boolean begin() {
    // ResultSet result = DBConnection.getInstance().execute("SELECT * FROM test_table");
    //   while (result.next()) {
    //     System.out.println(result);
    //     log.debug(result);
    //   }
    return true;
  }
}
