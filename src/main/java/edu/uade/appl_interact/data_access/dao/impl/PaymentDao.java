package edu.uade.appl_interact.data_access.dao.impl;

import java.sql.ResultSet;

import edu.uade.appl_interact.model.entities.Payment;

public class PaymentDao extends Base<Payment> {

  @Override
  public String getTableName() {
    return "payments";
  }

  @Override
  public String getCreateQuery(Payment entity) {
    
    return new StringBuilder("INSERT INTO payments (amount, payer_id, date, gift_list_id) VALUES ( ")
          .append(String.format("'%s', ", entity.getAmount()))
          .append(String.format("'%s', ", entity.getPayerId()))
          .append(String.format("'%s', ", formatter.format(entity.getDate())))
          .append(String.format("'%s') ", entity.getGiftListId()))
          .toString();
        }
        
  @Override
  public String getUpdateQuery(Payment entity) {
    return new StringBuilder("UPDATE payments SET ")
          .append(String.format("amount = '%s', ", entity.getAmount()))
          .append(String.format("payer_id = '%s', ", entity.getPayerId()))
          .append(String.format("date = '%s', ", formatter.format(entity.getDate())))
          .append(String.format("gift_list_id = '%s' ", entity.getGiftListId()))
          .append(String.format("WHERE id = %d", entity.getId()))
          .toString();
  }

  @Override
  public Payment toObject(ResultSet resultSet) throws Exception {
    Payment result = new Payment();
    result.setId(resultSet.getInt("id"));
    result.setAmount(resultSet.getFloat("amount"));
    result.setDate(resultSet.getDate("date"));
    result.setGiftListId(resultSet.getInt("gift_list_id"));
    result.setPayer_id(resultSet.getInt("payer_id"));
    // result.setEmail(resultSet.getString("email"));
    return result;
  }
}
