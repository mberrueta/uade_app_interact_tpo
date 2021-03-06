package edu.uade.appl_interact.services;

import edu.uade.appl_interact.data_access.dao.impl.GiftListDao;
import edu.uade.appl_interact.data_access.dao.impl.SubscriptionDao;
import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.appl_interact.model.entities.Subscription;
import edu.uade.appl_interact.model.entities.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListService {

    private static ListService instance = null;
    private final ArrayList cachedList;
    private EmailService emailService;
    private GiftListDao listDao;
    private SubscriptionDao subscriptionDao;

    private ListService() {
        cachedList = new ArrayList();
        emailService = EmailService.getInstance();
        listDao = GiftListDao.getInstance();
        subscriptionDao = SubscriptionDao.getInstance();
    }

    public static ListService getInstance() {
        if (instance == null) {
            instance = new ListService();
        }
        return instance;
    }

    public void saveList(GiftList giftList) {
        EmailService.getInstance().subscriptionEmail(giftList);
        if (giftList.getId() != null) {
            updateList(giftList);
        } else {
            createList(giftList);
        }
    }

    private void updateList(GiftList giftList) {
        try {
            listDao.update(giftList);
            subscriptionDao.saveSubscriptions(giftList);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("BOOOOOM!");
        }
    }

    private void createList(GiftList giftList) {
        try {
            listDao.createList(giftList);
            subscriptionDao.saveSubscriptions(giftList);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("BOOOOOM!");
        }
    }

    public GiftList getListFromId(int id) {
        try {
            GiftList list =  listDao.findById(id);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<GiftList> getLoggedUserLists(User user) {
        try {
            return this.listDao.findManyBy("owner_id", String.valueOf(user.getId()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void getListWhereUserIsSubscriber(int userId) {
    }

    public void getListWhereUserIsOwner(int userId) {
    }

    public void unsubscribeFromList(int listId, int userId) {
        subscriptionDao.deleteFromUserAndList(listId, userId);
    }

    public void remove(int listId) {
    }

    public void pay(int usbscriptionId, float amount, Date date) {
    }

    public void deleteListFromId(int listId) {
        try {
            listDao.delete(listId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<GiftList> getSubscriptionsForLoggedUser(Integer id) {
        return listDao.getListWhereUserSubscribed(id);
    }
}