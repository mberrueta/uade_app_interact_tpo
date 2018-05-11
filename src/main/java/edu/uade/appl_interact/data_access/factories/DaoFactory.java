package edu.uade.appl_interact.data_access.factories;

import edu.uade.appl_interact.data_access.dao.impl.Base;

public class DaoFactory {
  private static DaoFactory instance = null;

  private DaoFactory() {
  }

  public static DaoFactory getInstance() {
    if (instance == null) {
      instance = new DaoFactory();
    }
    return instance;
  }

  public <T extends Base> T getDaoFor(Object entity) throws Exception {
    String className = "edu.uade.appl_interact.data_access.dao.impl." + entity.getClass().getSimpleName() + "Dao";
    return (T) Class.forName(className).newInstance();
  }
}