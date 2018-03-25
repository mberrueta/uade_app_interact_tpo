package edu.uade.appl_interact.model.factories;

import edu.uade.lib.db.Transaction;

public class EntityManager extends Base{
  private static EntityManager instance = null;
  protected EntityManager() {
     // Exists only to defeat instantiation.
  }

  public static EntityManager getInstance() {
     if(instance == null) {
        instance = new EntityManager();
     }
     return instance;
  }

  public Transaction getTransaction(){
    return Transaction.getInstance();
  }

  public Boolean persist(edu.uade.appl_interact.model.dao.Base object){
    System.out.println(object);
    return true;
  }

  public Boolean close(){
    return true;
  }
}