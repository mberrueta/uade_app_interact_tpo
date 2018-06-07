package edu.uade.appl_interact.observers;

public abstract class EmailObserver {
  private EmailObservable observable;

  public abstract void update();

  public EmailObservable getObservable() {
    return observable;
  }

  public void setObservable(EmailObservable observable) {
    this.observable = observable;
  }
}
