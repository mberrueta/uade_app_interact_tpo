package edu.uade.appl_interact.model.entities;

import java.util.List;

public class Person extends Base {

  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String address;
  private User user;
  private List<Role> roles;
  private List<GiftList> giftLists;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public List<GiftList> getGiftLists() {
    return giftLists;
  }

  public void setGiftLists(List<GiftList> giftLists) {
    this.giftLists = giftLists;
  }
}