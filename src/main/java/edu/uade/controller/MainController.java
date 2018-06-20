package edu.uade.controller;

import edu.uade.appl_interact.Main;
import edu.uade.appl_interact.View.ListCreationForm;
import edu.uade.appl_interact.View.UserDashboard;
import edu.uade.appl_interact.View.UserForm;
import edu.uade.appl_interact.View.UserListsView;
import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.appl_interact.model.entities.User;
import edu.uade.appl_interact.services.ListService;
import edu.uade.appl_interact.services.UserService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MainController implements ActionListener, IuserController {
    private final UserService userService;
    private JFrame frame;
    private User loggedUser;
    private UserForm userForm;
    private ListCreationForm listCreationForm;
    private UserDashboard dashboard;
    private UserListsView userLists;
    private ListService listService;


    public MainController(JFrame frame, User loggedUser) {
        this.frame = frame;
        this.loggedUser = loggedUser;
        this.listCreationForm = new ListCreationForm();
        this.listCreationForm.setController(this);
        this.userForm = new UserForm();
        userService = UserService.getInstance();
        userForm.setUserController(this);
        userLists = new UserListsView();
        listService = ListService.getInstance();
    }

    // TODO Add action permformed Events.
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void updateView() {
        renderMain();
    }

    @Override
    public void setMain(Main main) {
        renderMain();
    }

    @Override
    public void renderMain() {
        dashboard = new UserDashboard(loggedUser.getName());
        dashboard.setController(this);
        dashboard.addToCardLayout(listCreationForm, "CreateNew");
        dashboard.addToCardLayout(userForm, "editUser");
        dashboard.addToCardLayout(userLists, "userLists");
        frame.setContentPane(dashboard);
        frame.revalidate();
        frame.repaint();
    }

    public void preFillUserForm() {
        this.userForm.setUsrId(loggedUser.getId());
        this.userForm.addNameInfo(loggedUser.getName());
        this.userForm.addPasswordInfo(loggedUser.getPassword());
        this.userForm.addEmailInfo(loggedUser.getEmail());
    }

    @Override
    public boolean saveNewUser(String name, String userEmail, String password) {
        return false;
    }

    @Override
    public boolean saveUser(String name, String userEmail, String password, int id) {
        User user  = new User();
        user.setName(name);
        user.setEmail(userEmail);
        user.setPassword(password);
        user.setId(id);
        UserService manager = UserService.getInstance();
        try {
            manager.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // UPDATE USER INFO
        this.loggedUser = user;
        this.renderMain();
        return false;
    }

    @Override
    public boolean userNameInUse() {
        return false;
    }

    public ArrayList<String[]> getUserInfoForList(String text) {
        return userService.findMatchesByName(text);
    }


    public void saveList(String name, String email, String targetName, String expectedAmount, String dueDate, ArrayList<String> userIdsToAdd) {
        GiftList list = new GiftList();
        list.setListName(name);
        list.setToMail(email);
        list.setToName(targetName);
        list.setExpectedAmount(Float.valueOf(expectedAmount));
        list.setOwner(loggedUser);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        for (String userId :userIdsToAdd) {
            User user = UserService.getInstance().getUserFromId(Integer.parseInt(userId));
            if (user != null) {
                list.addGifter(user);
            }
        }
        try {
            list.setDueDate(format.parse(dueDate));
            listService.saveList(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void redirectToLoggedUserLists() {
        List<GiftList> userGiftLists = listService.getLoggedUserLists(loggedUser);
        for( GiftList userList : userGiftLists) {
            userLists.addItem(userList.getId(), userList.getListName(), String.valueOf(userList.getCurrentAmount()));
        }
        dashboard.showPanel("userLists");
    }

    public void onActionPerformed() {
        dashboard.showDefault();
    }
}
