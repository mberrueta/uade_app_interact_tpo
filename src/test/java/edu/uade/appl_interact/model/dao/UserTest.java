package edu.uade.appl_interact.model.dao;

import java.util.List;

import edu.uade.appl_interact.model.entities.User;
import edu.uade.appl_interact.model.factories.EntityManager;
import junit.framework.TestCase;

public final class UserTest extends TestCase {

  public void testFindById() {
    try {
      User result = EntityManager.getInstance().find(User.class, 1);
      assertEquals(result.getName(), "matt");
      assertEquals(result.getId().intValue(), 1);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }
  }

  public void testGetByName() {
    try {
      User result = EntityManager.getInstance().findBy(User.class, "name", "matt");
      assertEquals(result.getName(), "matt");
      assertEquals(result.getId().intValue(), 1);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }
  }

  public void testCreate() {
    try {
      User user = new User();
      user.setName("qwerty");
      EntityManager.getInstance().create(user);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }  
  }  

  public void testUpdate() {
    try {
      EntityManager em = EntityManager.getInstance();
      User user = new User();
      user.setName("qwerty");
      EntityManager.getInstance().create(user);
      user = em.findBy(User.class, "name", "qwerty");
      user.setName("querty updated");
      em.update(user);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }  
  }  

  public void testDelete() {
    try {
      EntityManager em = EntityManager.getInstance();
      User user = new User();
      user.setName("qwerty");
      EntityManager.getInstance().create(user);
      user = em.findBy(User.class, "name", "qwerty");
      em.delete(user);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }  
  }  

  public void testFindManyByName() {
    try {
      List<User> result = EntityManager.getInstance().findManyBy(User.class, "name", "matt");
      assertEquals(result.get(0).getName(), "matt");
      assertEquals(result.get(0).getId().intValue(), 1);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }
  }

  public void testFindManyLikeContainsName() {
    try {
      List<User> result = EntityManager.getInstance().findManyLike(User.class, "name", "matt");
      assertEquals(result.get(0).getName(), "matt");
      assertEquals(result.get(0).getId().intValue(), 1);
      result = EntityManager.getInstance().findManyLike(User.class, "name", "er");
      assertEquals(result.get(0).getName(), "vero");
      assertEquals(result.get(0).getId().intValue(), 2);
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }
  }
}