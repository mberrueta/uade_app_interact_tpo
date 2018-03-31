package edu.uade.appl_interact.model.dao.impl;

import java.sql.ResultSet;

import edu.uade.appl_interact.model.entities.User;

public class UserDao extends Base<User> {

  @Override
  public String getTableName() {
    return "users";
  }

  @Override
  public String getCreateQuery(User entity) {
    return new StringBuilder("INSERT INTO users (name) VALUES ")
          .append(String.format("('%s')", entity.getName()))
          .toString();
        }
        
  @Override
  public String getUpdateQuery(User entity) {
    return new StringBuilder("UPDATE users SET ")
          .append(String.format("name = '%s' ", entity.getName()))
          .append(String.format("WHERE id = %d", entity.getId()))
          .toString();
  }

  @Override
  public User toObject(ResultSet resultSet) throws Exception {
    User result = new User();
    result.setId(resultSet.getInt("id"));
    result.setName(resultSet.getString("name"));
    return result;
  }
}
