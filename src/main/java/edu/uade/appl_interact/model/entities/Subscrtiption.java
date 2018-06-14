package edu.uade.appl_interact.model.entities;

public class Subscrtiption {
    private int id;
    private User user;
    private Payment payment;
    private boolean active;

    public Subscrtiption(User user) {
        this.user = user;
        active = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getPaymentId() {
        if (payment != null) {
            return payment.getId();
        } else {
            return  null;
        }
    }
}
