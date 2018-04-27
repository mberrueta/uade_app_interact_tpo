package edu.uade.appl_interact.data_access.dao.impl;

import java.sql.ResultSet;

import edu.uade.appl_interact.model.entities.GiftList;

public class GifListDao extends Base<GiftList> {

  @Override
  public String getTableName() {
    return "users";
  }

  @Override
  public String getCreateQuery(GiftList entity) {
    return new StringBuilder("INSERT INTO users (list_name) VALUES ")
          .append(String.format("('%s')", entity.getListName()))
          .toString();
        }
        
  @Override
  public String getUpdateQuery(GiftList entity) {
    return new StringBuilder("UPDATE users SET ")
          .append(String.format("list_name = '%s' ", entity.getListName()))
          .append(String.format("WHERE id = %d", entity.getId()))
          .toString();
  }

  @Override
  public GiftList toObject(ResultSet resultSet) throws Exception {
    GiftList result = new GiftList();
    result.setId(resultSet.getInt("id"));
    result.setListName(resultSet.getString("list_name"));
    return result;
  }
}
