package edu.uade.controller;

import edu.uade.appl_interact.Main;
import edu.uade.appl_interact.View.*;
import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.appl_interact.model.entities.Payment;
import edu.uade.appl_interact.model.entities.Subscription;
import edu.uade.appl_interact.model.entities.User;
import edu.uade.appl_interact.services.ListService;
import edu.uade.appl_interact.services.PaymentService;
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
    private UserSubscriptionsView userSubscriptios;
    private UserPaymentList paymentList;
    private PaymentService paymentService;
    private Main main;


    public MainController(JFrame frame, User loggedUser) {
        this.frame = frame;
        this.loggedUser = loggedUser;
        this.listCreationForm = new ListCreationForm();
        this.listCreationForm.setController(this);
        this.paymentList = new UserPaymentList();
        paymentService = PaymentService.getInstance();
        this.userForm = new UserForm();
        userService = UserService.getInstance();
        userForm.setUserController(this);
        userLists = new UserListsView(this);
        userSubscriptios = new UserSubscriptionsView(this);
        listService = ListService.getInstance();
    }

    public void setMainMenu(Main main) {
        this.main = main;
    }

    @Override
    public void deleteAccount() {
        this.userService.deleteAccount(this.loggedUser.getId());
        this.logout();
    }

    // TODO Add action permormed Events.
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
        dashboard.addToCardLayout(userSubscriptios, "userSubscriptions");
        dashboard.addToCardLayout(paymentList, "userPaymentList");
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
    public boolean saveNewUser(String name, String userEmail, String birthDay ,String password) {
        return false;
    }

    @Override
    public boolean saveUser(String name, String userEmail, String birthday, String password, int id) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        User user  = new User();
        user.setName(name);
        user.setEmail(userEmail);
        user.setPassword(password);
        user.setId(id);
        UserService manager = UserService.getInstance();
        try {
            user.setBirthDate(format.parse(birthday));
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


    public void saveList(String name, String email, String targetName, String expectedAmount, String dueDate, ArrayList<String[]> subscriptions, int listId) {
        GiftList list = new GiftList();
        if (listId >0 ) {
            list.setId(listId);
        }
        list.setListName(name);
        list.setToMail(email);
        list.setToName(targetName);
        list.setExpectedAmount(Float.valueOf(expectedAmount));
        list.setOwner(loggedUser);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (String[] subscription :subscriptions) {
            Subscription subscriptionObj = new Subscription();
            User user = UserService.getInstance().getUserFromId(Integer.parseInt(subscription[0]));
            subscriptionObj.setUser(user);
            subscriptionObj.setActive(subscription[3] == "true" ? true : false);
            if (!subscription[4].isEmpty()) {
                subscriptionObj.setId(Integer.parseInt(subscription[4]));
            }
            list.addGifter(subscriptionObj);
        }
        try {
            list.setDueDate(format.parse(dueDate));
            listService.saveList(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dashboard.showDefault();
    }

    public void redirectToLoggedUserLists() {
        List<GiftList> userGiftLists = listService.getLoggedUserLists(loggedUser);
        this.userLists.removeAll();
        this.dashboard.revalidate();
        boolean loadedLists = false;
        for( GiftList userList : userGiftLists) {
            loadedLists = true;
            userLists.addItem(userList.getId(), userList.getListName(), String.valueOf(userList.getCurrentAmount()), userList.getDueDate().toString());
        }
        if (loadedLists) {
            dashboard.showPanel("userLists");
        } else {
            dashboard.showDefault();
        }
    }

    public void redirectToListEdition(int listId) {
        cleanValues();
        GiftList list = listService.getListFromId(listId);
        ArrayList<String[]>  subscriptions =new ArrayList<>();
        try {
            for (Subscription subscription : list.getGifters()) {
                String[] value = new String[]{String.valueOf(subscription.getUser().getId()), subscription.getUser().getName(), subscription.getUser().getEmail(), String.valueOf(subscription.isActive()), String.valueOf(subscription.getId())};
                System.out.println(value);
                subscriptions.add( value);
            }
        } catch (Exception e) {
            System.out.println("Se pudrio todo");
        }
        listCreationForm.fillValues(list.getId(), list.getListName(), list.getToMail(), list.getToName(), String.valueOf(list.getExpectedAmount()), list.getDueDate().toString(), subscriptions);
        dashboard.showPanel("CreateNew");
    }

    public void cleanValues() {
        listCreationForm.clearValues();
    }

    public void onActionPerformed() {
        dashboard.showDefault();
    }

    public void onListDelete(int listId) {
        this.listService.deleteListFromId(listId);
        this.redirectToLoggedUserLists();
    }

    public void unsubscribe(int listId) {
        this.listService.unsubscribeFromList(listId, this.loggedUser.getId());
        this.redirectToUserSubscriptions();
    }

    public void redirectToUserSubscriptions() {
        List<GiftList> result = listService.getSubscriptionsForLoggedUser(loggedUser.getId());
        this.userSubscriptios.removeAll();
        this.dashboard.revalidate();
        boolean loadedLists = false;
        for( GiftList subscribedList : result) {
            loadedLists = true;
            userSubscriptios.addItem(subscribedList.getId(), subscribedList.getListName());
        }
        if (loadedLists) {
            dashboard.showPanel("userSubscriptions");
        } else {
            dashboard.showDefault();
        }
    }

    public void redirectToUserPaymentList() {
        ArrayList<Payment> payments = paymentService.getUserPayments(loggedUser.getId());
        for (Payment payment : payments) {
            paymentList.addItem(String.valueOf(payment.getAmount()), payment.getDate().toString(), String.valueOf(payment.getSubscriptionId()));
        }
        dashboard.showPanel("userPaymentList");
    }

    public void logout() {
        this.loggedUser = null;
        main.OnUserLogout();
    }
}
