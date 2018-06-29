package edu.uade.appl_interact.services;

import edu.uade.appl_interact.data_access.dao.impl.PaymentDao;
import edu.uade.appl_interact.data_access.dao.impl.SubscriptionDao;
import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.appl_interact.model.entities.Payment;
import edu.uade.appl_interact.model.entities.Subscription;
import edu.uade.appl_interact.observers.PaymentObservable;

import java.util.ArrayList;
import java.util.Date;

public class PaymentService extends PaymentObservable {

    private static PaymentService instance = null;
    private PaymentDao paymentDao;

    private PaymentService() {
        paymentDao = PaymentDao.getInstance();
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

        GiftList giftList = SubscriptionDao.getInstance().getGiftList(subscriptionId);
        if(giftList.collected())
        {
            giftList.setDelivered(true);
            EmailService.getInstance().completitionEmail(giftList);
            ListService.getInstance().saveList(giftList);
        }
    }

    private void validateSubscription(int subscriptionId) throws Exception {
        Subscription result = SubscriptionDao.getInstance().findById(subscriptionId);
        if (result == null) {
            throw new Exception(String.format("Subscription with id %s, not found", subscriptionId));
        }
    }

    public ArrayList<Payment> getUserPayments(int userId) {
        return paymentDao.fromUserId(userId);
    }
}
