package edu.uade.appl_interact.services;

import edu.uade.appl_interact.data_access.dao.impl.UserDao;
import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.appl_interact.model.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static UserService instance = null;
    public List cachedUsers;
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public Boolean login(String userEmail, String password) {
        try {
            User user = this.userDao.findBy("email", userEmail);
            if (user.getPassword().equals(password)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void inviteUser(GiftList list, String mail) {
        //TODO:: Send Invite
    }

    public ArrayList<String[]> findMatchesByName(String partialName) {
        ArrayList<String[]> matches=  new ArrayList<>();
        try {
            List<User> results = userDao.findManyLike("name", partialName);

            for (User user : results) {
                String[] data = {user.getId().toString(), user.getName(), user.getEmail()};
                matches.add(data);
            }
        } catch (Exception e) {
        }
        return matches;
    }

    public  User getUserFromEmail(String email) {
        try {
            return  this.userDao.findBy("email", email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void acceptUser(GiftList list, String mail) {
        //TODO:: add to list and create if not exist
    }

    private void addToList(GiftList list, User user) {
    }


    private void createUser(User user) {
    }

    public void saveUser(User user) throws Exception {
        if (user.getId() == null) {
            userDao.create(user);
        } else {
            userDao.update(user);
        }
    }

    public User getUserFromId(int id) {
        try {
            return userDao.findById(id);
        } catch (Exception e) {
            return null;
        }
    }
}