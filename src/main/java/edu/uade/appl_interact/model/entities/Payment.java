package edu.uade.appl_interact.model.entities;

import java.util.Date;

public class Payment extends Base {

    private Float amount;
    private Gifter person;
    private Date date;

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Gifter getPerson() {
        return person;
    }

    public void setPerson(Gifter person) {
        this.person = person;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float expectedAmountPercent(){
        return 0.0f;
    }
}