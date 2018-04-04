package edu.uade.appl_interact.model.entities;

import java.util.Date;
import java.util.List;

public class GiftList extends Base {

  private String listName;
  private Date dueDate;
  private Person to;
  private List<Product> wishList;
  private List<Gift> gifts;

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

  public Person getTo() {
    return to;
  }

  public void setTo(Person to) {
    this.to = to;
  }

  public List<Product> getWishList() {
    return wishList;
  }

  public void setWishList(List<Product> wishList) {
    this.wishList = wishList;
  }

  public List<Gift> getGifts() {
    return gifts;
  }

  public void setGifts(List<Gift> gifts) {
    this.gifts = gifts;
  }
}