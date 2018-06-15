package edu.uade.appl_interact.observers;

public abstract class PaymentObserver {
  private PaymentObservable observable;

  public abstract void update();

  public PaymentObservable getObservable() {
    return observable;
  }

  public void setObservable(PaymentObservable observable) {
    this.observable = observable;
  }
}
