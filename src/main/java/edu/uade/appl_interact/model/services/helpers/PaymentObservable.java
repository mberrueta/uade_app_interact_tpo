package edu.uade.appl_interact.model.services.helpers;

import java.util.ArrayList;
import java.util.List;

import edu.uade.appl_interact.model.entities.Payment;

public abstract class PaymentObservable {
  private List<PaymentObserver> observers = new ArrayList<PaymentObserver>();

  public void add(PaymentObserver o) {
      observers.add(o);
  }

  public void remove(PaymentObserver o) {
    observers.remove(o);
  }

  protected void notifyAllObservers(){
      for (PaymentObserver observer : observers) {
          observer.update();
      }
  }

  abstract public Payment getPayment();
}
