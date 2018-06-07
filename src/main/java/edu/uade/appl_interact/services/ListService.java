package edu.uade.appl_interact.services;

import java.util.ArrayList;
import java.util.Date;

public class ListService {

    private static ListService instance = null;
    private final ArrayList cachedList;
    private EmailService emailService;

    private ListService() {
        cachedList = new ArrayList();
        emailService = EmailService.getInstance();
    }

    public static ListService getInstance() {
        if (instance == null) {
            instance = new ListService();
        }
        return instance;
    }

    public void createList(String name, int userId) {
    }

    public void getListFromId(int id) {
    }

    public void getListWhereUserIsSubscriber(int userId) {
    }

    public void getListWhereUserIsOwner(int userId) {
    }

    public void unsubscribeFromList(int listId, int userId) {
    }

    public void remove(int listId) {
    }

    public void pay(int usbscriptionId, float amount, Date date) {
    }
}