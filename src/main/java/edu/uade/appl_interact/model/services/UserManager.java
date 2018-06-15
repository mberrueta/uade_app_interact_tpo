package edu.uade.appl_interact.model.services;

import edu.uade.appl_interact.data_access.dao.impl.UserDao;
import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.appl_interact.model.entities.User;

public class UserManager {
  private UserDao userDao;

  private static UserManager instance = null;

  private UserManager() {
    userDao = new UserDao();
  }

  public static UserManager getInstance() {
    if (instance == null) {
      instance = new UserManager();
    }
    return instance;
  }


}