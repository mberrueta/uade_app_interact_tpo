package edu.uade.appl_interact.model.services.helpers;

public abstract class PaymentObserver {
  protected PaymentObservable observable;

  public abstract void update();

  public PaymentObservable getObservable() {
    return observable;
  }

  public void setObservable(PaymentObservable observable) {
    this.observable = observable;
  }
}
