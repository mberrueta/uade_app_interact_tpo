package edu.uade.appl_interact.data_access.dao.impl;

import java.sql.ResultSet;

import edu.uade.appl_interact.model.entities.Payment;

public class PaymentDao extends Base<Payment> {

  @Override
  public String getTableName() {
    return "payment";
  }

  @Override
  public String getCreateQuery(Payment entity) {
    
    return new StringBuilder("INSERT INTO payment (amount, date) VALUES ( ")
          .append(String.format("'%s', ", entity.getAmount()))
          .append(String.format("'%s') ", formatter.format(entity.getDate())))
          .toString();
        }
        
  @Override
  public String getUpdateQuery(Payment entity) {
    return new StringBuilder("UPDATE payment SET ")
          .append(String.format("amount = '%s', ", entity.getAmount()))
          .append(String.format("date = '%s' ", formatter.format(entity.getDate())))
          .append(String.format("WHERE id = %d", entity.getId()))
          .toString();
  }

  @Override
  public Payment toObject(ResultSet resultSet) throws Exception {
    Payment result = new Payment();
    result.setId(resultSet.getInt("id"));
    result.setAmount(resultSet.getFloat("amount"));
    result.setDate(resultSet.getDate("date"));
    // result.setEmail(resultSet.getString("email"));
    return result;
  }
}
