package edu.uade.appl_interact.model.factories;

import edu.uade.appl_interact.model.dao.impl.Base;

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

  public <T extends Base> T getDaoFor(edu.uade.appl_interact.model.entities.Base entity) throws Exception {
    String className = "edu.uade.appl_interact.model.dao.impl." + entity.getClass().getSimpleName() + "Dao";
    return (T) Class.forName(className).newInstance();
  }
}