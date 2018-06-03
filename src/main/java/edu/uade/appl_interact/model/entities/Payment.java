package edu.uade.appl_interact.model.entities;

import java.util.Date;

public class Payment {

    private Integer id;
    private Float amount;
    private User payer;
    private Integer payerId;
    private Date date;
    private Integer giftListId;

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float expectedAmountPercent() {
        return 0.0f;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

	public Integer getGiftListId() {
		return giftListId;
	}

	public void setGiftListId(Integer giftListId) {
		this.giftListId = giftListId;
	}

    public Integer getPayerId() {
        return payerId;
    }

    public void setPayer_id(Integer payerId) {
        this.payerId = payerId;
    }
}