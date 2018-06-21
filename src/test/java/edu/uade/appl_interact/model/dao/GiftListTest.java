package edu.uade.appl_interact.model.dao;

import java.util.List;

import edu.uade.appl_interact.data_access.dao.impl.GiftListDao;
import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.appl_interact.model.entities.User;
import junit.framework.TestCase;

public final class GiftListTest extends TestCase {

    public void testFindById() {
        try {
            GiftList result = GiftListDao.getInstance().findById(1);
            assertEquals(result.getListName(), "pp gift");
            assertEquals(result.getId().intValue(), 1);
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        }
    }

    public void testGetByName() {
        try {
            GiftList result = GiftListDao.getInstance().findBy("list_name", "pp gift");
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
            giftList.setOwner(dummyUser());
            GiftListDao.getInstance().create(giftList);
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        }
    }

    public void testUpdate() {
        try {
            GiftListDao em = GiftListDao.getInstance();
            GiftList giftList = new GiftList();
            giftList.setListName("qwerty");
            giftList.setOwner(dummyUser());
            em.create(giftList);
            giftList = em.findBy("list_name", "qwerty");
            giftList.setListName("qwerty updated");
            em.update(giftList);
            giftList = em.findBy("list_name", "qwerty updated");
            assertNotNull(giftList);
            assertEquals(giftList.getListName(), "qwerty updated");
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        }
    }

    public void testDelete() {
        try {
            GiftListDao em = GiftListDao.getInstance();
            GiftList giftList = new GiftList();
            giftList.setListName("qwerty");
            giftList.setOwner(dummyUser());
            em.create(giftList);
            giftList = em.findBy("list_name", "qwerty");
            em.delete(giftList.getId());
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        }
    }

    public void testFindManyByName() {
        try {
            List<GiftList> result = GiftListDao.getInstance().findManyBy("list_name", "pp gift");
            assertEquals(result.size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        }
    }

    public void testFindManyLikeContainsName() {
        try {
            List<GiftList> result = GiftListDao.getInstance().findManyLike("list_name", "gift");
            assertEquals(result.size(), 2);
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        }
    }

    public User dummyUser(){
        User tmp = new User();
        tmp.setId(1);
        return tmp;
    }
}