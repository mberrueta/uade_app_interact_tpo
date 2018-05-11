package edu.uade.appl_interact.data_access.dao.impl;

import java.sql.ResultSet;
import java.text.Format;
import java.text.SimpleDateFormat;

import edu.uade.appl_interact.model.entities.GiftList;

public class GiftListDao extends Base<GiftList> {

  @Override
  public String getTableName() {
    return "gift_lists";
  }

  @Override
  public String getCreateQuery(GiftList entity) {
    Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    return new StringBuilder("INSERT INTO gift_lists (list_name, due_date, to_name, to_mail, owner_id) VALUES ( ")
          .append(String.format("'%s', ", entity.getListName()))
          .append(String.format("'%s', ", formatter.format(entity.getDueDate())))
          .append(String.format("'%s', ", entity.getToName()))
          .append(String.format("'%s', ", entity.getToMail()))
          // .append(String.format("'%s')", entity.getOwner().getId()))
          .append(String.format("'%s')", 1))
          .toString();
        }
        
  @Override
  public String getUpdateQuery(GiftList entity) {
    Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return new StringBuilder("UPDATE gift_lists SET ")
          .append(String.format("list_name = '%s', ", entity.getListName()))
          .append(String.format("due_date = '%s', ", formatter.format(entity.getDueDate())))
          .append(String.format("to_name = '%s', ", entity.getToName()))
          .append(String.format("to_mail = '%s' ", entity.getToMail()))
          // .append(String.format("to_mail = '%s' ", entity.getOwner().getId()))
          .append(String.format("WHERE id = %d", entity.getId()))
          .toString();
  }

  @Override
  public GiftList toObject(ResultSet resultSet) throws Exception {
    GiftList result = new GiftList();
    result.setId(resultSet.getInt("id"));
    result.setListName(resultSet.getString("list_name"));
    result.setDueDate(resultSet.getDate("due_date"));
    result.setToName(resultSet.getString("to_name"));
    result.setToMail(resultSet.getString("to_mail"));
    //TODO: nested object result.setOwner(resultSet.getString("to_mail"));
    return result;
  }
}
