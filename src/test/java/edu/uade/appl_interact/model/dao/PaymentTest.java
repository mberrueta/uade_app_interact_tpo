package edu.uade.appl_interact.model.dao;

import java.util.Date;
import java.util.List;

import edu.uade.appl_interact.model.entities.Payment;
import edu.uade.appl_interact.model.factories.EntityManager;
import junit.framework.TestCase;

public final class PaymentTest extends TestCase {

  public void testFindById() {
    try {
      Payment result = EntityManager.getInstance().find(Payment.class, 1);
      assertEquals(result.getAmount(), 12.21f);
      assertEquals(result.getId().intValue(), 1);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }
  }

  public void testGetByName() {
    try {
      Payment result = EntityManager.getInstance().findBy(Payment.class, "amount", "12.21");
      assertEquals(result.getAmount(), 12.21);
      assertEquals(result.getId().intValue(), 1);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }
  }

  public void testCreate() {
    try {
      Payment payment = new Payment();
      payment.setAmount(666f);
      payment.setDate(new Date());
      EntityManager.getInstance().create(payment);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }  
  }  

  public void testUpdate() {
    try {
      EntityManager em = EntityManager.getInstance();
      Payment payment = new Payment();
      payment.setAmount(666f);
      payment.setDate(new Date());
      em.create(payment);
      payment = em.findBy(Payment.class, "amoount", "666");
      payment.setAmount(999f);
      em.update(payment);
      payment = em.findBy(Payment.class, "amoount", "999");
      assertEquals(payment.getAmount(), 999);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }  
  }  

  public void testDelete() {
    try {
      EntityManager em = EntityManager.getInstance();
      Payment payment = new Payment();
      payment.setAmount(666f);
      em.create(payment);
      payment = em.findBy(Payment.class, "amount", "666");
      em.delete(payment, payment.getId());
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }  
  }  

  public void testFindManyByName() {
    try {
      List<Payment> result = EntityManager.getInstance().findManyBy(Payment.class, "payer_id", "1");
      assertEquals(result.size(), 3);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }
  }
}