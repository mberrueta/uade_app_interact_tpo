package edu.uade.appl_interact.services;

import edu.uade.appl_interact.model.entities.GiftList;

public class EmailService {

  private static EmailService instance = null;

  private EmailService() {
  }

  public static EmailService getInstance() {
    if (instance == null) {
      instance = new EmailService();
    }
    return instance;
  }

  public void creationEmail(GiftList list){}
  public void completitionEmail(GiftList list){}
  public void dueDateEmail(GiftList list){}
}