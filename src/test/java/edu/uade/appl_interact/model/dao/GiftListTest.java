package edu.uade.appl_interact.model.dao;

import java.util.List;

import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.appl_interact.model.factories.EntityManager;
import junit.framework.TestCase;

public final class GiftListTest extends TestCase {

  public void testFindById() {
    try {
      GiftList result = EntityManager.getInstance().find(GiftList.class, 1);
      assertEquals(result.getListName(), "pp gift");
      assertEquals(result.getId().intValue(), 1);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }
  }

  public void testGetByName() {
    try {
      GiftList result = EntityManager.getInstance().findBy(GiftList.class, "list_name", "pp gift");
      assertEquals(result.getListName(), "pp gift");
      assertEquals(result.getId().intValue(), 1);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }
  }

  public void testCreate() {
    try {
      GiftList giftList = new GiftList();
      giftList.setListName("qwerty");
      EntityManager.getInstance().create(giftList);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }  
  }  

  public void testUpdate() {
    try {
      EntityManager em = EntityManager.getInstance();
      GiftList giftList = new GiftList();
      giftList.setListName("qwerty");
      em.create(giftList);
      giftList = em.findBy(GiftList.class, "list_name", "qwerty");
      giftList.setListName("qwerty updated");
      em.update(giftList);
      giftList = em.findBy(GiftList.class, "list_name", "qwerty updated");
      assertNotNull(giftList);
      assertEquals(giftList.getListName(), "qwerty updated");
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }  
  }  

  public void testDelete() {
    try {
      EntityManager em = EntityManager.getInstance();
      GiftList giftList = new GiftList();
      giftList.setListName("qwerty");
      em.create(giftList);
      giftList = em.findBy(GiftList.class, "list_name", "qwerty");
      em.delete(giftList, giftList.getId());
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }  
  }  

  public void testFindManyByName() {
    try {
      List<GiftList> result = EntityManager.getInstance().findManyBy(GiftList.class, "list_name", "pp gift");
      assertEquals(result.size(), 1);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }
  }

  public void testFindManyLikeContainsName() {
    try {
      List<GiftList> result = EntityManager.getInstance().findManyLike(GiftList.class, "list_name", "gift");
      assertEquals(result.size(), 2);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }
  }
}