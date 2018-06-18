package edu.uade.appl_interact.model.entities;


import edu.uade.appl_interact.data_access.dao.impl.SubscriptionDao;

public class Subscription implements Persistible {
    private Integer id;
    private User user;
    private Payment payment;
    private boolean active;

    public Subscription() {
        active = true;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        if (user == null)
            user = SubscriptionDao.getInstance().getUser(id);
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }


    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
}
