package edu.uade.appl_interact.data_access.dao.impl;

import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.appl_interact.model.entities.Subscription;

import java.sql.ResultSet;

public class SubscriptionDao extends Base<Subscription> {

    @Override
    public String getTableName() {
        return "subscription";
    }

    @Override
    public String getCreateQuery(Subscription entity) {
        return new StringBuilder("INSERT INTO subscription (user_id, active, payment_id) VALUES (")
                .append(String.format("'%s', ", entity.getUser().getId()))
                .append(String.format("1, "))
                .append(String.format("'%s')", String.valueOf(entity.getPaymentId())))
                .toString();
    }

    @Override
    public String getUpdateQuery(Subscription entity) {
        return "";
    }

    @Override
    public Subscription toObject(ResultSet resultSet) throws Exception {
        Subscription result = new Subscription();
        result.setId(resultSet.getInt("id"));
        result.setUserId(resultSet.getInt("user_id"));
        result.setPaymentId(resultSet.getInt("payment_id"));
        result.setActive(resultSet.getBoolean("active"));
        return result;
    }


//
//  public void createList(GiftList list) {
//    try {
//      list.setId(this.create(list));
//      saveSubscriptions(list);
//      saveSubsCriptionsRelation(list);
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//  }

    private void saveSubscriptionsRelation(GiftList list) throws Exception {
        StringBuilder builder = new StringBuilder("INSERT INTO gift_list_subscription (gift_list_id, subscription_id) VALUES (");
        int i = 0;
        for (Subscription subscription : list.getGifters()) {
            builder.append(String.format("'%s', ", list.getId()))
                    .append(String.format("'%s')", subscription.getId()));
            if (i < list.getGifters().size() - 1) {
                builder.append(",");
            } else {
                builder.append(";");
            }
            getConnection().execute(builder.toString());
        }


    }

    private void saveSubscriptions(GiftList list) throws Exception {
        for (Subscription subscription : list.getGifters()) {
            subscription.setId(getConnection().execute(getCreateQuery(subscription)));
        }
    }

}
