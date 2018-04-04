package edu.uade.appl_interact.model.entities;

public class Gift extends Base {

  private Product product;
  private GiftList giftList;
  private Float percent;
  private Person from;

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public GiftList getGiftList() {
    return giftList;
  }

  public void setGiftList(GiftList giftList) {
    this.giftList = giftList;
  }

  public Float getPercent() {
    return percent;
  }

  public void setPercent(Float percent) {
    this.percent = percent;
  }

  public Person getFrom() {
    return from;
  }

  public void setFrom(Person from) {
    this.from = from;
  }
}