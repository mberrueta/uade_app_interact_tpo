package edu.uade.appl_interact.data_access.dao.impl;

import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.appl_interact.model.entities.Subscription;
import edu.uade.appl_interact.model.entities.User;

import java.sql.ResultSet;

public class SubscriptionDao extends Base<Subscription> {

    private static SubscriptionDao instance;

    private SubscriptionDao() {
    }

    public static SubscriptionDao getInstance() {
        if (instance == null) {
            instance = new SubscriptionDao();
        }
        return instance;
    }


    @Override
    public String getTableName() {
        return "subscription";
    }

    @Override
    public String getCreateQuery(Subscription subscription) {
        StringBuilder builder = new StringBuilder("INSERT INTO subscription (user_id, active, gift_list_id) VALUES (")
                .append(String.format("'%s', ", subscription.getUser().getId()))
                .append(String.format("'%s', ", subscription.isActive() ? 1 : 0));
        return builder.toString();
    }

    @Override
    public String getUpdateQuery(Subscription entity) {
        StringBuilder builder = new StringBuilder("UPDATE subscription set ")
                .append(String.format("active = " + entity.isActive()) + " ")
                .append(String.format("WHERE id = " + entity.getId()));
        return builder.toString();
    }

    @Override
    public Subscription toObject(ResultSet resultSet) throws Exception {
        Subscription result = new Subscription();
        result.setId(resultSet.getInt("id"));
        result.setActive(resultSet.getBoolean("active"));
        return result;
    }


    public void saveSubscriptions(GiftList list) throws Exception {
        for (Subscription subscription : list.getGifters()) {
            StringBuilder builder  = new StringBuilder();
            if (subscription.getId() == null) {
                builder.append(getCreateQuery(subscription))
                        .append(String.format("'%s') ", list.getId()));
                getConnection().execute(builder.toString());
            } else {
                builder.append(getUpdateQuery(subscription))
                        .append(String.format("'%s') ", list.getId()));
                subscription.setId(getConnection().execute(builder.toString()));
            }
        }
    }

    public User getUser(Integer id) {
        //TODO: implement
        return null;
    }
}
