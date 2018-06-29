package edu.uade.appl_interact.data_access.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.uade.appl_interact.model.entities.GiftList;
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
        Integer ownerId = 0;
        if(entity.getOwner() != null)
            ownerId = entity.getOwner().getId();

        return new StringBuilder("INSERT INTO gift_list (list_name, due_date, to_name, to_mail, owner_id, expected_amount) VALUES ( ")
                .append(String.format("'%s', ", entity.getListName()))
                .append(String.format("'%s', ", formatter.format(entity.getDueDate())))
                .append(String.format("'%s', ", entity.getToName()))
                .append(String.format("'%s', ", entity.getToMail()))
                .append(String.format("'%s', ", ownerId))
                .append(String.format("'%s')", entity.getExpectedAmount()))
                .toString();
    }

    @Override
    public String getUpdateQuery(GiftList entity) {
        return new StringBuilder("UPDATE gift_list SET ")
                .append(String.format("list_name = '%s', ", entity.getListName()))
                .append(String.format("due_date = '%s', ", formatter.format(entity.getDueDate())))
                .append(String.format("to_name = '%s', ", entity.getToName()))
                .append(String.format("to_mail = '%s' ,", entity.getToMail()))
                .append(String.format("expected_amount = %s ", entity.getExpectedAmount()))
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
        result.setExpectedAmount(resultSet.getFloat("expected_amount"));
        //TODO: nested object result.setOwner(resultSet.getString("to_mail"));
        return result;
    }

    public List<GiftList> getListWhereUserSubscribed(int userId) {
        ArrayList<GiftList> result = new ArrayList<>();
        StringBuilder query = new StringBuilder("Select * from gift_list ")
                .append("JOIN subscription ON (gift_list.id = subscription.gift_list_id)")
                .append(" WHERE subscription.user_id = " + userId)
                .append( " AND subscription.active = 1");
        try {
            ResultSet resultSet = getConnection().getResults(query.toString());
            while (resultSet.next()) {
                result.add(toObject(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    public void createList(GiftList list) {
        try {
            list.setId(this.create(list));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("createList", e);
        }
    }

    public User getOwner(Integer id) {
        //TODO: implement
        return null;
    }
}
