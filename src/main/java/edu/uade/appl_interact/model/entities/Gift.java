package edu.uade.appl_interact.model.entities;

public class Gift extends Base {

  private Integer product_id;
  private Integer person_id;
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

  public Integer getProduct_id() {
    return product_id;
  }

  public void setProduct_id(Integer product_id) {
    this.product_id = product_id;
  }

  public Integer getPerson_id() {
    return person_id;
  }

  public void setPerson_id(Integer person_id) {
    this.person_id = person_id;
  }
}