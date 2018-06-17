package edu.uade.appl_interact.observers;

import java.util.ArrayList;
import java.util.List;

import edu.uade.appl_interact.model.entities.Payment;
import org.apache.log4j.Logger;

public abstract class PaymentObservable {
    private static final Logger log = Logger.getLogger("PaymentObservable");

    private final List<PaymentObserver> observers = new ArrayList<>();

    public void add(PaymentObserver o) {
        observers.add(o);
    }

    public void remove(PaymentObserver o) {
        observers.remove(o);
    }

    protected void notifyAllObservers(Payment payment) {
        for (PaymentObserver observer : observers) {
            try {
                observer.update(payment);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("fail notify observer", e);
            }
        }
    }
}
