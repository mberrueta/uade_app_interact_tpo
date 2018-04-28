package edu.uade.appl_interact.model.services;

import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.appl_interact.model.entities.User;

public class ListManager {

  private static ListManager instance = null;

  private ListManager() {
  }

  public static ListManager getInstance() {
    if (instance == null) {
      instance = new ListManager();
    }
    return instance;
  }

  public GiftList createList(String name, User user){
    return new GiftList(name, user);
  }

  public void addUserToList(User admin, User user, GiftList list){
    //TODO: check admin owner list
    list.getGifters().add(user);
  }

  public void removeUserToList(User admin, User user, GiftList list){
    //TODO: check admin owner list
    list.getGifters().remove(user);
  }
}