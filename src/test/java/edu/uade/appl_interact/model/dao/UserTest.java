package edu.uade.appl_interact.model.dao;

import edu.uade.appl_interact.data_access.dao.impl.UserDao;
import edu.uade.appl_interact.model.entities.User;
import junit.framework.TestCase;

import java.util.List;

public final class UserTest extends TestCase {

    public void testFindById() {
        try {
            User result = UserDao.getInstance().findById(1);
            assertEquals(result.getId().intValue(), 1);
            assertEquals(result.getName(), "marian");
            assertEquals(result.getEmail(), "mariano.grimaux@gmail.com");

            result = UserDao.getInstance().findById(2);
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
            User result = UserDao.getInstance().findBy("name", "marian");
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
            UserDao.getInstance().create(user);
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        }
    }

    public void testUpdate() {
        try {
            UserDao em = UserDao.getInstance();
            User user = new User();
            user.setName("qwerty");
            em.create(user);
            user = em.findBy("name", "qwerty");
            user.setName("qwerty updated");
            em.update(user);
            user = em.findBy("name", "qwerty updated");
            assertNotNull(user);
            assertEquals(user.getName(), "qwerty updated");
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        }
    }

    public void testDelete() {
        try {
            UserDao em = UserDao.getInstance();
            User user = new User();
            user.setName("qwerty");
            em.create(user);
            user = em.findBy("name", "qwerty");
            em.delete(user.getId());

            List<User> list = em.findManyBy("id", user.getId().toString());
            assertEquals(0, list.size());

        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        }
    }

    public void testFindManyByName() {
        try {
            List<User> result = UserDao.getInstance().findManyBy("name", "marian");
            assertEquals(1, result.size());
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        }
    }

    public void testFindManyLikeContainsName() {
        try {
            List<User> result = UserDao.getInstance().findManyLike("name", "ma");
            assertEquals(2, result.size());
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        }
    }
}