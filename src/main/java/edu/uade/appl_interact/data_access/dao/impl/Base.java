package edu.uade.appl_interact.data_access.dao.impl;

import edu.uade.appl_interact.data_access.dao.GenericDao;
import edu.uade.lib.db.DBConnection;
import edu.uade.lib.db.PoolConnection;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class Base<T> implements GenericDao<T> {

  protected static final Logger log = Logger.getLogger("DAO");

  protected Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
  public abstract String getTableName();

  public abstract String getCreateQuery(T entity);

  public abstract String getUpdateQuery(T entity);

  public abstract T toObject(ResultSet resultSet) throws Exception;

  public T findById(Integer id) throws Exception {
    return findBy("id", id.toString());
  }

  public T findBy(String field, String value) throws Exception {
    if (value==null)
      return null;

    log.debug("Seeking " + getTableName() + " by " + field + ": " + value);
    ResultSet resultSet = getConnection().getResults(getFindByQuery(field, value));
    boolean any = resultSet.next();
    if (any)
      return toObject(resultSet);
    else
      return null;
  }

  public int create(T entity) throws Exception {
    log.debug("Creating a " + getTableName());
    return getConnection().execute(getCreateQuery(entity));
  }

  public int update(T entity) throws Exception {
    log.debug("Updating a " + getTableName());
    return getConnection().execute(getUpdateQuery(entity));
  }

  public void delete(Integer id) throws Exception {
    log.debug("Deleting a " + getTableName() + " by id:" + id);
    getConnection().execute(getDeleteQuery(id));
  }

  public List<T> findManyBy(String field, String value) throws Exception {
    log.debug("Seeking " + getTableName() + " by " + field + ": " + value);
    ResultSet resultSet = getConnection().getResults(getFindByQuery(field, value));
    List<T> list = new ArrayList<T>();
    while (resultSet.next()) {
      list.add(toObject(resultSet));
    }
    return list;
  }

  public List<T> findManyLike(String field, String value) throws Exception {
    log.debug("Seeking (using like)" + getTableName() + " by " + field + ": " + value);
    ResultSet resultSet = getConnection().getResults(getFindManyLikeQuery(field, value));
    List<T> list = new ArrayList<T>();
    while (resultSet.next()) {
      list.add(toObject(resultSet));
    }
    return list;
  }

  private String getFindByQuery(String field, String value) {
    return new StringBuilder("SELECT * FROM ")
              .append(getTableName())
              .append(String.format(" WHERE active = 1 AND %s = '%s' ", field, value))
              .toString();
  }


  private String getFindManyLikeQuery(String field, String value) {
    return getFindByQuery(field, String.format("%%%s%%", value)).replace("=", "LIKE");
  }

  private String getDeleteQuery(Integer value) {
    return new StringBuilder("UPDATE ")
               .append(getTableName())
               .append(" SET active = 0 ")
               .append(String.format(" WHERE ID = %d", value))
               .toString();
  }

  protected DBConnection getConnection() throws Exception {
      PoolConnection pool = PoolConnection.getIntance();
      return pool.getConnection();
  }

}
