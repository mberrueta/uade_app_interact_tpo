package edu.uade.appl_interact.services;

import edu.uade.appl_interact.model.entities.User;

import java.util.List;

public class UserService {

    private static UserService instance = null;
    public List cachedUsers;

    public UserService() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public User getUser(String userName, String password) {
        // TODO User Dao to getRealUser;
        User user = new User();
        user.setName("Pepe Jamaica");
        user.setUsername(userName);
        return user;
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