package edu.uade.appl_interact.model.entities;

public class Role {

  private String name;
  private GiftList list;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GiftList getList() {
    return list;
  }

  public void setList(GiftList list) {
    this.list = list;
  }
}