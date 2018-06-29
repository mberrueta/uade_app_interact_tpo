package edu.uade.appl_interact.data_access.dao.impl;

import edu.uade.appl_interact.model.entities.Payment;
import edu.uade.appl_interact.model.entities.Subscription;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentDao extends Base<Payment> {

  private static PaymentDao instance;

  private PaymentDao() {
  }

  public static PaymentDao getInstance() {
    if (instance == null) {
      instance = new PaymentDao();
    }
    return instance;
  }

  @Override
  public String getTableName() {
    return "payment";
  }

  @Override
  public String getCreateQuery(Payment entity) {
    
    return new StringBuilder("INSERT INTO payment (subscription_id, amount, date) VALUES ( ")
          .append(String.format("'%s', ", entity.getSubscriptionId()))
          .append(String.format("'%s', ", entity.getAmount()))
          .append(String.format("'%s') ", formatter.format(entity.getDate())))
          .toString();
        }
        
  @Override
  public String getUpdateQuery(Payment entity) {
    return new StringBuilder("UPDATE payment SET ")
          .append(String.format("subscription_id = '%s', ", entity.getSubscriptionId()))
          .append(String.format("amount = '%s', ", entity.getAmount()))
          .append(String.format("date = '%s' ", formatter.format(entity.getDate())))
          .append(String.format("WHERE id = %d", entity.getId()))
          .toString();
  }

  @Override
  public Payment toObject(ResultSet resultSet) throws Exception {
    Payment result = new Payment();
    result.setId(resultSet.getInt("id"));
    result.setSubscriptionId(resultSet.getInt("subscription_id"));
    result.setAmount(resultSet.getFloat("amount"));
    result.setDate(resultSet.getDate("date"));
    // result.setEmail(resultSet.getString("email"));
    return result;
  }

  public ArrayList<Payment> fromUserId(int id) {
    ArrayList<Payment> userPayments = new ArrayList<>();
    StringBuilder query = new StringBuilder("SELECT * FROM payment JOIN subscription ON (payment.subscription_id = subscription.id)")
            .append("WHERE subscription.user_id = " +id);
    try {
      ResultSet result = getConnection().getResults(query.toString());
      while (result.next()) {
        userPayments.add(toObject(result));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return userPayments;
  }
}
