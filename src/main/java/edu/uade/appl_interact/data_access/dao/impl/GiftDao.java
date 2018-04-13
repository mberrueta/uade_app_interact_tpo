package edu.uade.appl_interact.data_access.dao.impl;

import java.sql.ResultSet;

import edu.uade.appl_interact.model.entities.Gift;

public class GiftDao extends Base<Gift> {

  @Override
  public String getTableName() {
    return "gifts";
  }

  @Override
  public String getCreateQuery(Gift entity) {
    return new StringBuilder("INSERT INTO Gifts (name) VALUES ")
          // .append(String.format("('%s')", entity.getName()))
          .toString();
        }
        
  @Override
  public String getUpdateQuery(Gift entity) {
    return new StringBuilder("UPDATE Gifts SET ")
          // .append(String.format("name = '%s' ", entity.getName()))
          .append(String.format("WHERE id = %d", entity.getId()))
          .toString();
  }

  @Override
  public Gift toObject(ResultSet resultSet) throws Exception {
    Gift result = new Gift();
    result.setId(resultSet.getInt("id"));
    // result.setName(resultSet.getString("name"));
    return result;
  }
}



// id INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
//   percent FLOAT(8,2) NOT NULL DEFAULT 0,
//   product_id INT(8) NOT NULL,
//   from_person_id INT(8) NOT NULL,
//   gift_list_id INT(8) NOT NULL,
  