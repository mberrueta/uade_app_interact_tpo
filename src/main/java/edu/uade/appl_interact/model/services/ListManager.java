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

}