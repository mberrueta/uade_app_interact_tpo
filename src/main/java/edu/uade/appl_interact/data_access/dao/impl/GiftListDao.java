package edu.uade.appl_interact.data_access.dao.impl;

import java.sql.ResultSet;

import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.appl_interact.model.entities.Subscription;
import edu.uade.appl_interact.model.entities.User;

public class GiftListDao extends Base<GiftList> {
    private static GiftListDao instance;

    private GiftListDao() {
    }

    public static GiftListDao getInstance() {
        if (instance == null) {
            instance = new GiftListDao();
        }
        return instance;
    }

    @Override
    public String getTableName() {
        return "gift_list";
    }

    @Override
    public String getCreateQuery(GiftList entity) {
        return new StringBuilder("INSERT INTO gift_list (list_name, due_date, to_name, to_mail, owner_id) VALUES ( ")
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
        return new StringBuilder("UPDATE gift_list SET ")
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

//    private String getSubscriptionCreationQuery(Subscription subscription) {
//        StringBuilder builder = new StringBuilder("INSERT INTO subscription (user_id, payment_id) VALUES (")
//                .append(String.format("'%s', ", subscription.getUser().getId()));
//
//        if (subscription.getPayment() != null) {
//            builder.append(String.format("'%s')", String.valueOf(subscription.getPayment().getId())));
//        } else {
//            builder.append(" NULL)");
//        }
//
//        return builder.toString();
//    }


    public void createList(GiftList list) {
        try {
            list.setId(this.create(list));
            saveSubscriptions(list);
            saveSubsCriptionsRelation(list);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("createList", e);
        }
    }

    private void saveSubsCriptionsRelation(GiftList list) throws Exception {
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
            subscription.setId(getConnection().execute(SubscriptionDao.getInstance().getCreateQuery(subscription)));
        }
    }

    public User getOwner(Integer id) {
        //TODO: implement
        return null;
    }
}
