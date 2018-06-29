package edu.uade.appl_interact.model.entities;


import edu.uade.appl_interact.data_access.dao.impl.GiftListDao;
import edu.uade.appl_interact.data_access.dao.impl.SubscriptionDao;
import edu.uade.appl_interact.observers.PaymentObserver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GiftList extends PaymentObserver {

    private Integer id;
    private String listName;
    private User owner;
    private Date dueDate;
    private String toName;
    private String toMail;
    private Float expectedAmount = 0f;
    private Float currentAmount = 0f;
    private List<Subscription> gifters;
    private Boolean delivered;

    public GiftList() {
        gifters = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public User getOwner() {
        if (owner == null) {
            owner = GiftListDao.getInstance().getOwner(id);
        }
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;

    }

    public Date getDueDate() {
        if (dueDate == null)
            return new Date();
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getToMail() {
        return toMail;
    }

    public void setToMail(String toMail) {
        this.toMail = toMail;
    }

    public Float getExpectedAmount() {
        return expectedAmount;
    }

    public void setExpectedAmount(Float expectedAmount) {
        this.expectedAmount = expectedAmount;
    }

    public Float getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Float currentAmount) {
        this.currentAmount = currentAmount;
    }

    public List<Subscription> getGifters() throws Exception {
        if (gifters.size() == 0) {
            gifters = SubscriptionDao.getInstance().findManyBy("gift_list_id", id.toString());
        }
        return gifters;
    }

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }

    public Boolean collected() {
        return expectedAmount <= currentAmount;
    }

    public Float amountPerGifter() throws Exception {
        if( getGifters().size() > 0)
            return expectedAmount / getGifters().size();
        else
            return expectedAmount;
    }

    public void addGifter(Subscription subscription) {
        gifters.add(subscription);
    }

    @Override
    public void update(Payment payment) throws Exception {
        this.currentAmount = currentAmount + payment.getAmount();
        GiftListDao.getInstance().update(this);
    }
}