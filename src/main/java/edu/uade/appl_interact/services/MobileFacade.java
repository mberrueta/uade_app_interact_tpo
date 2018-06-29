package edu.uade.appl_interact.services;

import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.appl_interact.model.entities.User;

import java.util.Date;

class MobileFacade {

    public MobileFacade() {
    }

    private ListService listService;
    private UserService userService;

    public User createUser() {
        return null;
    }

    public GiftList createList(String listName, Date dueDate, String toName, String toMail, int ownerId,
                               Float expectedAmount) {
        return null;

    }

    public GiftList getUserLists(int userId) {
        return null;

    }

    public GiftList getListsWithSubscription() {
        return null;

    }

    public boolean unsubscribeFromList(int userId, int listId) {
        return false;
    }
}