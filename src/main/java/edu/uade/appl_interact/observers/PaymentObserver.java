package edu.uade.appl_interact.observers;

import edu.uade.appl_interact.model.entities.Payment;

public abstract class PaymentObserver {
    private PaymentObservable observable;

    public abstract void update(Payment payment) throws Exception;

    public PaymentObservable getObservable() {
        return observable;
    }

    public void setObservable(PaymentObservable observable) {
        this.observable = observable;
    }
}
