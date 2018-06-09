package edu.uade.appl_interact.services;

import java.util.List;

public class UserService {

    private static UserService instance = null;
    public List cachedUsers;

    private UserService() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public boolean login(String userName, String password) {
        return false;
    }

    public void inviteUser(int listId, String mail) {
    }

    public void acceptUser(int listId, String mail) {
    }

    public void addToList(int listId, int userId) {
    }

    public void createUser(String mail, String name) {
    }
}