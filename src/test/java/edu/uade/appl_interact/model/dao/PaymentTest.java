package edu.uade.appl_interact.model.dao;

import java.util.Date;
import java.util.List;

import edu.uade.appl_interact.model.entities.Payment;
import edu.uade.appl_interact.model.factories.EntityManager;
import junit.framework.TestCase;

public final class PaymentTest extends TestCase {

  private final EntityManager em = EntityManager.getInstance();

  public void testFindById() {
    try {
      Payment result = em.find(Payment.class, 1);
      assertEquals(result.getAmount(), 12.21f);
      assertEquals(result.getId().intValue(), 1);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }
  }

  public void testGetByUser() {
    try {
      Payment result = em.findBy(Payment.class, "payer_id", 1);
      assertEquals(result.getAmount(), 12.21f);
      assertEquals(result.getId().intValue(), 1);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }
  }

  public void testCreate() {
    try {
      Payment payment = dummyPayment();
      payment.setAmount(888f);
      em.create(payment);
      Payment result = em.findBy(Payment.class, "amount", 888);
      em.delete(payment, result.getId());
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }  
  }  

  public void testUpdate() {
    try {
      Payment payment = em.findBy(Payment.class, "id", "5");
      payment.setAmount(1116f);
      em.update(payment);
      payment = em.findBy(Payment.class, "id", "5");
      assertEquals(payment.getAmount(), 1116f);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }  
  }  

  public void testDelete() {
    try {
      Payment payment = dummyPayment();
      em.create(payment);
      payment = em.findBy(Payment.class, "amount", "666");
      em.delete(payment, payment.getId());
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }  
  }  

  public void testFindManyByPayer() {
    try {
      List<Payment> result = em.findManyBy(Payment.class, "payer_id", 2);
      assertEquals(result.size(), 3);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }
  }

  private Payment dummyPayment(){
    Payment payment = new Payment();
    payment.setAmount(666f);
    payment.setDate(new Date());
    payment.setGiftListId(1);
    payment.setPayer_id(1);
    return payment;
  }

}