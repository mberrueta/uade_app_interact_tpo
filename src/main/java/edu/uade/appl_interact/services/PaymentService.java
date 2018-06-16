package edu.uade.appl_interact.services;

import edu.uade.appl_interact.data_access.dao.impl.PaymentDao;
import edu.uade.appl_interact.data_access.dao.impl.SubscriptionDao;
import edu.uade.appl_interact.model.entities.Payment;
import edu.uade.appl_interact.model.entities.Subscription;
import edu.uade.appl_interact.observers.PaymentObservable;

import java.util.Date;

public class PaymentService extends PaymentObservable {

    private static PaymentService instance = null;

    private PaymentService() {
    }

    public static PaymentService getInstance() {
        if (instance == null) {
            instance = new PaymentService();
        }
        return instance;
    }

    public void processPayment(int subscriptionId, float amount, Date date) throws Exception {
        validateSubscription(subscriptionId);

        Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setDate(date);
        payment.setSubscriptionId(subscriptionId);
        Integer id = PaymentDao.getInstance().create(payment);
        payment.setId(id);
        notifyAllObservers(payment);
    }

    private void validateSubscription(int subscriptionId) throws Exception {
        Subscription result = SubscriptionDao.getInstance().findById(subscriptionId);
        if (result == null) {
            throw new Exception(String.format("Subscription with id %s, not found", subscriptionId));
        }
    }
}
