// package edu.uade.appl_interact.model.dao;

// import java.util.List;

// import edu.uade.appl_interact.model.entities.GiftList;
// import edu.uade.appl_interact.model.factories.EntityManager;
// import junit.framework.TestCase;

// public final class GiftListTest extends TestCase {

//   public void testFindById() {
//     try {
//       GiftList result = EntityManager.getInstance().find(GiftList.class, 1);
//       assertEquals(result.getListName(), "matt");
//       assertEquals(result.getId().intValue(), 1);
//     } catch (Exception e) {
//       e.printStackTrace();
//       assertNull(e);
//     }
//   }

//   public void testGetByName() {
//     try {
//       GiftList result = EntityManager.getInstance().findBy(GiftList.class, "name", "matt");
//       assertEquals(result.getListName(), "matt");
//       assertEquals(result.getId().intValue(), 1);
//     } catch (Exception e) {
//       e.printStackTrace();
//       assertNull(e);
//     }
//   }

//   public void testCreate() {
//     try {
//       GiftList giftList = new GiftList();
//       giftList.setListName("qwerty");
//       EntityManager.getInstance().create(giftList);
//     } catch (Exception e) {
//       e.printStackTrace();
//       assertNull(e);
//     }  
//   }  

//   public void testUpdate() {
//     try {
//       EntityManager em = EntityManager.getInstance();
//       GiftList GiftList = new GiftList();
//       GiftList.setListName("qwerty");
//       EntityManager.getInstance().create(GiftList);
//       GiftList = em.findBy(GiftList.class, "name", "qwerty");
//       GiftList.setListName("querty updated");
//       em.update(GiftList);
//     } catch (Exception e) {
//       e.printStackTrace();
//       assertNull(e);
//     }  
//   }  

//   public void testDelete() {
//     try {
//       EntityManager em = EntityManager.getInstance();
//       GiftList GiftList = new GiftList();
//       GiftList.setListName("qwerty");
//       EntityManager.getInstance().create(GiftList);
//       GiftList = em.findBy(GiftList.class, "name", "qwerty");
//       em.delete(GiftList);
//     } catch (Exception e) {
//       e.printStackTrace();
//       assertNull(e);
//     }  
//   }  

//   public void testFindManyByName() {
//     try {
//       List<GiftList> result = EntityManager.getInstance().findManyBy(GiftList.class, "name", "matt");
//       assertEquals(result.get(0).getListName(), "matt");
//       assertEquals(result.get(0).getId().intValue(), 1);
//     } catch (Exception e) {
//       e.printStackTrace();
//       assertNull(e);
//     }
//   }

//   public void testFindManyLikeContainsName() {
//     try {
//       List<GiftList> result = EntityManager.getInstance().findManyLike(GiftList.class, "name", "matt");
//       assertEquals(result.get(0).getListName(), "matt");
//       assertEquals(result.get(0).getId().intValue(), 1);
//       result = EntityManager.getInstance().findManyLike(GiftList.class, "name", "er");
//       assertEquals(result.get(0).getListName(), "vero");
//       assertEquals(result.get(0).getId().intValue(), 2);
//     } catch (Exception e) {
//       e.printStackTrace();
//       assertNull(e);
//     }
//   }
// }