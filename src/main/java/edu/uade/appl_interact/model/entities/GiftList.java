package edu.uade.appl_interact.model.entities;

import java.util.Date;
import java.util.List;

public class GiftList extends Base {

  private String listName;
  private Date dueDate;
  private String toName;
  private String toMail;
  private ListAdmin owner;
  private Float expectedAmount;
  private List<Payment> payments;
  private List<Gifter> gifters;
  private Boolean delivered;

  public String getListName() {
    return listName;
  }

  public void setListName(String listName) {
    this.listName = listName;
  }

  public Date getDueDate() {
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

  public ListAdmin getOwner() {
    return owner;
  }

  public void setOwner(ListAdmin owner) {
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

  public List<Gifter> getGifters() {
    return gifters;
  }

  public void setGifters(List<Gifter> gifters) {
    this.gifters = gifters;
  }

  public Boolean getDelivered() {
    return delivered;
  }

  public void setDelivered(Boolean delivered) {
    this.delivered = delivered;
  }

  public Boolean archieved(){
    return false;
  }

  public Boolean collected(){
    return false;
  }

  public Float amountPerGifter(){
    return 0.0f;
  }
}