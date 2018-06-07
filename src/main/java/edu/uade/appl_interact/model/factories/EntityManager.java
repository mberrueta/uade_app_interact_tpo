package edu.uade.appl_interact.model.factories;

import java.util.List;

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

  public <T> T find(Class<?> klass, Integer id) throws Exception {
    return (T) DaoFactory.getInstance().getDaoFor(klass.newInstance()).findById(id);
  }

  public <T> T findBy(Class<?> klass, String field, Integer value) throws Exception {
    return findBy(klass, field, value.toString());
  }

  public <T> T findBy(Class<?> klass, String field, String value) throws Exception {
    return (T) DaoFactory.getInstance().getDaoFor(klass.newInstance()).findBy(field, value);
  }

  public void create(Object object) throws Exception {
    DaoFactory.getInstance().getDaoFor(object).create(object);
  }

  public Boolean update(Object object) throws Exception {
    DaoFactory.getInstance().getDaoFor(object).update(object);
    return true;
  }

  public Boolean delete(Object object, Integer id) throws Exception {
    DaoFactory.getInstance().getDaoFor(object).delete(id);
    return true;
  }

  public <T> List<T> findManyBy(Class<?> klass, String field, Integer value) throws Exception {
    return findManyBy(klass, field, value.toString());
  }

  public <T> List<T> findManyBy(Class<?> klass, String field, String value) throws Exception {
    return DaoFactory.getInstance().getDaoFor(klass.newInstance()).findManyBy(field, value);
  }

  public <T> List<T> findManyLike(Class<?> klass, String field, Integer value) throws Exception {
    return findManyLike(klass, field, value.toString());
  }

  public <T> List<T> findManyLike(Class<?> klass, String field, String value) throws Exception {
    return DaoFactory.getInstance().getDaoFor(klass.newInstance()).findManyLike(field, value);
  }
}