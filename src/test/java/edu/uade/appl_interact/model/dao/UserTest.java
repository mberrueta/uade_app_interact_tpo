package edu.uade.appl_interact.model.dao;

import java.util.List;

import edu.uade.appl_interact.model.entities.User;
import edu.uade.appl_interact.model.factories.EntityManager;
import junit.framework.TestCase;

public final class UserTest extends TestCase {

  public void testFindById() {
    try {
      User result = EntityManager.getInstance().find(User.class, 1);
      assertEquals(result.getId().intValue(), 1);
      assertEquals(result.getName(), "marian");
      assertEquals(result.getEmail(), "mariano.grimaux@gmail.com");

      result = EntityManager.getInstance().find(User.class, 2);
      assertEquals(result.getId().intValue(), 2);
      assertEquals(result.getName(), "matt");
      assertEquals(result.getEmail(), "matiasberrueta@gmail.com");
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }
  }

  public void testGetByName() {
    try {
      User result = EntityManager.getInstance().findBy(User.class, "name", "marian");
      assertEquals(result.getId().intValue(), 1);
      assertEquals(result.getName(), "marian");
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }
  }

  public void testCreate() {
    try {
      User user = new User();
      user.setName("qwerty");
      user.setEmail("qwerty@abcde.com");
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
      em.create(user);
      user = em.findBy(User.class, "name", "qwerty");
      user.setName("qwerty updated");
      em.update(user);
      user = em.findBy(User.class, "name", "qwerty updated");
      assertNotNull(user);
      assertEquals(user.getName(), "qwerty updated");
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
      em.create(user);
      user = em.findBy(User.class, "name", "qwerty");
      em.delete(user, user.getId());

      List<User> list = em.findManyBy(User.class, "id", user.getId().toString());
      assertEquals(0, list.size());

    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }  
  }  

  public void testFindManyByName() {
    try {
      List<User> result = EntityManager.getInstance().findManyBy(User.class, "name", "marian");
      assertEquals(1, result.size());
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }
  }

  public void testFindManyLikeContainsName() {
    try {
      List<User> result = EntityManager.getInstance().findManyLike(User.class, "name", "ma");
      assertEquals(2, result.size());
    } catch (Exception e) {
      e.printStackTrace();
      assertNull(e);
    }
  }
}