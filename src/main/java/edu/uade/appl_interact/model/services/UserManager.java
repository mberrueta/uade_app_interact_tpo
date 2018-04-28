package edu.uade.appl_interact.model.services;

import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.appl_interact.model.entities.User;

public class UserManager {

  private static UserManager instance = null;

  private UserManager() {
  }

  public static UserManager getInstance() {
    if (instance == null) {
      instance = new UserManager();
    }
    return instance;
  }

  public Boolean login(String userName, String password){
    return true;
  }

  public void inviteUser(GiftList list, String mail){
    //TODO:: Send Invite
  }

  public void acceptUser(GiftList list, String mail){
    //TODO:: add to list and create if not exist
  }

  private void addToList(GiftList list, User user){}
  private void createUser(User user){}
}