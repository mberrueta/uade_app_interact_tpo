package edu.uade.appl_interact.model.entities;

import java.util.Date;
import java.util.List;

import edu.uade.appl_interact.model.services.helpers.*;

public class GiftList extends PaymentObserver{

  private Integer id;
  private String listName;
  private Date dueDate;
  private String toName;
  private String toMail;
  private User owner;
  private Float expectedAmount = 0f;
  private Float currentAmount = 0f;
  private List<Payment> payments;
  private List<User> gifters;
  private Boolean delivered;

  public GiftList(String name, User user) {
}

public GiftList() {
}


public String getListName() {
    return listName;
  }

  public void setListName(String listName) {
    this.listName = listName;
  }

  public Date getDueDate() {
    if(dueDate == null)
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

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }

  public Float getExpectedAmount() {
    return expectedAmount;
  }

  public void setExpectedAmount(Float expectedAmount) {
    this.expectedAmount = expectedAmount;
  }

  public List<Payment> getPayments() {
    return payments;
  }

  public void setPayments(List<Payment> payments) {
    this.payments = payments;
  }

  public List<User> getGifters() {
    return gifters;
  }

  public void setGifters(List<User> gifters) {
    this.gifters = gifters;
  }

  public Boolean getDelivered() {
    return delivered;
  }

  public void setDelivered(Boolean delivered) {
    this.delivered = delivered;
  }

  public Boolean archieved() {
    return false;
  }

  public Boolean collected() {
    return false;
  }

  public Float amountPerGifter() {
    return 0.0f;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return the currentAmount
   */
  public Float getCurrentAmount() {
    return currentAmount;
  }

  /**
   * @param currentAmount the currentAmount to set
   */
  public void setCurrentAmount(Float currentAmount) {
    this.currentAmount = currentAmount;
  }

  @Override
  public void update() {
    addPayment(getObservable().getPayment());
  }

  public void addPayment(Payment payment) {
    getPayments().add(payment);
    currentAmount = currentAmount + payment.getAmount();
  }

}