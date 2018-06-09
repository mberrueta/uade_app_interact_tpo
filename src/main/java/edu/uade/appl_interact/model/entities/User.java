package edu.uade.appl_interact.model.entities;

public class User {

  private Integer id;
  private String name;
  private String email;
  private String password;
  private String userName;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean validPassword(String password) {
    // TODO: encript and check
    return true;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

    public void setUsername(String userName) {
      this.userName = userName;
    }

    public String getUserName() {
      return userName;
    }
}