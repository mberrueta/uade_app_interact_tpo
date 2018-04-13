package edu.uade.appl_interact.model.factories;

import java.util.List;

import edu.uade.appl_interact.model.entities.Base;
import edu.uade.appl_interact.data_access.factories.DaoFactory;

public class EntityManager {
  private static EntityManager instance = null;

  private EntityManager() {
  }

  public static EntityManager getInstance() {
    if (instance == null) {
      instance = new EntityManager();
    }
    return instance;
  }

  public <T extends Base> T find(Class<?> klass, Integer id) throws Exception {
    return (T) DaoFactory.getInstance().getDaoFor((Base) klass.newInstance()).findById(id);
  }

  public <T extends Base> T findBy(Class<?> klass, String field, String value) throws Exception {
    return (T) DaoFactory.getInstance().getDaoFor((Base) klass.newInstance()).findBy(field, value);
  }

  public Boolean create(Base object) throws Exception {
    DaoFactory.getInstance().getDaoFor(object).create(object);
    return true;
  }

  public Boolean update(Base object) throws Exception {
    DaoFactory.getInstance().getDaoFor(object).update(object);
    return true;
  }

  public Boolean delete(Base object) throws Exception {
    DaoFactory.getInstance().getDaoFor(object).delete(object.getId());
    return true;
  }

  public <T extends Base> List<T> findManyBy(Class<?> klass, String field, String value) throws Exception {
    return DaoFactory.getInstance().getDaoFor((Base) klass.newInstance()).findManyBy(field, value);
  }

  public <T extends Base> List<T> findManyLike(Class<?> klass, String field, String value) throws Exception {
    return DaoFactory.getInstance().getDaoFor((Base) klass.newInstance()).findManyLike(field, value);
  }
}