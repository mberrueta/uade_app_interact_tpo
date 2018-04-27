package edu.uade.appl_interact.model.entities;

import java.util.List;

public class Person extends Base {

  private String name;
  private String email;
  private String password;
  private List<Role> roles;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
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

  public Boolean validPassword(String password){
    // TODO: encript and check
    return true;
  }
}