package edu.uade.appl_interact.model.dao;

import java.util.Date;
import java.util.List;

import edu.uade.appl_interact.data_access.dao.impl.PaymentDao;
import edu.uade.appl_interact.model.entities.Payment;
import junit.framework.TestCase;

public final class PaymentTest extends TestCase {


    public void testFindById() {
        try {
            Payment result = PaymentDao.getInstance().findById(1);
            assertEquals(result.getAmount(), 12.21f);
            assertEquals(result.getId(), new Integer(1));
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        }
    }

    public void testCreate() {
        try {
            Payment payment = dummyPayment();
            payment.setAmount(888f);
            Integer result = PaymentDao.getInstance().create(payment);
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        }
    }

    public void testUpdate() {
        try {
            Payment payment = PaymentDao.getInstance().findById(2);
            payment.setAmount(1116f);
            PaymentDao.getInstance().update(payment);
            payment = PaymentDao.getInstance().findById(2);
            assertEquals(payment.getAmount(), 1116f);
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        }
    }

    public void testDelete() {
        try {
            Payment payment = dummyPayment();
            PaymentDao.getInstance().create(payment);
            payment = PaymentDao.getInstance().findBy("amount", "666");
            PaymentDao.getInstance().delete(payment.getId());
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        }
    }

    public void testFindManyByPayer() {
        try {
            List<Payment> result = PaymentDao.getInstance().findManyBy("id", "2");
            assertEquals(result.size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        }
    }

    private Payment dummyPayment() {
        Payment payment = new Payment();
        payment.setAmount(666f);
        payment.setSubscriptionId(1);
        payment.setDate(new Date());
        return payment;
    }

}