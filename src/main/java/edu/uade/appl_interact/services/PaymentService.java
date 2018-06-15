package edu.uade.appl_interact.services;

// import xxx;

import java.util.Date;

public class PaymentService {

    private static PaymentService instance = null;

    private PaymentService() {
    }

    public static PaymentService getInstance() {
        if (instance == null) {
            instance = new PaymentService();
        }
        return instance;
    }

    public void processPayment(int subscriptionId, float amount, Date date) {

    }
}