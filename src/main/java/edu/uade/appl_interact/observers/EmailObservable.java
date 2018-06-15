package edu.uade.appl_interact.observers;

import edu.uade.appl_interact.services.Email;

import java.util.ArrayList;
import java.util.List;

public abstract class EmailObservable {
  private final List<EmailObserver> observers = new ArrayList<EmailObserver>();

  public void add(EmailObserver o) {
      observers.add(o);
  }

  public void remove(EmailObserver o) {
    observers.remove(o);
  }

  protected void notifyAllObservers(){
      for (EmailObserver observer : observers) {
          observer.update();
      }
  }

  abstract public Email getEmail();
}
